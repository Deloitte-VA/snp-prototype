'use strict';

/* Services */

app.factory('dynamicQueryFactory', ['$http', function($http) {
  var urlBase = 'services/patient/search';
  var dataFactory = {};

  dataFactory.getPatients = function (formData) {
      //return $http.post(urlBase,
    		  //$.param(formData),  // pass in data as strings
    		  //formData,
    		  //{headers:{'Content-Type': 'application/x-www-form-urlencoded'}}  // set the headers so angular passing info as form data (not request payload)
      //);
      return $http.get(urlBase, {
          params: {
        	  observation: formData.observation,
        	  provenance: formData.category,
        	  timing: formData.timing,
        	  value: formData.value
          }
       })
  };  
  
  return dataFactory;
}]);