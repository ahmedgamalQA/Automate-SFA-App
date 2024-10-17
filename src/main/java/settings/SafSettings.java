package settings;

import java.util.Properties;

import static utils.Helper.readPropertiesFile;

public final class SafSettings {
    private static final String settingsFilePath = "src/main/resources/settings.properties";
    private static final Properties properties = readPropertiesFile(settingsFilePath);

    public static String getServerUrl(){
        return properties.getProperty("APPIUM_SERVER");
    }

    public static String getDesiredCapabilityPath(){
        return properties.getProperty("DESIRED_CAPABILITIES_PATH");
    }
    public static String getTestDataPath(){
        return properties.getProperty("TEST_DATA_PATH");
    }
}
