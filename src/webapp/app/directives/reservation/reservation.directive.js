'use strict';

(function() {
  angular
    .module('Airport.reservation')
    .directive('reservation', reservationEditor);

  function reservationEditor () {
    var directive = {
        link: link,
        templateUrl: 'directives/reservation/reservation.partial.html',
        restrict: 'EA',
        controllerAs: 'vm',
        controller: ReservationEditorController,
        scope: {
          flightRoute: '=?model'
        },
        bindToController: true
    };
    return directive;

    function link(scope, element, attrs) {
    }

    AirportEditorController.$inject = ['$scope', 'PassengerResource', 'FlightResource'];

    function ReservationEditorController($scope, PassengerResource, FlightResource) {
        var vm = this;

        PassengerResource.query(function(data) {
          vm.passengers = angular.copy(data);
        });

        FlightResource.query(function(data) {
          vm.flights = angular.copy(data);
        });


        vm.save = function() {
          vm.reservation.$save();
          $scope.$emit('save');
        }

        vm.cancel = function() {
          $scope.$emit('cancel');
        }
    }
  }

})();
