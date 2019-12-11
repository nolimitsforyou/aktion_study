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
        checkLogo(googleLogo);
        checkLogo(yandexLogo);

    }

    @Step("Открыть в браузере страница")
    public void openPageInBrowser(String url) {
        open(url);
    }

    @Step("Проверить что отображается логотив гугл")
    public void checkLogo(SelenideElement element) {
        element.shouldBe(Condition.visible);
    }

}
