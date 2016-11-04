'use strict';

(function() {
  angular
    .module('Airport.flightRoute')
    .controller('FlightRouteEditorController', FlightRouteEditorController);

  FlightRouteEditorController.$inject = ['$scope', '$stateParams', '$uibModalInstance', 'FlightRouteResource'];

  function FlightRouteEditorController ($scope, $stateParams, $uibModalInstance, FlightRouteResource) {
    var vm = this;
    vm.id = $stateParams.id;
    vm.operation = vm.id ? 'Editar' : 'Agregar';

    if (vm.id) {
      vm.flightRoute = FlightRouteResource.get({id: vm.id});
    } else {
      vm.flightRoute = new FlightRouteResource();
    };

    $scope.$on('cancel', $uibModalInstance.close);
    $scope.$on('save', $uibModalInstance.close);
  }
})();
