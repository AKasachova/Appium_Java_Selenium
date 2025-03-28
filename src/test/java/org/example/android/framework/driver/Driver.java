package org.example.android.framework.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

public class Driver {
    private static AndroidDriver driver;
    private static Properties config;

    static {
        config = new Properties();
        try (InputStream input = Driver.class.getClassLoader().getResourceAsStream("config.properties")) {
            config.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static AndroidDriver getDriver() {
        if (driver == null) {
            UiAutomator2Options options = new UiAutomator2Options()
                    .setUdid(config.getProperty("emulator.udid"))
                    .setApp(config.getProperty("app.path").replace("${user.dir}",
                            System.getProperty("user.dir")));
            try {
                driver = new AndroidDriver(
                        new URI(config.getProperty("appium.server.url")).toURL(), options
                );
            } catch (MalformedURLException | URISyntaxException e) {
                throw new RuntimeException("Failed to initialize AndroidDriver. Please check the Appium server URL in config.properties.", e);
            }
            return driver;
        }
        return driver;
    }

    public static void quitDriver(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}