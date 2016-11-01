'use strict';

(function() {
  angular
    .module('Airport.airline')
    .directive('destiny', destinyEditor);

  function destinyEditor () {
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
