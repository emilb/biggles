import geb.spock.GebReportingSpec
import pages.IllustratorsPage

class IllustratorsSpec extends GebReportingSpec {

    def "List illustrators"() {
        when:
            to IllustratorsPage
        then:
            at IllustratorsPage
            waitFor {
                $('h2', 0).text() == 'Illustratörer'
                $('li.active').text() == 'Illustratörer'

                // Look for Bertil Hegland
                def foundBertil = false

                $('tr a').each {
                    if (it.text() == "Bertil Hegland") foundBertil = true
                }
                foundBertil == true
            }

    }
}
