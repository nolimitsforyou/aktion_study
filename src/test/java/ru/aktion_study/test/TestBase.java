package ru.aktion_study.test;

import com.browserup.bup.BrowserUpProxy;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;



public class TestBase {

    @BeforeAll
    public static void setUp() {

        Configuration.proxyEnabled = true;
        Configuration.startMaximized = true;
        Configuration.browser = "chrome";
        BrowserUpProxy bup = WebDriverRunner.getSelenideProxy().getProxy();
        bup.start();
    }

    @AfterAll
    public static void down() {
        WebDriverRunner.closeWebDriver();
    }
}
