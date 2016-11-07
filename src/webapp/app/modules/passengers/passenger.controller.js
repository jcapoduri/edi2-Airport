'use strict';

(function() {
  angular
    .module('Airport.airline')
    .controller('PassengerController', PassengerController);

  PassengerController.$inject = ['$scope', 'alertService', 'PassengerResource'];

  function PassengerController ($scope, alertService, PassengerResource) {
    var vm = this;

    vm.allpassengers = [];
    function update() {
      PassengerResource.query(function(data){
        vm.allpassengers = data;
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
