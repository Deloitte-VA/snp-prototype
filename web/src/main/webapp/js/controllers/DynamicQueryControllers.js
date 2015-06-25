'use strict';

/* Controllers */

app.controller('DynamicQueryController', ['$scope', 'dynamicQueryFactory',
  function($scope, dynamicQueryFactory) {
    // create a blank object to hold our form information
	// $scope will allow this to pass between controller and view
    $scope.formData = {};
    $scope.formData.observation = null;
    $scope.formData.provenance = null;
    $scope.formData.timing = null;
    $scope.formData.value = null;
    $scope.patients = {};	
	$scope.types = 
	[
		'string',
		'number',
		'boolean',
		'null',
		'array',
		'object',
		'date',
		'binary',
		'objectId'
	];
	$scope.formData.bsonType = $scope.types[0];
	
    $scope.processForm = function() {
    	dynamicQueryFactory.getPatients($scope.formData)
            .success(function (data, status, headers, config) {
            	$scope.status = status;
                $scope.patients = data;
            })
            .error(function (data, status, headers, config) {
                $scope.status = 'Unable to load patient data: ' + data;
            });
    };
}]);