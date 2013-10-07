import geb.spock.GebReportingSpec
import pages.IndexPage
import pages.modules.Navbar

class IndexSpec extends GebReportingSpec {

    def "Go index page"() {
        when:
            to IndexPage
        then:
            waitFor {
                at IndexPage
                navbar.present
            }
    }

}
