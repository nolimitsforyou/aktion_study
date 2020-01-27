package ru.aktion_study.test;

import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.Inet4Address;
import java.net.UnknownHostException;


public class TestBase {

    public static WebDriver driver;
    private static BrowserMobProxyServer proxyServer;

    @BeforeAll
    public static void createDriver() {

        proxyServer = new BrowserMobProxyServer();
        proxyServer.start();

        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxyServer);
        try {
            String hostIp = Inet4Address.getLocalHost().getHostAddress();
            seleniumProxy.setHttpProxy(hostIp + ":" + proxyServer.getPort());
            seleniumProxy.setSslProxy(hostIp + ":" + proxyServer.getPort());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

   /*     seleniumProxy = ClientUtil.createSeleniumProxy(proxyServer);
        seleniumProxy.setHttpProxy("localhost: " + proxyServer.getPort());
        seleniumProxy.setSslProxy("localhost: " + proxyServer.getPort());
        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.PROXY, seleniumProxy);
        driver = new ChromeDriver(options);*/

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(CapabilityType.PROXY, seleniumProxy);
//        caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        ChromeOptions options = new ChromeOptions();
        options.merge(caps);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void down() {
        driver.close();
        proxyServer.stop();
    }
}
