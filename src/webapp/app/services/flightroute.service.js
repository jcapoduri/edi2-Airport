'use strict';

(function() {
  angular
    .module('Airport.services')
    .factory('FlightRouteResource', FlightRouteResource);

  FlightRouteResource.$inject = ['$resource'];

  function FlightRouteResource ($resource) {
    return $resource('/api/flightroute/:id', {id: '@id' },{
      update: {
        method: 'PUT' // this method issues a PUT request
      }
    });
  }
})();
