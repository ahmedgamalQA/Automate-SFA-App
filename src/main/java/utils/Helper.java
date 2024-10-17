package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
public final class Helper {

    public static JSONObject readJsonFile(String filePath) {
        JSONObject obj = null;
        try {
            FileReader reader = new FileReader(filePath);
            JSONParser parser = new JSONParser();
            obj = (JSONObject) parser.parse(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static Properties readPropertiesFile(String filePath) {
        Properties properties = new Properties();
        try (InputStream input = Files.newInputStream(Paths.get(filePath))) {
            // Load properties file
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return properties;
    }
}
