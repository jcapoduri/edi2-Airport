'use strict';

(function() {
  angular
    .module('Airport.services')
    .factory('ReservationResource', ReservationResource);

  ReservationResource.$inject = ['$resource'];

  function ReservationResource ($resource) {
    return $resource('/api/reservation/:id', {id: '@id' },{
      update: {
        method: 'PUT' // this method issues a PUT request
      }
    });
  }
})();
