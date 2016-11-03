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
          };

          var airlineAddState = {
            name: 'airline.add',
            url: '/add',
            onEnter: ['$state', '$uibModal', function($state, $uibModal) {             
              var modalInstance = $uibModal.open({
                animation: false,
                templateUrl: 'modules/airlines/airlines.editor.partial.html',
                size: 'lg'
              });
              modalInstance.result.finally(function() {
                $state.go('^');
              });
            }],
            views:{
              'modal': {
                templateUrl: 'modules/airlines/airlines.editor.partial.html'
              }
            },
            modal: true
          };

          var airlineEditState = {
            name: 'airline.edit',
            url: '/edit/:id',
            templateUrl: 'modules/airlines/airlines.editor.partial.html'
          };

          $stateProvider
            .state(airlineState)
            .state(airlineAddState)
            .state(airlineEditState);
      }]);
})();
