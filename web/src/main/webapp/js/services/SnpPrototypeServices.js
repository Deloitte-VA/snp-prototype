'use strict';

/* Services */

var snpPrototypeServices = angular.module('SnpPrototypeServices', ['ngResource']);

snpPrototypeServices.service('SnpPrototype', ['$resource', function($resource) { 
	return $resource('patients/patients.json');
	}]);
