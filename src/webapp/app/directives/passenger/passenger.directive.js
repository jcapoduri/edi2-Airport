'use strict';

(function() {
  angular
    .module('Airport.passenger')
    .directive('passenger', passengerEditor);

  function passengerEditor () {
    var directive = {
        link: link,
        templateUrl: 'directives/passenger/passenger.partial.html',
        restrict: 'EA',
        controllerAs: 'vm',
        controller: AirportEditorController,
        scope: {
          passenger: '=?model'
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
          if (!$scope.passengerForm.$invalid) {
            vm.passenger.$save();
            $scope.$emit('save');
          };
        }

        vm.cancel = function() {
          $scope.$emit('cancel');
        }
    }
  }

})();
