function BooksCtrl($scope, $http) {
    $http.get('api/book/list').success(function(data) {
        $scope.books = data;
    });
}

function BookListCtrl($scope, $http) { // <-- need to get search value somewhere

}

function BookDetailCtrl($scope, $http, $routeParams) {
	$scope.bookId = $routeParams.bookId;
	$http.get('api/book/id/' + $scope.bookId).success(function(data) {
        $scope.book = data;
    });
}