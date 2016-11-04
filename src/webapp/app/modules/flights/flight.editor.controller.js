'use strict';

(function() {
  angular
    .module('Airport.flight')
    .controller('FlightEditorController', FlightEditorController);

  FlightEditorController.$inject = ['$scope', '$stateParams', '$uibModalInstance', 'FlightResource'];

  function FlightEditorController ($scope, $stateParams, $uibModalInstance, FlightResource) {
    var vm = this;
    vm.id = $stateParams.id;
    vm.operation = vm.id ? 'Editar' : 'Agregar';

    if (vm.id) {
      vm.flight = FlightResource.get({id: vm.id});
    } else {
      vm.flight = new FlightResource({backwards: false});
    };

    $scope.$on('cancel', $uibModalInstance.close);
    $scope.$on('save', $uibModalInstance.close);
  }
})();
