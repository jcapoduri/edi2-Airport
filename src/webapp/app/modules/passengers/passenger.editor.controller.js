'use strict';

(function() {
  angular
    .module('Airport.passenger')
    .controller('PassengerEditorController', PassengerEditorController);

  PassengerEditorController.$inject = ['$scope', '$stateParams', '$uibModalInstance', 'PassengerResource'];

  function PassengerEditorController ($scope, $stateParams, $uibModalInstance, PassengerResource) {
    var vm = this;
    vm.id = $stateParams.id;
    vm.operation = vm.id ? 'Editar' : 'Agregar';

    if (vm.id) {
      vm.passenger = PassengerResource.get({id: vm.id});
    } else {
      vm.passenger = new PassengerResource();
    };

    $scope.$on('cancel', $uibModalInstance.close);
    $scope.$on('save', $uibModalInstance.close);
  }
})();
