package pages.modules

import geb.Module

class Navbar extends Module {
    static base = { $("div.navbar") }

    static content = {
        search { $('input', 'type': 'text') }
        searchButton { $('button', 'type': 'submit') }
        submit { searchButton.click() }
    }
}
