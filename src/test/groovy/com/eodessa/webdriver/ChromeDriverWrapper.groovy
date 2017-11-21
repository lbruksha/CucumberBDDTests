package com.eodessa.webdriver

import org.openqa.selenium.*
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeDriverService
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

class ChromeDriverWrapper extends RemoteWebDriver{

    private final ChromeDriver driver
    public static final boolean HEADLESS = System.properties['headless'] ?: false


    ChromeDriverWrapper() {
        Capabilities capabilities = DesiredCapabilities.chrome()
        ChromeOptions chromeOptions = new ChromeOptions()
        if (HEADLESS) {
            chromeOptions.addArguments("headless")
        }
        chromeOptions.addArguments("window-size=1280,1696")
        capabilities.setCapability("chromeOptions", chromeOptions)
        driver = new ChromeDriver(ChromeDriverService.createDefaultService(), capabilities)
    }

    @Override
    void get(String url) {
        driver.get(url)
    }

    @Override
    String getCurrentUrl() {
        return driver.getCurrentUrl()
    }

    @Override
    String getTitle() {
        return driver.getTitle()
    }

    @Override
    List<WebElement> findElements(By by) {
        return driver.findElements(by)
    }

    @Override
    WebElement findElement(By by) {
        return driver.findElement(by)
    }

    @Override
    String getPageSource() {
        return driver.getPageSource()
    }

    @Override
    void close() {
        driver.close()
    }

    @Override
    void quit() {
        driver.quit()
    }

    @Override
    Set<String> getWindowHandles() {
        return driver.getWindowHandles()
    }

    @Override
    String getWindowHandle() {
        return driver.getWindowHandle()
    }

    @Override
    WebDriver.TargetLocator switchTo() {
        return driver.switchTo()
    }

    @Override
    WebDriver.Navigation navigate() {
        return driver.navigate()
    }

    @Override
    WebDriver.Options manage() {
        return driver.manage()
    }

    Object executeScript(String script, Object... args) {
        return driver.executeScript(script, args)
    }

    Object executeAsyncScript(String script, Object... args) {
        return driver.executeAsyncScript(script, args)
    }
}