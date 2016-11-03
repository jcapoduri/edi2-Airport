'use strict';

(function() {
  angular
    .module('Airport.destiny')
    .config(['$stateProvider',
        function($stateProvider) {
          var destinyState = {
            name: 'destiny',
            url: '/destiny',
            templateUrl: 'modules/destinies/destiny.partial.html'
          };

          var destinyAddState = {
            name: 'destiny.add',
            url: '/add',
            onEnter: ['$state', '$uibModal', function($state, $uibModal) {
              var modalInstance = $uibModal.open({
                animation: false,
                templateUrl: 'modules/destinies/destiny.editor.partial.html',
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
                templateUrl: 'modules/destinies/destiny.editor.partial.html'
              }
            },
            modal: true
          };

          var destinyEditState = {
            name: 'destiny.edit',
            url: '/edit/:id',
            onEnter: ['$state', '$uibModal', function($state, $uibModal) {
              var modalInstance = $uibModal.open({
                animation: false,
                templateUrl: 'modules/destinies/destiny.editor.partial.html',
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
                templateUrl: 'modules/destinies/destiny.editor.partial.html'
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
