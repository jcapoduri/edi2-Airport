'use strict';

(function() {
  angular
    .module('Airport.destiny')
    .controller('DestinyController', DestinyController);

  DestinyController.$inject = ['$scope', 'alertService', 'DestinyResource'];

  function DestinyController ($scope, alertService, DestinyResource) {
    var vm = this;

    vm.alldestinies = [];
    function update() {
      DestinyResource.query(function(data){
        vm.alldestinies = data;
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
