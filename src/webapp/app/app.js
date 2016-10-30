"use strict";

(function() {

  angular.module('EDI2-Airport.airline', ["ui.router"]);

  angular.module('EDI2-Airport',  [
          "angular-loading-bar" 
          ,"ui.router"
          ,'EDI2-Airport.airline'
      ])
      .config(['$stateProvider',
        function($stateProvider) {
          var helloState = {
          name: 'Dashboard',
          url: '/',
          template: '<h3>hello world!</h3>'
        }

        var aboutState = {
          name: 'about',
          url: '/about',
          template: '<h3>Its the UI-Router hello world app!</h3>'
        }

        $stateProvider.state(helloState);
        $stateProvider.state(aboutState);
      }])
      .config(['cfpLoadingBarProvider', function(cfpLoadingBarProvider) {
        cfpLoadingBarProvider.includeSpinner = true;
      }]);
})();