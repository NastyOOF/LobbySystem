package com.nasty.lobby.config;

import com.nasty.lobby.Main;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ShopConfigManager {
    public static File file = new File(Main.getInstance().getDataFolder().getPath(), "shop.yml");
    public static YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

    public void saveConfig() {
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        try {
            config.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
    public void setup() {
        load();

        config.options().copyDefaults(true);
        saveConfig();
    }
}
