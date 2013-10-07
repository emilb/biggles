describe('the Paginator object',function() {

    var dataArray = new Array();
    for (i=0; i < 100; i++) {
        dataArray.push(i);
    }

    describe ('should calculate number of pages', function() {

        it('correctly when items evenly matches page size',function() {
            var paginator = new BigglesUtil.Paginator(dataArray, 10);
            expect(paginator.noOfPages).toBe(10);
        });

        it('correctly when items unevenly matches page size',function() {
            var paginator = new BigglesUtil.Paginator(dataArray.slice(1, 27), 10);
            expect(paginator.noOfPages).toBe(3);
        });
    });

    describe ('should calculate number of items in current page', function() {

        it('correctly when items evenly matches page size',function() {
            var paginator = new BigglesUtil.Paginator(dataArray, 10);
            paginator.setPage(10);

            expect(paginator.itemsInCurrentPage.length).toBe(10);
            expect(paginator.currentPage).toBe(10);
        });

        it('correctly when items unevenly matches page size',function() {
            var paginator = new BigglesUtil.Paginator(dataArray.slice(1,27), 10);
            paginator.setPage(3);

            expect(paginator.itemsInCurrentPage.length).toBe(6);
            expect(paginator.currentPage).toBe(3);
        });
    });

    describe ('should return correct page range', function() {

        it('correctly when items evenly matches page size',function() {
            var paginator = new BigglesUtil.Paginator(dataArray.slice(1,30), 10);

            expect(paginator.range()).toEqual([1,2,3]);
        });

        it('correctly when items unevenly matches page size',function() {
            var paginator = new BigglesUtil.Paginator(dataArray.slice(1,37), 10);

            expect(paginator.range()).toEqual([1,2,3,4]);
        });
    });
});
