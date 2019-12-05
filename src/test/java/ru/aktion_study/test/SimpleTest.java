package ru.aktion_study.test;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;


public class SimpleTest extends TestBase {

    private String url = "http://google.com";

    @Test
    public void test() {
        openPageInBrowser(url);
    }

    @Step("Открыть в браузере старницу")
    public void openPageInBrowser(String url) {
        open(url);
    }
}
