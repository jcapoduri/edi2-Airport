'use strict';

(function() {

  angular.module('Airport')
      .config(['$stateProvider',
        function($stateProvider) {
          var helloState = {
            name: 'Dashboard',
            url: '/',
            template: '<h3>hello world!</h3>'
          };

          var aboutState = {
            name: 'about',
            url: '/about',
            template: '<h3>Its the UI-Router hello world app!</h3>'
          };

          $stateProvider.state(helloState);
          $stateProvider.state(aboutState);
        }])
      .config(['cfpLoadingBarProvider', function(cfpLoadingBarProvider) {
        cfpLoadingBarProvider.includeSpinner = true;
      }])
      .config(['$httpProvider', function($httpProvider) {
        $httpProvider.interceptors.push('httpErrorInterceptor');
      }]);
})();
