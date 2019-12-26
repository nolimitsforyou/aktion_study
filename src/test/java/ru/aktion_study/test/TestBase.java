package ru.aktion_study.test;


import com.codeborne.selenide.WebDriverProvider;
import com.codeborne.selenide.WebDriverRunner;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;



public class TestBase implements WebDriverProvider {

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        ChromeOptions options = new ChromeOptions();
        BrowserMobProxy bmproxy = new BrowserMobProxyServer();
        bmproxy.start(); // specify the port and address here.
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(bmproxy);
        // configure it as a desired capability
        desiredCapabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
        // start the browser up
        WebDriver driver = new ChromeDriver(desiredCapabilities);
        return driver;
    }

    @AfterAll
    public static void down() {
        WebDriverRunner.closeWebDriver();
    }
}
