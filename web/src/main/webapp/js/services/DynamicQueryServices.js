'use strict';

/* Services */

app.factory('dynamicQueryFactory', ['$http', function($http) {
  var urlBase = 'services/classifier/query';
  var dataFactory = {};

  dataFactory.getPatients = function (formData) {
      return $http.post(urlBase,
    		  //$.param(formData),  // pass in data as strings
    		  formData//,
    		  //{headers:{'Content-Type': 'application/x-www-form-urlencoded'}}  // set the headers so angular passing info as form data (not request payload)
      );
  };  
  
  return dataFactory;
}]);