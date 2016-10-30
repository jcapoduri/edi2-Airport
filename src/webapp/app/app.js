'use strict'
(function() {

  angular.module('EDI2-Airport',  [
          "angular-loading-bar" 
          ,"ngAnimate"
          ,"ui.router"
          ,'EDI2-Airport.airline'
      ])
      .config(['$routeProvider',
        function($routeProvider) {
          $routeProvider.otherwise({
            redirectTo: '/'
          });
      }])
      .config(['cfpLoadingBarProvider', function(cfpLoadingBarProvider) {
        cfpLoadingBarProvider.includeSpinner = true;
      }]);
})();