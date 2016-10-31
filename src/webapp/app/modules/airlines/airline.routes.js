"use strict";

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

          $stateProvider.state(airlineState);
      }]);
})();