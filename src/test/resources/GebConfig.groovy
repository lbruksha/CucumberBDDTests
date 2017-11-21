import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.remote.DesiredCapabilities

/**
 * This is the Geb configuration file.
 * See: http://www.gebish.org/manual/current/configuration.html
 *
 * Global Specific Settings
 */

// Allows users to install multiple versions of FF.  Geb will always use the one defined as Firefox28
String browserPath = System.properties['browser.path'] ?: "/Applications/Firefox28.app/Contents/MacOS/firefox"
System.setProperty("webdriver.firefox.bin", browserPath )

// Geb includes a simple reporting mechanism which can be used to snapshot the state of the browser at any point in time.
//For more info see: http://www.gebish.org/manual/current/#reporting
reportsDir = "target/geb-reports"

//baseUrl = ''

// default driver (uses when geb.env VM flag not set)
driver = {
    def driverInstance = new FirefoxDriver()
    driverInstance.manage().window().maximize()
    driverInstance
}

waiting {
    // If unspecified, the values of 5 for timeout and 0.1 for retryInterval.
    // timeout = 10
    // retryInterval = 0.5

    // Some runtimes, namely Maven Surefire Plugin, don’t print the full exception stacktrace and exclude the cause from them.
    includeCauseInMessage = true

    // At checkers can be configured to be implicitly wrapped with waitFor() calls. This can be set with:
    atCheckWaiting = true

    // Global preset timeout values, used via the following e.g: waitFor("slow") { at(PageObject) }
    presets {
        fast {
            timeout = 3
            retryInterval = 0.1
        }

        medium {
            timeout = 5
            retryInterval = 0.2
        }

        slow {
            timeout = 10
            retryInterval = 0.3
        }

        reallySlow {
            timeout = 20
            retryInterval = 0.5
        }

        pageLoad_90 {
            timeout = 90
            retryInterval = 0.2
        }

        pageLoad_120 {
            timeout = 120
            retryInterval = 0.2
        }

        pageLoad_300 {
            timeout = 300
            retryInterval = 0.2
        }
    }
}

/**
 * Environment Specific Settings
 *
 * Change Geb's environment using: -Dgeb.env=chrome JVM args.
 */
environments {

    // See: http://code.google.com/p/selenium/wiki/ChromeDriver
    chrome {
        driver = {
            DesiredCapabilities capabilities = DesiredCapabilities.chrome()
            capabilities.setCapability("chrome.switches", ["--start-maximized"])
            new ChromeDriver(capabilities)
        }
    }
}

