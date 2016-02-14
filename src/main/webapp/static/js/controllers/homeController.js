'use strict';

App.controller('HomeController', ['$scope', 'programs', function($scope, programs) {

    $scope.programs = programs;

}]);
