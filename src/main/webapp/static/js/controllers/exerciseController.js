'use strict';

App.controller('ExerciseController', ['$scope', 'exercises', function($scope, exercises) {

    $scope.exercises = exercises;

}]);