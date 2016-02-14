'use strict';

var App = angular.module('gym',['ui.router']);

App.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){

    $urlRouterProvider.otherwise("/home");

    $stateProvider
        .state('home', {
            url: "/home",
            templateUrl: 'static/templates/programs.html',
            controller : "HomeController",
            resolve: {
                programs: ['ProgramService', function(ProgramService) {
                    return ProgramService.getProgramList();
                }]
            }
        })

        .state('exercises', {
            url: "/exercises/:programId",
            templateUrl: 'static/templates/exercises.html',
            controller : "ExerciseController",
            resolve: {
                exercises: ['ProgramService', '$stateParams', function(ProgramService, $stateParams) {
                    return ProgramService.getExercisesByProgramId($stateParams.programId);
                }]
            }
        })
        //
        //.state('category.list', {
        //    url: '/{categoryId:[A-Za-z]{0,9}}',
        //    templateUrl: function(params){ return 'category/' + params.categoryId; },
        //    controller : "ItemListController as itemListCtrl",
        //    resolve: {
        //        async: ['ItemService', '$stateParams', function(ItemService, $stateParams) {
        //            return ItemService.fetchAllItems($stateParams.categoryId);
        //        }]
        //    }
        //})
        //
        //.state('category.list.detail', {
        //    url: '/{itemId:[0-9]{1,9}}',
        //    templateUrl: function(params){ return 'category/' + params.categoryId +'/'+params.itemId; },
        //    controller : "ItemDetailsController as itemDetailsCtrl",
        //    resolve: {
        //        async: ['ItemService', '$stateParams', function(ItemService, $stateParams) {
        //            return ItemService.fetchSpecificItem($stateParams.categoryId, $stateParams.itemId);
        //        }]
        //    }
        //})

    //$stateProvider
    //    .state('category', {
    //        url: "/category",
    //        templateUrl: 'category',
    //        controller : "CategoryController as ctgController",
    //        resolve: {
    //            async: ['ItemService', function(ItemService) {
    //                return ItemService.fetchCategoryList();
    //            }]
    //        }
    //    })
    //
    //    .state('category.list', {
    //        url: '/{categoryId:[A-Za-z]{0,9}}',
    //        templateUrl: function(params){ return 'category/' + params.categoryId; },
    //        controller : "ItemListController as itemListCtrl",
    //        resolve: {
    //            async: ['ItemService', '$stateParams', function(ItemService, $stateParams) {
    //                return ItemService.fetchAllItems($stateParams.categoryId);
    //            }]
    //        }
    //    })
    //
    //    .state('category.list.detail', {
    //        url: '/{itemId:[0-9]{1,9}}',
    //        templateUrl: function(params){ return 'category/' + params.categoryId +'/'+params.itemId; },
    //        controller : "ItemDetailsController as itemDetailsCtrl",
    //        resolve: {
    //            async: ['ItemService', '$stateParams', function(ItemService, $stateParams) {
    //                return ItemService.fetchSpecificItem($stateParams.categoryId, $stateParams.itemId);
    //            }]
    //        }
    //    })

}]);
