'use strict'
(function() {

  angular.module('EDI2-Airport',  [
          "angular-loading-bar", 
          "ngAnimate",
          "ui.router"/*,
          "bluefeather.features.fee",
          "bluefeather.features.charge",
          "bluefeather.features.workorder",
          "bluefeather.features.request",
          "bluefeather.features.dashboard",
          "bluefeather.shared.resource"*/
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