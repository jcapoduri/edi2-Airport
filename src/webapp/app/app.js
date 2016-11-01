'use strict';

(function() {

  angular.module('Airport.services', ['ngResource']);
  angular.module('Airport.airline', ['ui.router','Airport.services']);

  angular.module('Airport',  [
          'angular-loading-bar'
          ,'ui.router'
          ,'ngResource'
          ,'Airport.services'
          ,'Airport.airline'
      ]);
})();
