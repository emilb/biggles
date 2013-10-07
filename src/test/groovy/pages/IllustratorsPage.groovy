package pages

class IllustratorsPage extends BasePage {
    static url = "/#illustrators"
    static at = {
        $('h2', 0).text() == 'Illustratörer'
        $('li.active').text() == 'Illustratörer'
        true
    }
    static content = {

    }

}