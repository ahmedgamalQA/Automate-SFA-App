package data_driven;

import org.json.simple.JSONObject;

import static settings.SafSettings.getTestDataPath;
import static utils.Helper.readJsonFile;

public final class SafTestData {
    private static final JSONObject testData = readJsonFile(getTestDataPath());

    public static String getEmail() {
        return String.valueOf(testData.get("email"));
    }

    public static String getPassword() {
        return String.valueOf(testData.get("password"));
    }
    public static String getMobileNumber(){
        return String.valueOf(testData.get("mobileNumber"));
    }
}
