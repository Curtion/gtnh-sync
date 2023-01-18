package com.curtion.gtnh;

import java.io.File;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class Config {

    private static class Defaults {
        public static final String uuid = "curtion";
    }

    private static class Categories {
        public static final String general = "general";
    }

    public static String uuid = Defaults.uuid;

    public static void syncronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);
        configuration.load();

        Property greetingProperty = configuration.get(Categories.general, "uuid", Defaults.uuid, "sync uuid");
        uuid = greetingProperty.getString();

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
