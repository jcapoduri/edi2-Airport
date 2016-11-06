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
        controllerAs: 'vm',
        controller: AirportEditorController,
        scope: {
          airline: '=?model'
        },
        bindToController: true
    };
    return directive;

    function link(scope, element, attrs) {
    }

    AirportEditorController.$inject = ['$scope'];

    function AirportEditorController($scope) {
        // Injecting $scope just for comparison
        var vm = this;

        vm.save = function() {
          if (!$scope.airlineForm.$invalid) {
            vm.airline.$save();
            $scope.$emit('save');
          };
        }

        vm.cancel = function() {
          $scope.$emit('cancel');
        }
    }
  }

})();
