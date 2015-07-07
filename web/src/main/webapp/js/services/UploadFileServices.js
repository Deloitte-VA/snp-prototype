'use strict';

/* Services */

app.factory('UploadFileFactory', ['$http', function($http) {
  var urlBase = 'services/classifier';
  var dataFactory = {};

  dataFactory.upload = function (formData) {
  	return $http.post(urlBase, formData,
        {
            transformRequest:angular.identity,
            headers:{'Content-Type':undefined}
        })
  };  
  
  return dataFactory;
}]);