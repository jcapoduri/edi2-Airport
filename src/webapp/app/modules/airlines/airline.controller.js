'use strict';

(function() {
  angular
    .module('Airport.airline')
    .controller('AirlineController', AirlineController);

  AirlineController.$inject = ['$scope', 'AirlineResource'];

  function AirlineController ($scope, AirlineResource) {
    var vm = this;
    vm.allairlines = [];
    AirlineResource.query(function(data){
      vm.allairlines = data;
    });
  }
})();
