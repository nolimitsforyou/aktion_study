package ru.aktion_study.test;

import com.codeborne.selenide.WebDriverRunner;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Proxy;


public class TestBase {

    public static BrowserMobProxy server;

    @BeforeAll
    public static void setUp() {
        server = new BrowserMobProxyServer();
        server.start();

        Proxy seleniumProxy = new Proxy();
        WebDriverRunner.setProxy(seleniumProxy);
    }

    @AfterAll
    public static void down() {
        WebDriverRunner.closeWebDriver();
        server.stop();
    }
}
