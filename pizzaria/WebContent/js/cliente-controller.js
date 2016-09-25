angular.module('ClienteApp', [])

.controller('ClienteController', function($scope) {
	$scope.listaClientes = [];
	$scope.cliente = {};
	$scope.searchText = "";

	function listarClientes() {
		$.post("listar-clientes", {}, function(data) {
			$scope.listaClientes = data;
			$scope.$apply();
		})
	}
	listarClientes();

	$scope.salvarCliente = function() {
		$.post("salvar-cliente", {'cliente': JSON.stringify($scope.cliente)}, function(data){
			listarClientes();
			$scope.cliente = {}
		});
	}

})