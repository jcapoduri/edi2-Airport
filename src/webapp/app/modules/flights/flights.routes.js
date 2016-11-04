'use strict';

(function() {
  angular
    .module('Airport.flight')
    .config(['$stateProvider',
        function($stateProvider) {
          var destinyState = {
            name: 'flight',
            url: '/flight',
            templateUrl: 'modules/flights/flight.partial.html'
          };

          var destinyAddState = {
            name: 'flight.add',
            url: '/add',
            onEnter: ['$state', '$uibModal', function($state, $uibModal) {
              var modalInstance = $uibModal.open({
                animation: false,
                templateUrl: 'modules/flights/flight.editor.partial.html',
                size: 'lg',
                controller: 'DestinyEditorController',
                controllerAs: 'vm',
                bindToController: true
              });
              modalInstance.closed.finally(function() {
                $state.go('^', {}, {reload: true});
              });
            }],
            views:{
              'modal': {
                templateUrl: 'modules/flights/flight.editor.partial.html'
              }
            },
            modal: true
          };

          var destinyEditState = {
            name: 'flight.edit',
            url: '/edit/:id',
            onEnter: ['$state', '$uibModal', function($state, $uibModal) {
              var modalInstance = $uibModal.open({
                animation: false,
                templateUrl: 'modules/flights/flight.editor.partial.html',
                size: 'lg',
                controller: 'DestinyEditorController',
                controllerAs: 'vm',
                bindToController: true
              });
              modalInstance.closed.finally(function() {
                $state.go('^', {}, {reload: true});
              });
            }],
            views:{
              'modal': {
                templateUrl: 'modules/flights/flight.editor.partial.html'
              }
            },
            modal: true
          };

          $stateProvider
            .state(destinyState)
            .state(destinyAddState)
            .state(destinyEditState);
      }]);
})();
