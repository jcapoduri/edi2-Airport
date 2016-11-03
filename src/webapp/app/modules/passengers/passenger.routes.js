'use strict';

(function() {
  angular
    .module('Airport.passenger')
    .config(['$stateProvider',
        function($stateProvider) {
          var passengerState = {
            name: 'passenger',
            url: '/passenger',
            templateUrl: 'modules/passengers/passenger.partial.html'
          };

          var passengerAddState = {
            name: 'passenger.add',
            url: '/add',
            onEnter: ['$state', '$uibModal', function($state, $uibModal) {
              var modalInstance = $uibModal.open({
                animation: false,
                templateUrl: 'modules/passengers/passenger.editor.partial.html',
                size: 'lg',
                controller: 'PassengerEditorController',
                controllerAs: 'vm',
                bindToController: true
              });
              modalInstance.closed.finally(function() {
                $state.go('^', {}, {reload: true});
              });
            }],
            views:{
              'modal': {
                templateUrl: 'modules/passengers/passenger.editor.partial.html'
              }
            },
            modal: true
          };

          var passengerEditState = {
            name: 'passenger.edit',
            url: '/edit/:id',
            onEnter: ['$state', '$uibModal', function($state, $uibModal) {
              var modalInstance = $uibModal.open({
                animation: false,
                templateUrl: 'modules/passengers/passenger.editor.partial.html',
                size: 'lg',
                controller: 'PassengerEditorController',
                controllerAs: 'vm',
                bindToController: true
              });
              modalInstance.closed.finally(function() {
                $state.go('^', {}, {reload: true});
              });
            }],
            views:{
              'modal': {
                templateUrl: 'modules/passengers/passenger.editor.partial.html'
              }
            },
            modal: true
          };

          $stateProvider
            .state(passengerState)
            .state(passengerAddState)
            .state(passengerEditState);
      }]);
})();
