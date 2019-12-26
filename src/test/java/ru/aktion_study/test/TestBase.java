package ru.aktion_study.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.proxy.CaptureType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.aktion_study.test.proxy.Bmp;

public class TestBase {


    @BeforeAll
    public static void setUp() {
        System.setProperty("selenide.browser", "ru.aktion_study.test.proxy.BmpChrome");
        Bmp.proxyServer = new BrowserMobProxyServer();
        Bmp.proxyServer.start(0);
        Bmp.proxyServer.setHarCaptureTypes(CaptureType
                .getAllContentCaptureTypes());

//        Configuration.startMaximized = true;
//        Configuration.timeout = 10L;
//        DesiredCapabilities dCapabilities = new DesiredCapabilities();
//        dCapabilities.setBrowserName("chrome");
//        Configuration.browserCapabilities = dCapabilities;
    }

    @AfterAll
    public static void down() {
        WebDriverRunner.closeWebDriver();
    }
}
