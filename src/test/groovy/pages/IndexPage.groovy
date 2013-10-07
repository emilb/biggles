package pages

import pages.BasePage
import pages.modules.Navbar

class IndexPage extends BasePage {
    static url = "/#/"

    static at = {
        $('h2', 0).text() == 'Biggles i Sverige'
    }

    static content = {

    }

}