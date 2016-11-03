'use strict';

(function() {
  angular
    .module('Airport.services')
    .factory('PassengerResource', PassengerResource);

  PassengerResource.$inject = ['$resource'];

  function PassengerResource ($resource) {
    return $resource('/api/passenger/:id', {id: '@id' },{
      update: {
        method: 'PUT' // this method issues a PUT request
      }
    });
  }
})();
