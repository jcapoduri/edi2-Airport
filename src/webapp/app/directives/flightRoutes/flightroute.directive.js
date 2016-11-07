'use strict';

(function() {
  angular
    .module('Airport.flightRoute')
    .directive('flightRoute', flightRouteEditor);

  function flightRouteEditor () {
    var directive = {
        link: link,
        templateUrl: 'directives/flightRoutes/flightroute.partial.html',
        restrict: 'EA',
        controllerAs: 'vm',
        controller: AirportEditorController,
        scope: {
          flightRoute: '=?model'
        },
        bindToController: true
    };
    return directive;

    function link(scope, element, attrs) {
    }

    AirportEditorController.$inject = ['$scope', 'DestinyResource'];

    function AirportEditorController($scope, DestinyResource) {
        var vm = this;

        var destinies = DestinyResource.query(function(data) {
          vm.origins   = angular.copy(data);
          vm.destinies = angular.copy(data);
        });


        vm.save = function() {
          vm.flightRoute.$save().then(function() {
            $scope.$emit('save');
          });
        }

        vm.cancel = function() {
          $scope.$emit('cancel');
        }
    }
  }

})();
