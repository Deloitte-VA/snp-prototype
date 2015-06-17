'use strict';

/* Controllers */

var uploadFileControllers = angular.module('UploadFileControllers', []);

uploadFileControllers.controller('uploader', ['$scope', '$http',
                                    function($scope, $http) {
									var LEGO = 'LEGO';
									var FHIR = 'FHIR';
									$scope.contentType = 'LEGO';
                      				$scope.contentTypes = 
                      					[
                      						LEGO,
                      						FHIR
                      					];
                      					$scope.filesChanged = function(elm) {
                      						$scope.files = elm.files;
                      						$scope.$apply();
                      					}
                      					$scope.upload = function() {
                      						var fd = new FormData();
                      						
                      						if($scope.contentType == LEGO) {
                      							var blob = new Blob([], {type: 'application/lego+xml'});
                      							fd.append('file', blob, LEGO);
                      						} else if($scope.contentType == FHIR) {
                      							var blob = new Blob([], {type: 'application/fhir+xml'});
                      							fd.append('file', blob, FHIR);
                      						} else {
                      							var blob = new Blob([], {type: 'text/xml'});
                      							fd.append('file', blob);
                      						}
                      						
                      						angular.forEach($scope.files, function(file) {
                      							fd.append('file', file);
                      						})
                      						$http.post('services/classifier', fd,
                      						{
                      							transformRequest:angular.identity,
                      							headers:{'Content-Type':undefined}
                      						})
                      						.success(function(data, status, headers, config) {
                      							console.log(status);
                      							$scope.status = status;
                      							$scope.data = data;
                      						})
                      						.error(function(data, status, headers, config) {
                      				          $scope.data = data || "Request failed";
                      				          $scope.status = status;
                      				      });
                      					}
                      				}
                      			]);