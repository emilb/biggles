angular.module('bigglesapp', []).
  config(['$routeProvider', function($routeProvider) {
	  $routeProvider.
	      when('/', {templateUrl: 'partials/about.html'}).
	      when('/books/search/:searchTerm', {templateUrl: 'partials/book-list.html',   controller: BookListCtrl}).
	      when('/book/:title/:bookId', {templateUrl: 'partials/book-detail.html', controller: BookDetailCtrl}).
	      when('/publisher/:name/:publisherId', {templateUrl: 'partials/book-list-publisher.html', controller: BookListPublisherCtrl}).
	      otherwise({redirectTo: '/'});
	}]);