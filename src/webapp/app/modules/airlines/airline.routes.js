'use strict';

(function() {
  angular
    .module('Airport.airline')
    .config(['$stateProvider',
        function($stateProvider) {
          var airlineState = {
            name: 'airline',
            url: '/airline',
            templateUrl: 'modules/airlines/airlines.partial.html'
          }

          var airlineAddState = {
            name: 'airline.add',
            url: '/airline/add',
            templateUrl: 'modules/airlines/airlines.partial.html'
          }

          var airlineEditState = {
            name: 'airline.edit',
            url: '/airline/edit/:id',
            templateUrl: 'modules/airlines/airlines.partial.html'
          }

          $stateProvider
            .state(airlineState)
            .state(airlineAddState)
            .state(airlineEditState);
      }]);
})();
