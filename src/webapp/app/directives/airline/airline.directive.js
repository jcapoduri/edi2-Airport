'use strict';

(function() {
  angular
    .module('Airport.airline')
    .directive('airline', airlineEditor);

  function airlineEditor () {
    var directive = {
        link: link,
        templateUrl: 'directives/airline/airline.partial.html',
        restrict: 'EA',
        scope: {
          data: '='
        }
    };
    return directive;

    function link(scope, element, attrs) {

    }
  }

})();
