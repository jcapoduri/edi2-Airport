//$httpBackend
'use strict';

(function () {
  angular
    .module('Airport')
    .run(function BackendMockup ($httpBackend, BackendService) {
      $httpBackend.whenGET('/api/airline').respond(function(method, url, data) {
          var entity   = url.split('/')[2];
          var response = BackendService.findAll(entity);
          return [200, response, {}];
      });

      $httpBackend.whenGET(/\/api\/airline\/\d+/).respond(function(method, url, data) {
          // parse the matching URL to pull out the id (/games/:id)
          var entity   = url.split('/')[2];
          var entityId = url.split('/')[3];

          var game = BackendService.findOne(entity, entityId);

          return [200, game, {}];
      });

      // this is the creation of a new resource
      $httpBackend.whenPOST('/api/airline').respond(function(method, url, data) {
          var params = angular.fromJson(data),
              entity   = url.split('/')[2];

          var game = BackendService.addOne(entity, params);

          // get the id of the new resource to populate the Location field
          var gameid = game.gameid;

          return [201, game, { Location: '/api/airline/' + gameid }];
      });

      // this is the update of an existing resource (ngResource does not send PUT for update)
      $httpBackend.whenPOST(/\/api\/airline\/\d+/).respond(function(method, url, data) {
          var params = angular.fromJson(data);

          // parse the matching URL to pull out the id (/games/:id)
          var entity   = url.split('/')[2];
          var entityId = url.split('/')[3];

          var game = BackendService.updateOne(entity, entityId, params);

          return [201, game, { Location: '/api/airline/' + entityId }];
      });

      // this is the update of an existing resource (ngResource does not send PUT for update)
      $httpBackend.whenDELETE(/\/api\/airline\/\d+/).respond(function(method, url, data) {
          // parse the matching URL to pull out the id (/games/:id)
          var entity   = url.split('/')[2];
          var entityId = url.split('/')[3];

          BackendService.deleteOne(entity, entityId);

          return [204, {}, {}];
      });

      $httpBackend.whenGET(/modules\//).passThrough();
      $httpBackend.whenGET(/directives\//).passThrough();
    });

})();
