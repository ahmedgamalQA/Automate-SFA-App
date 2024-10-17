package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.json.simple.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static settings.SafSettings.getDesiredCapabilityPath;
import static settings.SafSettings.getServerUrl;
import static utils.Helper.readJsonFile;

public final class DriverFactory {
    private static AppiumDriver driver;

    public static AppiumDriver getAppiumDriver() {
        if (driver == null) {
            driver = new AppiumDriver(getAppiumServerUrl(), getCapabilities());
            return driver;
        }
        return driver;
    }


    private static URL getAppiumServerUrl() {
        final String urlServer = getServerUrl();
        final URL appiumServerUrl;
        try {
            appiumServerUrl = new URL(urlServer);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return appiumServerUrl;
    }

    private static DesiredCapabilities getCapabilities() {
        final JSONObject capabilities = readJsonFile(getDesiredCapabilityPath());
        return new DesiredCapabilities(capabilities);
    }
}
