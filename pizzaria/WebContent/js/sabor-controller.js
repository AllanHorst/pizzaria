angular.module('SaborApp', [])

.controller('SaborController', function($scope) {
	$scope.listaSabores = [];
	$scope.sabor = {};
	$scope.searchText = "";

	function listarSabores() {
		$.post("listar-sabores", {}, function(data) {
			$scope.listaSabores = data;
			$scope.$apply();
			console.log(data)
		})
	}
	listarSabores();

	$scope.salvarSabor = function() {
		$.post("salvar-sabor", {'sabor': JSON.stringify($scope.sabor)}, function(data){
			listarSabores();
			$scope.sabor = {}
		});
	}

})