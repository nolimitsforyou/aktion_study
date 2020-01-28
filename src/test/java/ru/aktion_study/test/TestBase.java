package ru.aktion_study.test;

import net.lightbody.bmp.BrowserMobProxy;
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
import java.net.InetAddress;
import java.net.UnknownHostException;


public class TestBase {

    public static WebDriver driver;
    public static BrowserMobProxyServer proxyServer;
    public static Proxy seleniumProxy;

    @BeforeAll
    public static void createDriver() {

        proxyServer = new BrowserMobProxyServer();
        proxyServer.setTrustAllServers(true);
        proxyServer.start();
        int port = proxyServer.getPort();
        System.out.println("BrowserMob Proxy running on port: " + port);

        seleniumProxy = ClientUtil.createSeleniumProxy(proxyServer);
        try {
            String hostIp = Inet4Address.getLocalHost().getHostAddress();
            seleniumProxy.setHttpProxy(hostIp + ":" + port);
            seleniumProxy.setSslProxy(hostIp + ":" + port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(CapabilityType.PROXY, seleniumProxy);
        ChromeOptions options = new ChromeOptions();
        options.merge(caps);
        options.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void down() {
        driver.close();
        proxyServer.stop();
    }
}
