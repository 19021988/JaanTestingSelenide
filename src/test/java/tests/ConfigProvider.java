package tests;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = getConfig();

    static Config getConfig() {
        return ConfigFactory.load("testConfig.conf");
    }
}