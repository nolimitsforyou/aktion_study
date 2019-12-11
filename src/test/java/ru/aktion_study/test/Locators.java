package ru.aktion_study.test;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class Locators {
    public static SelenideElement googleLogo = $x("//img[@id='hplogo']");
    public static SelenideElement yandexLogo = $x("//div[@class='home-logo__default']");
}
