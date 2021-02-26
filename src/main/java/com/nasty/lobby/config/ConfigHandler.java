package com.nasty.lobby.config;

import com.nasty.lobby.Main;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigHandler {
    public static File file = new File(Main.getInstance().getDataFolder().getPath(), "config.yml");
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
        config.options().header("Thanks for Buying this LobbySystem on https://www.your-plugin.eu");
        config.addDefault("LICENSE.key", "yourkey");

        config.addDefault("MySQL.host", "localhost");
        config.addDefault("MySQL.port", 3306);
        config.addDefault("MySQL.username", "username");
        config.addDefault("MySQL.password", "password");
        config.addDefault("MySQL.database", "coinsystem");

        config.addDefault("Join.Sound", true);
        config.addDefault("Join.Particle", true);
        config.addDefault("Join.Message.Message", "&a%player% hat den Server betreten");
        config.addDefault("Join.Message.Enable", true);

        config.addDefault("Leave.Message.Message", "&c%player% hat den Server verlassen");
        config.addDefault("Leave.Message.Enable", true);

        config.addDefault("JoinTitle.Enable", true);
        config.addDefault("JoinTitle.FirstLine", "&cWillkommen auf Your-Plugin.eu");
        config.addDefault("JoinTitle.ThirdLine", "&cDeine #1 Wahl für Minecraft Plugins");

        config.addDefault("Chat.Enable", true);

        config.addDefault("Chat.Owner.Permission", "lobby.owner");
        config.addDefault("Chat.Owner.Prefix", "&4Owner &7| %player% &7» &f%message%");

        config.addDefault("Chat.Admin.Permission", "lobby.admin");
        config.addDefault("Chat.Admin.Prefix", "&cAdministrator &7| %player% &7» &f%message%");

        config.addDefault("Chat.Developer.Permission", "lobby.dev");
        config.addDefault("Chat.Developer.Prefix", "&bDeveloper &7| %player% &7» &f%message%");

        config.addDefault("Chat.Moderator.Permission", "lobby.mod");
        config.addDefault("Chat.Moderator.Prefix", "&9Moderator &7| %player% &7» &f%message%");

        config.addDefault("Chat.Content.Permission", "lobby.content");
        config.addDefault("Chat.Content.Prefix", "&cContent &7| %player% &7» &f%message%");

        config.addDefault("Chat.Supporter.Permission", "lobby.supporter");
        config.addDefault("Chat.Supporter.Prefix", "&2Supporter &7| %player% &7» &f%message%");

        config.addDefault("Chat.Youtuber.Permission", "lobby.youtuber");
        config.addDefault("Chat.Youtuber.Prefix", "&5Youtuber &7| %player% &7» &f%message%");

        config.addDefault("Chat.PremiumPlus.Permission", "lobby.premiumplus");
        config.addDefault("Chat.PremiumPlus.Prefix", "&ePremium+ &7| %player% &7» &f%message%");

        config.addDefault("Chat.Premium.Permission", "lobby.premium");
        config.addDefault("Chat.Premium.Prefix", "&6Premium &7| %player% &7» &f%message%");

        config.addDefault("Chat.Spieler.Permission", "lobby.spieler");
        config.addDefault("Chat.Spieler.Prefix", "&7Spieler &7| %player% &7» &f%message%");


        config.addDefault("Tablist.Enable", true);

        config.addDefault("Tablist.Owner.Permission", "lobby.owner");
        config.addDefault("Tablist.Owner.Prefix", "&4Owner &7|");

        config.addDefault("Tablist.Admin.Permission", "lobby.admin");
        config.addDefault("Tablist.Admin.Prefix", "&cAdmin &7|");

        config.addDefault("Tablist.Developer.Permission", "lobby.dev");
        config.addDefault("Tablist.Developer.Prefix", "&bDev &7|");

        config.addDefault("Tablist.Moderator.Permission", "lobby.mod");
        config.addDefault("Tablist.Moderator.Prefix", "&9Mod &7|");

        config.addDefault("Tablist.Content.Permission", "lobby.content");
        config.addDefault("Tablist.Content.Prefix", "&cContent &7|");

        config.addDefault("Tablist.Supporter.Permission", "lobby.supporter");
        config.addDefault("Tablist.Supporter.Prefix", "&2Sup &7|");

        config.addDefault("Tablist.Youtuber.Permission", "lobby.youtuber");
        config.addDefault("Tablist.Youtuber.Prefix", "&5YT &7|");

        config.addDefault("Tablist.PremiumPlus.Permission", "lobby.premiumplus");
        config.addDefault("Tablist.PremiumPlus.Prefix", "&ePremium+ &7|");

        config.addDefault("Tablist.Premium.Permission", "lobby.premium");
        config.addDefault("Tablist.Premium.Prefix", "&6Premium &7|");

        config.addDefault("Tablist.Spieler.Permission", "lobby.spieler");
        config.addDefault("Tablist.Spieler.Prefix", "&7Spieler &7|");

        config.addDefault("Messages.NoPlayer", "&7Du musst ein Spieler sein!");
        config.addDefault("Messages.NoPermission", "&cDazu hast du keine Rechte!");

        config.addDefault("Prefix.Prefix", "&7[&cLobby&7]");

        config.options().copyDefaults(true);
        saveConfig();
    }
}
