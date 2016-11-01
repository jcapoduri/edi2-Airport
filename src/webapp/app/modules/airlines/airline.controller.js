'use strict';

(function() {
  angular
    .module('Airport.airline')
    .controller('AirlineController', AirlineController);

    AirlineController.$inject = ['$scope', 'AirlineResource'];

  var AirlineController = function ($scope, AirlineResource) {

  };
})();
