'use strict';

(function() {
  angular
    .module('Airport.flight')
    .directive('flight', flightEditor);

  function flightEditor () {
    var directive = {
        link: link,
        templateUrl: 'directives/flight/flight.partial.html',
        restrict: 'EA',
        controllerAs: 'vm',
        controller: AirportEditorController,
        scope: {
          flight: '=?model'
        },
        bindToController: true
    };
    return directive;

    function link(scope, element, attrs) {
    }

    AirportEditorController.$inject = ['$scope', 'FlightRouteResource', 'AirlineResource'];

    function AirportEditorController($scope, FlightRouteResource, AirlineResource) {
        var vm = this;

        FlightRouteResource.query(function(data) {
          vm.flightroutes = angular.copy(data);
        });

        AirlineResource.query(function(data) {
          vm.airlines = angular.copy(data);
        });


        vm.save = function() {
          vm.flight.$save();
          $scope.$emit('save');
        }

        vm.cancel = function() {
          $scope.$emit('cancel');
        }
    }
  }

})();
