'use strict';

(function() {
  angular
    .module('Airport.flightRoute')
    .controller('FlightRouteController', FlightRouteController);

  FlightRouteController.$inject = ['$scope', 'alertService', 'FlightRouteResource'];

  function FlightRouteController ($scope, alertService, FlightRouteResource) {
    var vm = this;

    vm.allflightroutes = [];
    FlightRouteResource.query(function(data){
      vm.allflightroutes = data;
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
