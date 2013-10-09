describe('the Paginator object',function() {

    var dataArray = new Array();
    for (i=0; i < 100; i++) {
        dataArray.push(i);
    }

    describe ('should calculate number of pages', function() {

        it('correctly when items evenly matches page size',function() {

            // Paginator takes an array and the pagesize
            var paginator = new BigglesUtil.Paginator(dataArray, 10);
            expect(paginator.noOfPages).toBe(10);
        });

        it('correctly when items unevenly matches page size',function() {
            var paginator = new BigglesUtil.Paginator(dataArray.slice(1, 27), 10);
            expect(false).toBe(true);
        });
    });

    describe ('should calculate number of items in current page', function() {

        it('correctly when items evenly matches page size',function() {
            // Verify that paginator.itemsInCurrentPage and paginator.currentPage
            // are correct when items match pagecount evently
            var paginator = new BigglesUtil.Paginator(dataArray, 10);
            paginator.setPage(10);

            expect(paginator.itemsInCurrentPage.length).toBe(false);
            expect(paginator.currentPage).toBe(false);
        });

        it('correctly when items unevenly matches page size',function() {
            // Verify that paginator.itemsInCurrentPage and paginator.currentPage
            // are correct on the last page when items doesn't match pagecount evently
            expect(false).toBe(true);
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
