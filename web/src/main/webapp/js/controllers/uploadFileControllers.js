'use strict';

/* Controllers */

var uploadFileControllers = angular.module('UploadFileControllers', []);

uploadFileControllers.controller('uploader', ['$scope', '$http',
                                    function($scope, $http) {
                      				$scope.contentTypes = 
                      					[
                      						'LEGO',
                      						'FHIR'
                      					];
                      					$scope.filesChanged = function(elm) {
                      						$scope.files = elm.files;
                      						$scope.$apply();
                      					}
                      					$scope.upload = function() {
                      						var fd = new FormData();
                      						
                      						if($scope.contentType == 'LEGO') {
                      							var blob = new Blob([], {type: 'application/lego+xml'});
                      							fd.append('file', blob, 'LEGO');
                      						} else if($scope.contentType == 'FIHR') {
                      							var blob = new Blob([], {type: 'application/fhir+xml'});
                      							fd.append('file', blob, 'FIHR');
                      						}
                      						
                      						angular.forEach($scope.files, function(file) {
                      							fd.append('file', file);
                      						})
                      						$http.post('services/classifier', fd,
                      						{
                      							transformRequest:angular.identity,
                      							headers:{'Content-Type':undefined}
                      						})
                      						.success(function(d) {
                      							console.log(d)	
                      						})
                      					}
                      				}
                      			]);