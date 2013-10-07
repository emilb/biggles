angular.module('bigglesapp', ['ui.bootstrap']).
  config(['$routeProvider', function($routeProvider) {
	  $routeProvider.
	      when('/', {templateUrl: 'partials/about.html', controller: aboutCtrl}).
	      when('/books/search/:searchTerm', {templateUrl: 'partials/book-list.html', controller: bookListCtrl}).
	      when('/book/:title/:bookId', {templateUrl: 'partials/book-detail.html', controller: bookDetailCtrl}).
	      when('/publisher/:name/:publisherId', {templateUrl: 'partials/book-list.html', controller: bookListPublisherCtrl}).
	      when('/publishers', {templateUrl: 'partials/name-list.html', controller: publisherCtrl}).
	      when('/illustrator/:name/:illustratorId', {templateUrl: 'partials/book-list.html', controller: bookListIllustratorCtrl}).
	      when('/illustrators', {templateUrl: 'partials/name-list.html', controller: illustratorCtrl}).
          when('/translator/:name/:translatorId', {templateUrl: 'partials/book-list.html', controller: bookListTranslatorCtrl}).
          when('/translators', {templateUrl: 'partials/name-list.html', controller: translatorCtrl}).
          when('/title/:name/:titleId', {templateUrl: 'partials/book-list.html', controller: bookListTitleCtrl}).
          when('/titles/alpha', {templateUrl: 'partials/title-list.html', controller: titleAlphaCtrl}).
          when('/titles/chrono', {templateUrl: 'partials/title-list.html', controller: titleChronoCtrl}).
          otherwise({redirectTo: '/'});
    }]);

BigglesUtil = window.BigglesUtil || {};

BigglesUtil.Paginator = function (items, itemsPerPage) {
    this.items = items;
    this.itemsPerPage = itemsPerPage;
    this.currentPage = 1;

    this.noOfPages = Math.ceil(items.length / this.itemsPerPage);
    this.itemsInCurrentPage = items.slice(0, this.itemsPerPage);

    this.noOfItems = function () {
        return this.items.length;
    }

    this.setPage = function (pageNo) {
        this.itemsInCurrentPage = this.items.slice((pageNo - 1) * this.itemsPerPage, pageNo * this.itemsPerPage);
        this.currentPage = pageNo;
    }

    this.range = function () {
        var pageArr = [];
        for (i = 1; i <= this.noOfPages; i++) {
            pageArr.push(i);
        }
        return pageArr;
    }
};