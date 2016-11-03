'use strict';

(function() {
  angular
    .module('Airport.airline')
    .controller('AirlineEditorController', AirlineEditorController);

  AirlineEditorController.$inject = ['$scope', '$stateParams', '$uibModalInstance', 'AirlineResource'];

  function AirlineEditorController ($scope, $stateParams, $uibModalInstance, AirlineResource) {
    var vm = this;
    vm.id = $stateParams.id;
    vm.operation = vm.id ? 'Editar' : 'Agregar';

    if (vm.id) {
      vm.airline = AirlineResource.get({id: vm.id});
    } else {
      vm.airline = new AirlineResource();
    };

    $scope.$on('cancel', $uibModalInstance.close);
    $scope.$on('save', $uibModalInstance.close);
  }
})();
