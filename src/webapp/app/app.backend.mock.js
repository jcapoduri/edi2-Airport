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
          var gameid = url.split('/')[2];

          var game = BackendService.findOne(gameid);

          return [200, game, {}];
      });

      // this is the creation of a new resource
      $httpBackend.whenPOST('/api/airline').respond(function(method, url, data) {
          var params = angular.fromJson(data);

          var game = BackendService.addOne(params);

          // get the id of the new resource to populate the Location field
          var gameid = game.gameid;

          return [201, game, { Location: '/api/airline/' + gameid }];
      });

      // this is the update of an existing resource (ngResource does not send PUT for update)
      $httpBackend.whenPOST(/\/api\/airline\/\d+/).respond(function(method, url, data) {
          var params = angular.fromJson(data);

          // parse the matching URL to pull out the id (/games/:id)
          var gameid = url.split('/')[2];

          var game = BackendService.updateOne(gameid, params);

          return [201, game, { Location: '/api/airline/' + gameid }];
      });

      // this is the update of an existing resource (ngResource does not send PUT for update)
      $httpBackend.whenDELETE(/\/api\/airline\/\d+/).respond(function(method, url, data) {
          // parse the matching URL to pull out the id (/games/:id)
          var gameid = url.split('/')[2];

          BackendService.deleteOne(gameid);

          return [204, {}, {}];
      });

      $httpBackend.whenGET(/modules\//).passThrough();
      $httpBackend.whenGET(/directives\//).passThrough();
    });

})()
