angular.module('bigglesapp', ['ui.bootstrap']).
  config(['$routeProvider', function($routeProvider) {
	  $routeProvider.
	      when('/', {templateUrl: 'partials/about.html', controller: AboutCtrl}).
	      when('/books/search/:searchTerm', {templateUrl: 'partials/book-list.html',   controller: BookListCtrl}).
	      when('/book/:title/:bookId', {templateUrl: 'partials/book-detail.html', controller: BookDetailCtrl}).
	      when('/publisher/:name/:publisherId', {templateUrl: 'partials/book-list.html', controller: BookListPublisherCtrl}).
	      when('/illustrator/:name/:illustratorId', {templateUrl: 'partials/book-list.html', controller: BookListIllustratorCtrl}).
	      when('/translator/:name/:translatorId', {templateUrl: 'partials/book-list.html', controller: BookListTranslatorCtrl}).
	      when('/title/:name/:titleId', {templateUrl: 'partials/book-list.html', controller: BookListTitleCtrl}).
	      otherwise({redirectTo: '/'});
	}]);