'use strict';

(function() {
  angular
    .module('Airport.flightRoute')
    .controller('FlightRouteController', FlightRouteController);

  FlightRouteController.$inject = ['$scope', '$q', 'alertService', 'FlightRouteResource', 'DestinyResource'];

  function FlightRouteController ($scope, $q, alertService, FlightRouteResource, DestinyResource) {
    var vm = this;

    vm.allflightroutes = [];
    function update() {
      var flightRoutes = FlightRouteResource.query();
      var destinies = DestinyResource.query();
      $q.all([
        flightRoutes.$promise, 
        destinies.$promise
      ]).then(function(data) {
        var flightroutes = data[0],
            destinies = data[1];

        vm.allflightroutes = flightroutes.map(function(item) {
          var destiny = destinies.filter(function (x){ return x.id == item.destiny; })[0],
              origin  = destinies.filter(function (x){ return x.id == item.origin; })[0];
          item.destiny = destiny.name + '(' + destiny.code + ')';
          item.origin = origin.name + '(' + origin.code + ')';
          return item;
        })
      })
    };

    vm.deleteItem = function(item) {
      var alertOptions = {
            closeButtonText: 'No',
            actionButtonText: 'Ok',
            headerText: 'Esta seguro?',
            bodyText: 'Esta a punto de eliminar '+ item.name+', esta usted seguro?'
        };
      alertService.show(alertOptions).then(function() {
        item.$delete().then(update);
      });
    };

    update();
  }
})();
