package pages

import geb.Page
import pages.modules.Navbar


class BasePage extends Page {

    static content = {
        navbar { module Navbar }
    }

    def getBaseUrl() { "" }

    /**
     * Overriding default convertToPath and appends baseUrl
     * we
     */
    String convertToPath(Object[] args) {
        super.convertToPath(args) + this.getBaseUrl()
    }

}
