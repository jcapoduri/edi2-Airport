"use strict";

(function() {
  angular
    .module("Airport.airline")
    .directive("airlineEditor", airlineEditor);

  var airlineEditor = function () {
    var directive = {
        link: link,
        templateUrl: 'directives/airline/airline.partial.html',
        restrict: 'EA'
    };
    return directive;

    function link(scope, element, attrs) {
      
    }
  };
})();