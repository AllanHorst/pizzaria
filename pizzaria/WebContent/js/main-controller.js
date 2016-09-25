angular.module('mainApp', ['myAutoComplete'])

.constant("tamanhos", [
		{'id': 1, 'descricao': 'pequena'},
		{'id': 2, 'descricao': 'média'},
		{'id': 3, 'descricao': 'grande'},
	]
)
.controller('MainController', ['$scope', 'tamanhos', function($scope, tamanhos){
	$scope.tamanhos = tamanhos;
	$scope.listaPedidos = [];

	function inicializarPedido() {
		$scope.pedido = {
			listaItens: []
		}
	}
	inicializarPedido();

	function listarPedidos() {
		$.post("listar-pedidos", {}, function(data) {
			$scope.listaPedidos = data
			$scope.$apply();
		})
	}

	listarPedidos();

	$.post("listar-clientes", {}, function(data) {
		$scope.listaClientes = data;
		$scope.$apply();
	});

	$.post("listar-sabores", {}, function(data) {
		$scope.listaSabores = data;
		$scope.$apply();
	})

	$scope.obterTamanho = function(tam) {
		if (tam == 1) {
			return "pequena";
		}
		if (tam == 2) {
			return "média"
		}
		if (tam == 3) {
			return "Grande"
		}
	}

	function inicializarItem() {
		$scope.itemPedido = {
			quantidade: 1,
			tamanho: tamanhos[0],
			listaSabores: []
		}
		$scope.sabor1 = {}
		$scope.sabor2 = {}
		$scope.sabor3 = {}
		$scope.sabor4 = {}
	}

	inicializarItem();

	$scope.inserirItem = function() {
		var listaSabores = []

		for (var i = 1; i <= 4; i++) {
			if ($scope['sabor' + i].id != null) {
				listaSabores.push({sabor: $scope['sabor' + i]});
			}
		}

		if (listaSabores.length == 0) {
			alert('Insira um sabor')
			return;
		}
		$scope.itemPedido.listaSabores = listaSabores;
		$scope.itemPedido.tamanho = $scope.itemPedido.tamanho.id;
		$scope.pedido.listaItens.push($scope.itemPedido);
		inicializarItem();
	}

	$scope.salvarPedido = function() {
		if ($scope.pedido.cliente == null) {
			alert('Insira um cliente');
			return;
		}
		if ($scope.pedido.listaItens.length == 0) {
			alert('Insira um pedido')
			return;
		}

		$.post('salvar-pedido', {'pedido': JSON.stringify($scope.pedido)}, function() {
			$('#modal-cadastro').toggle("slide");
			inicializarPedido();
			listarPedidos();
		})
	}

	$scope.mouseEnter = function(event) {
		var el = event.target;
		
		while(!$(el).hasClass('pedido')) {
			el = el.parentElement;
		}
		var id = el.id;
		var theElements = $('#'+id).find('.pedido-hover');
		var select = $(theElements).show().find('#select');
	    var editIcon = $(theElements).show().find('#edit-icon');
	    var deleteIcon = $(theElements).show().find('#delete-icon');
	}

	function localizarPedido(id) {
		for (var i = 0; i < $scope.listaPedidos.length; i++) {
			if ($scope.listaPedidos[i].id == id) {
				return $scope.listaPedidos[i];
			}
		}
	}

	$scope.mouseLeave = function(event) {
		var el = event.target;
		
		while(!$(el).hasClass('pedido')) {
			el = el.parentElement;
		}
		var id = el.id;

		var theElements = $('#'+id).find('.pedido-hover');
	    
	    $(theElements).hide();
	}

	$scope.proximaFase = function(pedido){
		
		$.post('salvar-pedido', {'pedido': JSON.stringify(pedido)}, function() {
			listarPedidos();
		})
	};

	$scope.editClick = function(pedido){
		$scope.pedido = pedido;
		$('#modal-cadastro').toggle("slide");
	};

	$scope.deleteClick = function(pedido){
		pedido.status = 'CANCELADO';
		$.post('salvar-pedido', {'pedido': JSON.stringify(pedido)}, function() {
			listarPedidos();
		})
	};
}])