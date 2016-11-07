'use strict';

(function() {
  angular
    .module('Airport.airline')
    .controller('AirlineController', AirlineController);

  AirlineController.$inject = ['$scope', 'alertService', 'AirlineResource'];

  function AirlineController ($scope, alertService, AirlineResource) {
    var vm = this;

    vm.allairlines = [];
    function update() {
      AirlineResource.query(function(data){
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
