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
          flight: '=model'
        },
        bindToController: true
    };
    return directive;

    function link(scope, element, attrs) {
    }

    AirportEditorController.$inject = ['$scope', 'FlightRouteResource', 'AirlineResource'];

    function AirportEditorController($scope, FlightRouteResource, AirlineResource) {
        var vm = this;

        vm.flightroutes = [{id:0, code:''}];
        vm.airlines = [{id:0, name:''}];
        vm.idFlightRoute = 0;
        vm.idAirline = 0;

        if (!vm.flight) return;

        vm.idFlightRoute = vm.flight.idFlightRoute;
        vm.idAirline = vm.flight.idAirline;

        FlightRouteResource.query(function(data) {
          var id = vm.flight.idFlightRoute;
          vm.flightroutes = angular.copy(data);
          vm.flight.idFlightRoute = id;
        });

        AirlineResource.query(function(data) {
          var id = vm.flight.idAirline;
          vm.airlines = angular.copy(data);
          vm.flight.idAirline = id;
        });


        vm.save = function() {
          if (!$scope.flightForm.$invalid) {
            vm.flight.$save();
            $scope.$emit('save');
          };
        }

        vm.cancel = function() {
          $scope.$emit('cancel');
        }
    }
  }

})();
