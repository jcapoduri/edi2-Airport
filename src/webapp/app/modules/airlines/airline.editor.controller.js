'use strict';

(function() {
  angular
    .module('Airport.airline')
    .controller('AirlineEditorController', AirlineEditorController);

  AirlineEditorController.$inject = ['$scope', '$stateParams', 'AirlineResource'];

  function AirlineEditorController ($scope, $stateParams, AirlineResource) {
    var vm = this;
    vm.operation = 'Agregar';
  }
})();
