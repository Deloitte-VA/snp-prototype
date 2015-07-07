'use strict';

/* App Module */

var app = angular.module('SnpPrototypeApp', ['ngRoute']);

app.config(function($routeProvider) {
    $routeProvider
        // route for the dynamic query page
        .when('/query', {
            templateUrl : 'views/dynamicQuery.html',
            controller  : 'DynamicQueryController'
        })
        // route for the upload file page
        .when('/upload', {
            templateUrl : 'views/uploadFile.html',
            controller  : 'UploadFileController'
        })
        // route for the dynamic query page
        .otherwise({
            redirectTo: '/query'
          });
});