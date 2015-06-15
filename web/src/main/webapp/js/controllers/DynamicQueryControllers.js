'use strict';

/* Controllers */

app.controller('DynamicQueryController', ['$scope', 'dynamicQueryFactory',
  function($scope, dynamicQueryFactory) {
    // create a blank object to hold our form information
	// $scope will allow this to pass between controller and view
    $scope.formData = {};
    $scope.formData.key = 'classifierId';
    $scope.formData.value = 23;
    $scope.status = {};
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
            .success(function (pats) {
                $scope.patients = pats;
            })
            .error(function (error) {
                $scope.status = 'Unable to load patient data: ' + error.message;
            });
    };
}]);