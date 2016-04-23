'use strict';

angular.module('blogApp')
    .controller('ConfigurationController', function ($scope, ConfigurationService) {
        ConfigurationService.get().then(function(configuration) {
            $scope.configuration = configuration;
        });
        ConfigurationService.getEnv().then(function (configuration) {
            $scope.allConfiguration = configuration;
        });
    });
