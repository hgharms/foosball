// Rest example
var app = angular.module('_app', ['ngResource']);

app.controller('_controller', function ($scope, _factory){
    function refresh(){
        _factory.query(function (data){
            $scope.players = data;
        });
    }
    refresh();
});

app.factory('_factory', function ($resource){
    return $resource('/foosball/rest/json')
});

// websocket example
//http://clintberry.com/2013/angular-js-websocket-service/