package ru.aktion_study.test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.aktion_study.steps.DefaultSteps;


public class SimpleTest extends TestBase {

    private WebDriver driver = createDriver(new DesiredCapabilities());
    private String url = "http://google.com";

    @Test
    public void test() {
        new DefaultSteps(driver)
                .openPageInBrowser(url)
                .checkLogoGoogle()
                .checkLogoYandex();
    }
}
