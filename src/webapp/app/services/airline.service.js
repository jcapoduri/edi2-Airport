'use strict';

(function() {
  angular
    .module('Airport.services')
    .factory('AirlineResource', AirlineResource);

  AirlineResource.$inject = ['$resource'];

  var AirlineResource = function ($resource) {
    return $resource('/api/airline/:id');
  };
})();
