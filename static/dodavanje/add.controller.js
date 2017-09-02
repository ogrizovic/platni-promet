(function () {
    'use strict';

    angular
        .module('app')
        .controller('PocetnaController', AddController);

    AddController.$inject = ['$location', 'AuthenticationService'];
    function AddController($location, AuthenticationService) {
    	//this = $scope because of  controller as 
        var vm = this;
       
         (function initController() {
            // reset login status
            AuthenticationService.ClearCredentials();
        })();
   
        
    }
})();