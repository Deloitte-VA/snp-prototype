'use strict';

/* Controllers */

var uploadFileControllers = angular.module('UploadFileControllers', []);

uploadFileControllers.controller('uploader', ['$scope', '$http',
                                    function($scope, $http) {
									var LEGO = 'LEGO';
									var FHIR = 'FHIR';									
									$scope.identifier = null;
                      				$scope.contentTypes = [
                      				    LEGO,
                      					FHIR
                      				];
                      				
                      				// FHIR is selected by default
                      				$scope.contentType = FHIR;
                      				$scope.showIdentifier = true;
                      				
                      				$scope.filesChanged = function(elm) {
                      					$scope.files = elm.files;
                      					$scope.$apply();
                      				}
                      	
                      				$scope.showId = function() {
                      					if($scope.contentType == FHIR) {
                      						$scope.showIdentifier = true;  
                      					} else {
                      						$scope.showIdentifier = false;  
                      					}                      			      
                      			    };
                      			    
                      				$scope.upload = function() {
                      					var fd = new FormData();
                      					
                      					if($scope.contentType == LEGO) {
                      						var blob = new Blob([], {type: 'application/lego+xml'});
                   							fd.append('file', blob, LEGO);
                   						} else if($scope.contentType == FHIR) {
                   							var blob = new Blob([], {type: 'application/fhir+xml'});
                   							fd.append('file', blob, FHIR);
                   							fd.append('id', $scope.identifier);
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
                   							$scope.status = status;
                   						})
                   						.error(function (data, status, headers, config) {
                   			                $scope.status = 'Error uploading file: ' + data;
                   			            });
                   					}
                   				}
                   			]);