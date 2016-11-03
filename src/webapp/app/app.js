'use strict';

(function() {

  angular.module('Airport.services', ['ngResource']);
  angular.module('Airport.airline', ['ui.router', ,'ui.bootstrap', 'Airport.services']);
  angular.module('Airport.destiny', ['ui.router','Airport.services']);
  angular.module('Airport.flight', ['ui.router','Airport.services']);
  angular.module('Airport.passenger', ['ui.router','Airport.services']);

  angular.module('Airport',  [
     'angular-loading-bar'
    ,'ui.router'
    ,'ui.bootstrap'
    ,'ngMockE2E'
    ,'ngResource'
    ,'Airport.services'
    ,'Airport.airline'
  ]);
})();
