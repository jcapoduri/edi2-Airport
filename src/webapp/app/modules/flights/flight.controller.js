'use strict';

(function() {
  angular
    .module('Airport.flight')
    .controller('FlightController', FlightController);

  FlightController.$inject = ['$scope', '$q', 'alertService', 'FlightResource', 'FlightRouteResource', 'AirlineResource'];

  function FlightController ($scope, $q, alertService, FlightResource, FlightRouteResource, AirlineResource) {
    var vm = this;

    vm.allflights = [];

    var flights = FlightResource.query(),
        airlines = AirlineResource.query(),
        routes = FlightRouteResource.query();

    $q.all([
      flights.$promise,
      airlines.$promise,
      routes.$promise
    ]).then(function(data) {
      var flights = data[0],
          airlines = data[1],
          routes = data[2];

      vm.allflights = flights.map(function(flight) {
        var route = routes.filter(function(x) { return x.id = flight.idFlightRoute; })[0],
            airline = airlines.filter(function(x) { return x.id = flight.idAirline; })[0];
        
        flight.route = route.code;
        flight.airline = airline.name + '(' + airline.code + ')';
        flight.backwads = flight.backwads ? 'Vuelta' : 'Ida';
        return flight;
      });
    });

    vm.deleteItem = function(item) {
      var alertOptions = {
          closeButtonText: 'No',
          actionButtonText: 'Ok',
          headerText: 'Esta seguro?',
          bodyText: 'Esta a punto de eliminar '+ item.name+', esta usted seguro?'
      };
      alertService.show(alertOptions).then(function() {
        item.$delete();
      });
    };

  }
})();
