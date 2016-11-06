'use strict';

(function() {

  angular
    .module('Airport')
    .factory('httpErrorInterceptor', httpErrorInterceptor);

  httpErrorInterceptor.$inject = ['$q', '$injector'];
  
  function httpErrorInterceptor($q, $injector) {
     var myInterceptor = {
        responseError: function(response) {
            if (response.status > 200){
              toastr.options = {
                "closeButton": true,
                "debug": false,
                "newestOnTop": false,
                "progressBar": true,
                "positionClass": "toast-bottom-right",
                "preventDuplicates": false,
                "onclick": null,
                "showDuration": "300",
                "hideDuration": "1000",
                "timeOut": "5000",
                "extendedTimeOut": "1000",
                "showEasing": "swing",
                "hideEasing": "linear",
                "showMethod": "fadeIn",
                "hideMethod": "fadeOut"
              }
              toastr.error(response.data.message)
            }
            return $q.reject(response);
        }
    };

    return myInterceptor;
  }

})();
