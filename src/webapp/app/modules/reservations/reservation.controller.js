'use strict';

(function() {
  angular
    .module('Airport.reservation')
    .controller('ReservationController', ReservationController);

  ReservationController.$inject = ['$scope', 'alertService', 'ReservationResource'];

  function ReservationController ($scope, alertService, ReservationResource) {
    var vm = this;

    vm.allreservations = [];
    function update() {
      ReservationResource.query(function(data){
        vm.allairlines = data;
      });
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
