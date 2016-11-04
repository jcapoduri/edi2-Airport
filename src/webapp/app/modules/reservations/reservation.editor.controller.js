'use strict';

(function() {
  angular
    .module('Airport.reservation')
    .controller('ReservationEditorController', ReservationEditorController);

  ReservationEditorController.$inject = ['$scope', '$stateParams', '$uibModalInstance', 'ReservationResource'];

  function ReservationEditorController ($scope, $stateParams, $uibModalInstance, ReservationResource) {
    var vm = this;
    vm.id = $stateParams.id;
    vm.operation = vm.id ? 'Editar' : 'Agregar';

    if (vm.id) {
      vm.reservation = ReservationResource.get({id: vm.id});
    } else {
      vm.reservation = new ReservationResource();
    };

    $scope.$on('cancel', $uibModalInstance.close);
    $scope.$on('save', $uibModalInstance.close);
  }
})();
