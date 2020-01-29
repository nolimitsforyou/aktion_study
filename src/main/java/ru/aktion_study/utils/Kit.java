package ru.aktion_study.utils;

import org.openqa.selenium.WebDriver;
import ru.aktion_study.settings.DriverConfigurator;

public abstract class Kit {

    public static void open(String url) {
        WebDriver driver = new DriverConfigurator().getChromeDriver();
        driver.get(url);
    }
}
