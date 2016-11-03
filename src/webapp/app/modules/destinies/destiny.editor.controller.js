'use strict';

(function() {
  angular
    .module('Airport.destiny')
    .controller('DestinyEditorController', DestinyEditorController);

  DestinyEditorController.$inject = ['$scope', '$stateParams', '$uibModalInstance', 'DestinyResource'];

  function DestinyEditorController ($scope, $stateParams, $uibModalInstance, DestinyResource) {
    var vm = this;
    vm.id = $stateParams.id;
    vm.operation = vm.id ? 'Editar' : 'Agregar';

    if (vm.id) {
      vm.destiny = DestinyResource.get({id: vm.id});
    } else {
      vm.destiny = new DestinyResource();
    };

    $scope.$on('cancel', $uibModalInstance.close);
    $scope.$on('save', $uibModalInstance.close);
  }
})();
