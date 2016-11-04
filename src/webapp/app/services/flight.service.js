'use strict';

(function() {
  angular
    .module('Airport.services')
    .factory('FlightResource', FlightResource);

  FlightResource.$inject = ['$resource'];

  function FlightResource ($resource) {
    return $resource('/api/flight/:id', {id: '@id' },{
      update: {
        method: 'PUT' // this method issues a PUT request
      }
    });
  }
})();
