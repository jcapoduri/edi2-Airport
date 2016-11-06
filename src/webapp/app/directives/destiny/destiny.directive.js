'use strict';

(function() {
  angular
    .module('Airport.destiny')
    .directive('destiny', destinyEditor);

  function destinyEditor () {
    var directive = {
        link: link,
        templateUrl: 'directives/destiny/destiny.partial.html',
        restrict: 'EA',
        controllerAs: 'vm',
        controller: AirportEditorController,
        scope: {
          destiny: '=?model'
        },
        bindToController: true
    };
    return directive;

    function link(scope, element, attrs) {
    }

    AirportEditorController.$inject = ['$scope'];

    function AirportEditorController($scope) {
        var vm = this;

        vm.save = function() {
          if (!$scope.destinyForm.$invalid) {
            vm.destiny.$save();
            $scope.$emit('save');
          }
        }

        vm.cancel = function() {
          $scope.$emit('cancel');
        }
    }
  }

})();
