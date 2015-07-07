'use strict';

/* Controllers */

app.controller('Uploader', ['$scope', 'UploadFileFactory',
  function($scope, UploadFileFactory) {
    var LEGO = 'LEGO';
    var FHIR = 'FHIR';
    //create content type hashmap
    $scope.contentTypes = {};
    //add keys to the hashmap
    $scope.contentTypes[LEGO] = 'application/lego+xml';
    $scope.contentTypes[FHIR] = 'application/fhir+xml';
    //create FHIR identifier
    $scope.identifier = null;
    //create status returned from RESTful webservice
    $scope.status = null;
		
    //FHIR is selected by default
    $scope.contentType = $scope.contentTypes[FHIR];
    $scope.showIdentifier = true;
                      				
    $scope.filesChanged = function(elm) {
      $scope.files = elm.files;
      $scope.$apply();
    }     	
    
    $scope.showId = function() {
      if($scope.contentType == $scope.contentTypes[FHIR]) {
        $scope.showIdentifier = true;  
      } else {
        $scope.showIdentifier = false;  
      }                      			      
    };
                      			    
    $scope.upload = function() {
      var fd = new FormData();
      if($scope.contentType == $scope.contentTypes[FHIR]) {
        fd.append('id', $scope.identifier);
      }

      angular.forEach($scope.files, function(file) {
        var blob = new Blob([file], {type: $scope.contentType});
        fd.append('file', blob);
      });

      UploadFileFactory.upload(fd)
      .success(function(data, status, headers, config) {
        $scope.status = status;
      })
      .error(function (data, status, headers, config) {
        $scope.status = 'Error uploading file: ' + data;
      });
    }
  }
]);