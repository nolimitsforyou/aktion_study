package ru.aktion_study.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.aktion_study.test.TestBase;

import static ru.aktion_study.test.Locators.googleLogo;
import static ru.aktion_study.test.Locators.yandexLogo;


public class DefaultSteps {

    private WebDriver driver = TestBase.driver;

    @Step("Открыть в браузере страницу")
    public DefaultSteps openPageInBrowser(String url) {
        driver.get(url);
        return this;
    }

    @Step("Проверить что отображается логотип гугла")
    public DefaultSteps checkLogoGoogle() {
        WebElement web = driver.findElement(googleLogo);
        web.isDisplayed();
        return this;
    }

    @Step("Проверить что отображается логотип яндекса")
    public DefaultSteps checkLogoYandex() {
        WebElement web = driver.findElement(yandexLogo);
        web.isDisplayed();
        return this;
    }
}
