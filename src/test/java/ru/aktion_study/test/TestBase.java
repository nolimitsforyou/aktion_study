package ru.aktion_study.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {

    @BeforeAll
    public static void setUp() {
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.startMaximized = true;
        Configuration.timeout = 10L;
        DesiredCapabilities dCapabilities = new DesiredCapabilities();
        dCapabilities.setBrowserName("chrome");
        Configuration.browserCapabilities = dCapabilities;
    }

    @AfterAll
    public static void down() {
        WebDriverRunner.closeWebDriver();
    }

}
