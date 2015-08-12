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
	
    $scope.processForm = function() {
        var o = $scope.formData.observation,
            p = $scope.formData.provenance,
            v = $scope.formData.value;

        var filter = '';
        if (o !== null) {
            filter += 'observation=' + o;
        }
        if (p !== null) {
            if (filter !== '') {
                filter += ",";
            }
            filter += 'provenance=' + p;
        }
        if (v !== null) {
            if (filter !== '') {
                filter += ",";
            }
            filter += ',value=' + v;
        }
        if (filter == '') {
            return;
        }
    	$scope.formData.filter = filter;
    	
    	dynamicQueryFactory.getPatients($scope.formData)
            .success(function (data, status, headers, config) {
            	$scope.status = status;
                $scope.patients = data.results;
            })
            .error(function (data, status, headers, config) {
                $scope.status = 'Unable to load patient data: ' + status;
            });
    };
}]);