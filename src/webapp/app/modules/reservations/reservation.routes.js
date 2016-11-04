'use strict';

(function() {
  angular
    .module('Airport.reservation')
    .config(['$stateProvider',
        function($stateProvider) {
          var reservationState = {
            name: 'reservation',
            url: '/reservation',
            templateUrl: 'modules/reservations/reservation.partial.html'
          };

          var reservationAddState = {
            name: 'reservation.add',
            url: '/add',
            onEnter: ['$state', '$uibModal', function($state, $uibModal) {
              var modalInstance = $uibModal.open({
                animation: false,
                templateUrl: 'modules/reservations/reservation.editor.partial.html',
                size: 'lg',
                controller: 'ReservationEditorController',
                controllerAs: 'vm',
                bindToController: true
              });
              modalInstance.closed.finally(function() {
                $state.go('^', {}, {reload: true});
              });
            }],
            views:{
              'modal': {
                templateUrl: 'modules/reservations/reservation.editor.partial.html'
              }
            },
            modal: true
          };

          var reservationEditState = {
            name: 'reservation.edit',
            url: '/edit/:id',
            onEnter: ['$state', '$uibModal', function($state, $uibModal) {
              var modalInstance = $uibModal.open({
                animation: false,
                templateUrl: 'modules/reservations/reservation.editor.partial.html',
                size: 'lg',
                controller: 'ReservationEditorController',
                controllerAs: 'vm',
                bindToController: true
              });
              modalInstance.closed.finally(function() {
                $state.go('^', {}, {reload: true});
              });
            }],
            views:{
              'modal': {
                templateUrl: 'modules/reservations/reservation.editor.partial.html'
              }
            },
            modal: true
          };

          $stateProvider
            .state(reservationState)
            .state(reservationAddState)
            .state(reservationEditState);
      }]);
})();
