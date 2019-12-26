package ru.aktion_study.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import net.lightbody.bmp.core.har.Har;
import org.junit.jupiter.api.Test;
import ru.aktion_study.test.proxy.Bmp;

import java.io.File;
import java.io.IOException;

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
    public void openPageInBrowser(String url) throws IOException {
        open(url);
        Har har = null;
        Bmp.proxyServer.newHar("example.com");
        // Get the current HTTP requests and responses from when the proxy
        // server started up to now.
        har = Bmp.proxyServer.getHar();
        // Write the results of the HAR to a local file.
        har.writeTo(new File("example.har"));
        // Stop capturing the network traffic.
        Bmp.proxyServer.stop();
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
