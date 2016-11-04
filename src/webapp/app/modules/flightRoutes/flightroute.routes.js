'use strict';

(function() {
  angular
    .module('Airport.flightRoute')
    .config(['$stateProvider',
        function($stateProvider) {
          var flightRoutetate = {
            name: 'flightRoute',
            url: '/flightRoute',
            templateUrl: 'modules/flightRoutes/flightroute.partial.html'
          };

          var flightRouteAddState = {
            name: 'flightRoute.add',
            url: '/add',
            onEnter: ['$state', '$uibModal', function($state, $uibModal) {
              var modalInstance = $uibModal.open({
                animation: false,
                templateUrl: 'modules/flightRoutes/flightroute.editor.partial.html',
                size: 'lg',
                controller: 'FlightRouteEditorController',
                controllerAs: 'vm',
                bindToController: true
              });
              modalInstance.closed.finally(function() {
                $state.go('^', {}, {reload: true});
              });
            }],
            views:{
              'modal': {
                templateUrl: 'modules/flightRoutes/flightroute.editor.partial.html'
              }
            },
            modal: true
          };

          var flightRouteEditState = {
            name: 'flightRoute.edit',
            url: '/edit/:id',
            onEnter: ['$state', '$uibModal', function($state, $uibModal) {
              var modalInstance = $uibModal.open({
                animation: false,
                templateUrl: 'modules/flightRoutes/flightroute.editor.partial.html',
                size: 'lg',
                controller: 'FlightRouteEditorController',
                controllerAs: 'vm',
                bindToController: true
              });
              modalInstance.closed.finally(function() {
                $state.go('^', {}, {reload: true});
              });
            }],
            views:{
              'modal': {
                templateUrl: 'modules/flightRoutes/flightroute.editor.partial.html'
              }
            },
            modal: true
          };

          $stateProvider
            .state(flightRoutetate)
            .state(flightRouteAddState)
            .state(flightRouteEditState);
      }]);
})();
