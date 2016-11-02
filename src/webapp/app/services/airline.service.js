'use strict';

(function() {
  angular
    .module('Airport.services')
    .factory('AirlineResource', AirlineResource);

  AirlineResource.$inject = ['$resource'];

  function AirlineResource ($resource) {
    return $resource('/api/airline/:id');
  };
})();
