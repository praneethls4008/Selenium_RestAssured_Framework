package localhost.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;

public final class Config {
    private static final Properties PROPERTIES = new Properties();

    static {
        String env = System.getProperty("env");
        if (env == null || env.isBlank()) {
            env = System.getenv("TEST_ENV");
        }

        if (env == null || env.isBlank()) {
            env = "qa";
        }

        env = env.toLowerCase();
        String file = "env/" + env + ".properties";

        try (InputStream input = Config.class.getClassLoader().getResourceAsStream(file)) {
            if (input == null) throw new IllegalStateException("Missing configuration: " + file);
            PROPERTIES.load(input);
        } catch (IOException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    private Config() {}

    public static String baseUrl() {
        return System.getProperty("baseUrl", System.getenv().getOrDefault("BASE_URL",
                PROPERTIES.getProperty("base.url")));
    }
    public static int intValue(String key) { return Integer.parseInt(PROPERTIES.getProperty(key)); }



}
