'use strict';

(function() {

  angular.module('Airport.services', ['ngResource', 'ui.bootstrap']);
  angular.module('Airport.airline', ['ui.router', ,'ui.bootstrap', 'Airport.services']);
  angular.module('Airport.destiny', ['ui.router', ,'ui.bootstrap', 'Airport.services']);
  angular.module('Airport.flight', ['ui.router', ,'ui.bootstrap', 'Airport.services']);
  angular.module('Airport.passenger', ['ui.router', ,'ui.bootstrap', 'Airport.services']);

  angular.module('Airport',  [
    'angular-loading-bar',
    'ui.router',
    'ui.bootstrap',
    'ngMockE2E',
    'ngResource',
    'Airport.services',
    'Airport.airline',
    'Airport.destiny',
    'Airport.passenger',
    'Airport.flight'
  ]);
})();
