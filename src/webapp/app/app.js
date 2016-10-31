"use strict";

(function() {

  angular.module("Airport.services", []);
  angular.module("Airport.airline", ["ui.router"]);

  angular.module("Airport",  [
          "angular-loading-bar" 
          ,"ui.router"
          ,"Airport.services"
          ,'Airport.airline'
      ]);
})();