'use strict';

angular.module('blogApp')
    .factory('AuditsService', function ($resource) {
        return $resource('api/audits/:id', {}, {
            'get': {
                method: 'GET',
                isArray: true
            },
            'query': {
                method: 'GET',
                isArray: true,
                params: {fromDate: null, toDate: null}
            }
        });
    });
