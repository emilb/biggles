package pages

class TitlesAlphaPage extends BasePage {
    static url = "/#/titles/alpha"
    static at = {
        $('h2', 0).text() == 'Titlar i bokstavsordning'
        $('li.active').text() == 'Titlar'
        true
    }
    static content = {

    }

}