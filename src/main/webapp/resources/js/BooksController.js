function AboutCtrl($scope, $http) {
    $http.get('api/book/list/random/25').success(function(data) {
        $scope.books = data;
        $scope.books[0].active = true;
    });
}

function BookListCtrl($scope, $http, $routeParams) {
    $scope.searchTerm = $routeParams.searchTerm;

    $http.get('api/book/search/title/' + $scope.searchTerm).success(function(data) {
        $scope.books = data;
        $scope.title = 'Sökresultat: ' + $scope.searchTerm;
    });
}

function BookDetailCtrl($scope, $http, $routeParams) {
	$scope.bookId = $routeParams.bookId;
    $scope.hasNoStory = true;

	$http.get('api/book/id/' + $scope.bookId).success(function(data) {
        $scope.book = data;
        if ($scope.book.story) {
            $scope.hasNoStory = false;
        }

        $scope.book.hasCover = $scope.book.hasCover ? 'Ja' : 'Nej';
    });
}

function BookSearchCtrl($scope, $location) {
    $scope.searchTerm = '';
    $scope.doSearch = function() {
        $location.path('/books/search/' + $scope.searchTerm);
    }
}

function TranslatorCtrl($scope, $http) {
    $http.get('api/translator/list').success(function(data) {
        $scope.translators = data;
    });
}

function IllustratorCtrl($scope, $http) {
    $http.get('api/illustrator/list').success(function(data) {
        $scope.illustrators = data;
    });
}

function PublisherCtrl($scope, $http) {
    $http.get('api/publisher/list').success(function(data) {
        $scope.publishers = data;
    });
}

function TitleCtrl($scope, $http) {
    $http.get('api/title/list').success(function(data) {
        $scope.titles = data;
    });
}

function BookListPublisherCtrl($scope, $http, $routeParams, $location) {
    $scope.publisherId = $routeParams.publisherId;

    $http.get('api/book/list/publisher/id/' + $scope.publisherId).success(function(data) {
        $scope.books = data;
    });

    $http.get('api/publisher/id/' + $scope.publisherId).success(function(data) {
        $scope.publisher = data;
        $scope.title = 'Böcker publicerade av ' + $scope.publisher.name;
    });

    $scope.showDetail = function(book) {
        $location.path('/book/' + book.titleSwedishSlug + '/' + book.id);
    }
}
function BookListTranslatorCtrl($scope, $http, $routeParams, $location) {
    $scope.translatorId = $routeParams.translatorId;

    $http.get('api/book/list/translator/id/' + $scope.translatorId).success(function(data) {
        $scope.books = data;
    });

    $http.get('api/translator/id/' + $scope.translatorId).success(function(data) {
        $scope.translator = data;
        $scope.title = 'Böcker översatta av ' + $scope.translator.name;
    });

    $scope.showDetail = function(book) {
        $location.path('/book/' + book.titleSwedishSlug + '/' + book.id);
    }
}

function BookListIllustratorCtrl($scope, $http, $routeParams, $location) {
    $scope.illustratorId = $routeParams.illustratorId;

    $http.get('api/book/list/illustrator/id/' + $scope.illustratorId).success(function(data) {
        $scope.books = data;
    });

    $http.get('api/illustrator/id/' + $scope.illustratorId).success(function(data) {
        $scope.illustrator = data;
        $scope.title = 'Böcker illustrerade av ' + $scope.illustrator.name;
    });

    $scope.showDetail = function(book) {
        $location.path('/book/' + book.titleSwedishSlug + '/' + book.id);
    }
}

function BookListTitleCtrl($scope, $http, $routeParams, $location) {
    $scope.titleId = $routeParams.titleId;

    $http.get('api/book/list/title/id/' + $scope.titleId).success(function(data) {
        $scope.books = data;
    });

    $http.get('api/illustrator/id/' + $scope.titleId).success(function(data) {
        $scope.title = data;
        $scope.title = 'Publiceringar av ' + $scope.title.name;
    });

    $scope.showDetail = function(book) {
        $location.path('/book/' + book.titleSwedishSlug + '/' + book.id);
    }
}