
function BookListCtrl($scope, $http, $routeParams) {
    $scope.searchTerm = $routeParams.searchTerm;
    $http.get('api/book/search/title/' + $scope.searchTerm).success(function(data) {
        $scope.books = data;
    });
}

function BookDetailCtrl($scope, $http, $routeParams) {
	$scope.bookId = $routeParams.bookId;
	$http.get('api/book/id/' + $scope.bookId).success(function(data) {
        $scope.book = data;
    });
}

function BookSearchCtrl($scope, $location) {
    $scope.searchTerm = '';
    $scope.doSearch = function() {
        // Change url
        $location.path('/books/search/' + $scope.searchTerm);
    }
}

function PublisherCtrl($scope, $http) {
    $http.get('api/publisher/list').success(function(data) {
        $scope.publishers = data;
    });
}

function BookListPublisherCtrl($scope, $http, $routeParams, $location) {
    $scope.publisherId = $routeParams.publisherId;

    $http.get('api/book/list/publisher/id/' + $scope.publisherId).success(function(data) {
        $scope.books = data;
    });

    $http.get('api/publisher/id/' + $scope.publisherId).success(function(data) {
        $scope.publisher = data;
    });

    $scope.showDetail = function(book) {
        $location.path('/book/' + book.titleSwedishSlug + '/' + book.id);
    }
}