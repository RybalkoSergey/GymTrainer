//App.factory('ProgramService', ['ProgramResource', function(ProgramResource) {
//    return {
//        getPrograms: function() {
//            console.log("ProgramService");
//            return ProgramResource.get().$promise;
//        }
//    };
//
//}]);


'use strict';

App.factory('ProgramService', ['$http', '$q', function($http, $q){

    return {
        getProgramList: function() {
            return $http.get('http://localhost:8080/gymtrainer/program')
                .then(
                function(response){
                    return response.data;
                },
                function(errResponse){
                    console.error('Error while fetching Programs');
                    return $q.reject(errResponse);
                }
            );
        },
        getExercisesByProgramId: function(programId) {
            return $http.get('http://localhost:8080/gymtrainer/program/' + programId + "/exercises")
                .then(
                function(response){
                    return response.data;
                },
                function(errResponse){
                    console.error('Error while fetching Exerices');
                    return $q.reject(errResponse);
                }
            );
        }
    };

}]);

