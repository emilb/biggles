

import geb.spock.GebReportingSpec
import pages.TitlesAlphaPage

class TitlesAlphaSpec extends GebReportingSpec {

    def "List books alphabetically"() {
        when:
            to TitlesAlphaPage
        then:
            at TitlesAlphaPage

            waitFor {
                // First result should be Biggles & Co
                $('td a', 0).text() == 'Biggles & Co'

                // Total noof pages should be 13 + 2 (for navigation first and last)
                $('ul.pagination a').size() == 15
            }
    }
}
