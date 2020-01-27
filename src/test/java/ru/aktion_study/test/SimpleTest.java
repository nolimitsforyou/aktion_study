package ru.aktion_study.test;

import org.junit.jupiter.api.Test;
import ru.aktion_study.steps.DefaultSteps;


public class SimpleTest extends TestBase {

    private String url = "http://google.com";
//private String url = "http://yandex.ru";

    @Test
    public void test() {
        new DefaultSteps()
                .openPageInBrowser(url)
                .checkLogoGoogle();
                //.checkLogoYandex();
    }
}
