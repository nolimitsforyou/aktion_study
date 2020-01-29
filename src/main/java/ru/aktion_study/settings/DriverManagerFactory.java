package ru.aktion_study.settings;

public class DriverManagerFactory {

    public static DriverManager getManager(DriverType type) {

        DriverManager driverManager;

        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            /*case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;*/
            default:
                driverManager = new ChromeDriverManager();
                break;
        }
        return driverManager;
    }
}
