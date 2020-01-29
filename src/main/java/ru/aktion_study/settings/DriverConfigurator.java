package ru.aktion_study.settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.stqa.selenium.factory.WebDriverPool;

public class DriverConfigurator {
    private static Boolean useProxy = true;
    private WebDriver driver = WebDriverPool.DEFAULT.getDriver(configureChrome());

    private ChromeOptions configureChrome() {
        DesiredCapabilities caps = new DesiredCapabilities();
//        if (useProxy) caps.setCapability(CapabilityType.PROXY, seleniumProxy);
        ChromeOptions options = new ChromeOptions();
        options.merge(caps);
        options.addArguments("--ignore-certificate-errors");
        return options;
    }

    public WebDriver getChromeDriver() {
        driver.manage().window().maximize();
        return driver;
    }
}
