package ru.aktion_study.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static ru.aktion_study.test.Locators.googleLogo;
import static ru.aktion_study.test.Locators.yandexLogo;


public class SimpleTest extends TestBase {

    private String url = "http://google.com";

    @Test
    public void test() {

        openPageInBrowser(url);
        checkLogoGoogle(googleLogo);
        checkLogoYandex(yandexLogo);

    }

    @Step("Открыть в браузере страницу")
    public void openPageInBrowser(String url) {
        open(url);
    }

    @Step("Проверить что отображается логотип гугла")
    public void checkLogoGoogle(SelenideElement element) {
        element.shouldBe(Condition.visible);
    }

    @Step("Проверить что отображается логотип яндекса")
    public void checkLogoYandex(SelenideElement element) {
        element.shouldBe(Condition.visible);
    }

}
