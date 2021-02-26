package com.nasty.lobby.addons;

import com.nasty.lobby.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CompassUtil {
    public static File file;
    public static YamlConfiguration cfg;

    public CompassUtil(Main main) {
        file = new File(main.getDataFolder(), "locations.yml");
        if(!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            cfg = YamlConfiguration.loadConfiguration(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void save(String name, Material material, int slot, Location location) {
        String toSave = name + ":" + material.toString() + ":" + slot + ":" + location.getWorld().getName() + ":" + location.getX() + ":"
                + location.getY() + ":" + location.getZ() + ":" + location.getYaw() + ":" + location.getPitch();
        List<String> list = new ArrayList<>();
        try {
            list = cfg.getStringList("navigator");
        } catch (Exception e) {
            list = new ArrayList<>();
        }
        list.add(toSave);
        cfg.set("navigator", list);
        try {
            cfg.save(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveTemp(String name, Material material, int slot) {
        String toSave = name + ":" + material.toString() + ":" + slot + ":" + "WELTNAME" + ":" + "X KOORDINATE" + ":"
                + "Y KOORDINATE" + ":" + "Z KOORDINATE" + ":" + "YAW" + ":" + "PITCH";
        List<String> list = new ArrayList<>();
        try {
            list = cfg.getStringList("navigator");
        } catch (Exception e) {
            list = new ArrayList<>();
        }
        list.add(toSave);
        cfg.set("navigator", list);
        try {
            cfg.save(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
