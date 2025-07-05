package utils.propertyManager;

import io.github.cdimascio.dotenv.Dotenv;
import io.qameta.allure.internal.shadowed.jackson.core.json.UTF8DataInputJsonParser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SetUpProperty {
    public static Object getProps (String key) {
        Properties props = new Properties();
        try (InputStream input = new FileInputStream("src/test/java/resources.properties")) {
            props.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return props.getProperty(key);
    }

    public static String getEnvs (String env) {
        Dotenv dotenv = Dotenv.load();
        return dotenv.get(env);
    }
}
