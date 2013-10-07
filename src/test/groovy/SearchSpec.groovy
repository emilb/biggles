import geb.spock.GebReportingSpec
import pages.IndexPage

class SearchSpec extends GebReportingSpec {

    def "Search for oknen"() {
        when:
            to IndexPage
        then:
            at IndexPage
            navbar.search << "öknen"
            navbar.submit()

            waitFor {
                // First result should be Biggles i öknen
                $('td a', 0).text() == 'Biggles i öknen'

                // Total noof results should be 2
                $('td a').size() == 2
            }
    }
}
