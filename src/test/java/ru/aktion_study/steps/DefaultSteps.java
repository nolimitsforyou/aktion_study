package ru.aktion_study.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.aktion_study.test.Locators;


public class DefaultSteps {

    private WebDriver driver;

    public DefaultSteps (WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть в браузере страницу")
    public DefaultSteps openPageInBrowser(String url) {
        this.driver.get(url);
        return this;
    }

    @Step("Проверить что отображается логотип гугла")
    public DefaultSteps checkLogoGoogle() {
        WebElement web = this.driver.findElement(Locators.googleLogo);
        web.isDisplayed();
        return this;
    }

    @Step("Проверить что отображается логотип яндекса")
    public DefaultSteps checkLogoYandex() {
        WebElement web = this.driver.findElement(Locators.yandexLogo);
        web.isDisplayed();
        return this;
    }
}
