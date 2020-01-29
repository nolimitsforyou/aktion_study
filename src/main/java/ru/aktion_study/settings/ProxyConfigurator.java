package ru.aktion_study.settings;


import org.openqa.selenium.Proxy;
import net.lightbody.bmp.client.ClientUtil;
import java.net.Inet4Address;
import java.net.UnknownHostException;

public class ProxyConfigurator {

    private static void createSeleniumProxy() {

        Proxy seleniumProxy = ClientUtil.createSeleniumProxy();
        try {
            String hostIp = Inet4Address.getLocalHost().getHostAddress();
            seleniumProxy.setHttpProxy(hostIp + ":" + port);
            seleniumProxy.setSslProxy(hostIp + ":" + port);
        } catch (UnknownHostException e) { e.printStackTrace(); }
    }
}
