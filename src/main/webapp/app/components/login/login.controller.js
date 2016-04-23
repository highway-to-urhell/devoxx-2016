'use strict';

angular.module('blogApp')
    .controller('LoginController', function ($rootScope, $scope, $state, $timeout, Auth, $uibModalInstance) {
        $scope.authenticationError = false;

        $scope.rememberMe = true;
        $timeout(function (){angular.element('[ng-model="username"]').focus();});
        $scope.login = function (event) {
            event.preventDefault();
            Auth.login({
                username: $scope.username,
                password: $scope.password,
                rememberMe: $scope.rememberMe
            }).then(function () {
                $scope.authenticationError = false;
                $uibModalInstance.close();
            }).catch(function () {
                $scope.authenticationError = true;
            });
        };

        $scope.cancel = function () {
            $scope.credentials = {
                username: null,
                password: null,
                rememberMe: true
            };
            $scope.authenticationError = false;
            $uibModalInstance.dismiss('cancel');
        };

        $scope.requestResetPassword = function () {
            $uibModalInstance.dismiss('cancel');
            $state.go('requestReset');
        };

        $scope.register = function () {
            $uibModalInstance.dismiss('cancel');
            $state.go('register');
        };
    });
