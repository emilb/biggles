function BooksCtrl($scope, $http) {
    $http.get('api/book/list').success(function(data) {
        $scope.books = data;
    });
}