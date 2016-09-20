angular.module('testeApp', ['myAutoComplete'])

.controller('testeController', ['$scope', function($scope){
	$scope.teste = '';
	
	$scope.click = function() {
		var obj = {
			nome: 'Allan',
			endereco: 'Rua minas gerais 1390',
			telefone: '84064681'
		}
		$.post("salvar-cliente", {'obj': JSON.stringify(obj)}, function(data){
			console.log(data);
		});
	}
}])