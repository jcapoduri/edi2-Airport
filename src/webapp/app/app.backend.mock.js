//$httpBackend
'use strict';

(function () {
  angular
    .module('Airport')
    .run(function BackendMockup ($httpBackend, BackendService) {
      var respondGetAll = function(method, url, data) {
          var entity   = url.split('/')[2];
          var response = BackendService.findAll(entity);
          return [200, response, {}];
      };

      var respondGetOne = function(method, url, data) {
          // parse the matching URL to pull out the id (/games/:id)
          var entity   = url.split('/')[2];
          var entityId = url.split('/')[3];

          var game = BackendService.findOne(entity, entityId);

          return [200, game, {}];
      };

      var respondCreateOne = function(method, url, data) {
          var params = angular.fromJson(data),
              entity   = url.split('/')[2];

          var game = BackendService.addOne(entity, params);

          // get the id of the new resource to populate the Location field
          var gameid = game.gameid;

          return [201, game, { Location: '/api/airline/' + gameid }];
      };

      var respondUpdateOne = function(method, url, data) {
          var params = angular.fromJson(data);

          // parse the matching URL to pull out the id (/games/:id)
          var entity   = url.split('/')[2];
          var entityId = url.split('/')[3];

          var game = BackendService.updateOne(entity, entityId, params);

          return [201, game, { Location: '/api/airline/' + entityId }];
      };

      var responseDeleteOne = function(method, url, data) {
          // parse the matching URL to pull out the id (/games/:id)
          var entity   = url.split('/')[2];
          var entityId = url.split('/')[3];

          BackendService.deleteOne(entity, entityId);

          return [204, {}, {}];
      };

      // airlines
      $httpBackend.whenGET('/api/airline').respond(respondGetAll);
      $httpBackend.whenGET(/\/api\/airline\/\d+/).respond(respondGetOne);
      $httpBackend.whenPOST('/api/airline').respond(respondCreateOne);
      $httpBackend.whenPOST(/\/api\/airline\/\d+/).respond(respondUpdateOne);
      $httpBackend.whenDELETE(/\/api\/airline\/\d+/).respond(responseDeleteOne);

      // destiny
      $httpBackend.whenGET('/api/destiny').respond(respondGetAll);
      $httpBackend.whenGET(/\/api\/destiny\/\d+/).respond(respondGetOne);
      $httpBackend.whenPOST('/api/destiny').respond(respondCreateOne);
      $httpBackend.whenPOST(/\/api\/destiny\/\d+/).respond(respondUpdateOne);
      $httpBackend.whenDELETE(/\/api\/destiny\/\d+/).respond(responseDeleteOne);

      // passenger
      $httpBackend.whenGET('/api/passenger').respond(respondGetAll);
      $httpBackend.whenGET(/\/api\/passenger\/\d+/).respond(respondGetOne);
      $httpBackend.whenPOST('/api/passenger').respond(respondCreateOne);
      $httpBackend.whenPOST(/\/api\/passenger\/\d+/).respond(respondUpdateOne);
      $httpBackend.whenDELETE(/\/api\/passenger\/\d+/).respond(responseDeleteOne);



      $httpBackend.whenGET(/modules\//).passThrough();
      $httpBackend.whenGET(/directives\//).passThrough();
    });

})();
