/*
	This is the Geb configuration file.

	See: http://www.gebish.org/manual/current/configuration.html
*/

import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.openqa.selenium.phantomjs.PhantomJSDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.Dimension

// See: http://code.google.com/p/selenium/wiki/HtmlUnitDriver
//driver = { new FirefoxDriver() }
//driver = { new HtmlUnitDriver() }

driver = {
    def d = new PhantomJSDriver(new DesiredCapabilities())
    d.manage().window().setSize(new Dimension(1028, 768))
    d
}

environments {

    reportsDir = new File("target/test-reports/geb/")
    baseUrl = "http://localhost:9080"
    // run as “mvn -Dgeb.env=chrome test”
    // See: http://code.google.com/p/selenium/wiki/ChromeDriver
    chrome {
        driver = { new ChromeDriver() }
    }

}

waiting {
    timeout = 15
    retryInterval = 0.5
}