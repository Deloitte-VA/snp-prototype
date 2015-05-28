'use strict';

/* Controllers */

var snpPrototypeControllers = angular.module('SnpPrototypeControllers', []);

snpPrototypeControllers.controller('SnpPrototypeController', ['$scope', 'SnpPrototype', function($scope, SnpPrototype) {
		// instantiate an object to store your scope data in (Best Practices)
		$scope.patients = {};
		$scope.queryKey = '';
		$scope.queryValue = '';
		
		$scope.getAll = function() {
			SnpPrototype.query(function(response) {
			    var result = {};
			    var index = 0;
			    angular.forEach(response, function(value, key) {			    	
			    	if ($scope.queryKey != '' && $scope.queryValue != '') {
			    		angular.forEach(value, function(v, k) {
                			var areKeyEqual = k.toUpperCase() == $scope.queryKey.toUpperCase();
                			var areValueEqual = v.toUpperCase() == $scope.queryValue.toUpperCase();
			    			if (areKeyEqual && areValueEqual) {
			    				result[index] = value;
			    				index++;
			    			}
            			});
			    	} else {
			    		result[index] = value;
			    		index++;
			    	}
				});
				$scope.patients = result;
			  });
		};		
	}]);
