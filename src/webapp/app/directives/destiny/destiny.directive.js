'use strict';

(function() {
  angular
    .module('Airport.airline')
    .directive('destiny', airlineEditor);

  function airlineEditor () {
    var directive = {
        link: link,
        templateUrl: 'directives/airline/destiny.partial.html',
        restrict: 'EA'
    };
    return directive;

    function link(scope, element, attrs) {

    }
  };

})();
