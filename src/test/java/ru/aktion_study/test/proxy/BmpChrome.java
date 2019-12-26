package ru.aktion_study.test.proxy;

import com.codeborne.selenide.WebDriverProvider;
import net.lightbody.bmp.client.ClientUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BmpChrome implements WebDriverProvider {
    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.PROXY, ClientUtil.createSeleniumProxy(Bmp.proxyServer));
        return new ChromeDriver(options);
    }
}
