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

    private static BrowserMobProxy bmproxy;

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        bmproxy = new BrowserMobProxyServer();
        bmproxy.start();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(bmproxy);
        desiredCapabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
//        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        WebDriver driver = new ChromeDriver(desiredCapabilities);
        return driver;
    }

    @AfterAll
    public static void down() {
        WebDriverRunner.closeWebDriver();
        bmproxy.stop();
    }
}
