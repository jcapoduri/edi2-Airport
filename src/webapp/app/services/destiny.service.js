'use strict';

(function() {
  angular
    .module('Airport.services')
    .factory('DestinyResource', DestinyResource);

  DestinyResource.$inject = ['$resource'];

  function DestinyResource ($resource) {
    return $resource('/api/destiny/:id', {id: '@id' },{
      update: {
        method: 'PUT' // this method issues a PUT request
      }
    });
  }
})();
