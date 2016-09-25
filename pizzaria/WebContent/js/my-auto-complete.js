angular.module('myAutoComplete', [])

.directive('myAutoComplete',['$compile',function($compile) {
	return {
		restrict: 'AE',
		require: 'ngModel',
		scope: true,
		bindToController: {
			ngModel: '=',
			listItems: '='
		},
		controllerAs: 'controller',

		templateUrl: 'js/template.html',

		controller: function($scope, $element, $attrs) {
			console.log(this.listItems)
			$scope.$watch('controller.ngModel', function(newValue, oldValue) {
				if (newValue == undefined || newValue == '') {
					return;
				}

				$scope.lista = [];
			})

			function replaceSpecialChars(str) {
				str = str.toLocaleUpperCase()
				str = str.replace(/[ÀÁÂÃÄÅ]/,"A");
				str = str.replace(/[ÈÉÊË]/,"E");
				str = str.replace(/[ÌÍÎ]/,"I");
				str = str.replace(/[ÒÓÔÕ]/,"O");
				str = str.replace(/[ÙÚÜ]/,"U");
				str = str.replace(/[Ç]/,"C");
				
				return str.replace(/[^a-z0-9]/gi,''); 
			}


		}
	}
}])
