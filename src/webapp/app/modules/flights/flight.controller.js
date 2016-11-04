'use strict';

(function() {
  angular
    .module('Airport.flight')
    .controller('FlightController', FlightController);

  FlightController.$inject = ['$scope', 'alertService', 'FlightResource'];

  function FlightController ($scope, alertService, FlightResource) {
    var vm = this;

    vm.allflights = [];
    FlightResource.query(function(data){
      vm.allflights = data;
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
