package com.nasty.lobby.prefixsystem;

import com.nasty.lobby.Main;
import com.nasty.lobby.config.ConfigHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class TabList {

    public static void setTeam() {

        Main.getInstance().sb.registerNewTeam("000Owner").setPrefix(ConfigHandler.config.getString("Tablist.Owner.Prefix").replace("&", "§") + " ");
        Main.getInstance().sb.registerNewTeam("001Admin").setPrefix(ConfigHandler.config.getString("Tablist.Admin.Prefix").replace("&", "§") + " ");
        Main.getInstance().sb.registerNewTeam("002Developer").setPrefix(ConfigHandler.config.getString("Tablist.Developer.Prefix").replace("&", "§") + " ");
        Main.getInstance().sb.registerNewTeam("003Moderator").setPrefix(ConfigHandler.config.getString("Tablist.Moderator.Prefix").replace("&", "§") + " ");
        Main.getInstance().sb.registerNewTeam("004Content").setPrefix(ConfigHandler.config.getString("Tablist.Content.Prefix").replace("&", "§") + " ");
        Main.getInstance().sb.registerNewTeam("005Supporter").setPrefix(ConfigHandler.config.getString("Tablist.Supporter.Prefix").replace("&", "§") + " ");
        Main.getInstance().sb.registerNewTeam("006Youtuber").setPrefix(ConfigHandler.config.getString("Tablist.Youtuber.Prefix").replace("&", "§") + " ");
        Main.getInstance().sb.registerNewTeam("007PremiumPlus").setPrefix(ConfigHandler.config.getString("Tablist.PremiumPlus.Prefix").replace("&", "§") + " ");
        Main.getInstance().sb.registerNewTeam("008Premium").setPrefix(ConfigHandler.config.getString("Tablist.Premium.Prefix").replace("&", "§") + " ");
        Main.getInstance().sb.registerNewTeam("009Spieler").setPrefix(ConfigHandler.config.getString("Tablist.Spieler.Prefix").replace("&", "§") + " ");
    }

    public static void setPrefix(Player p) {

        String team = "";

        if(p.hasPermission(ConfigHandler.config.getString("Tablist.Owner.Permission"))) {
            team = "000Owner";
        } else if(p.hasPermission(ConfigHandler.config.getString("Tablist.Admin.Permission"))) {
            team = "001Admin";
        } else if(p.hasPermission(ConfigHandler.config.getString("Tablist.Developer.Permission"))) {
            team = "002Developer";
        } else if(p.hasPermission(ConfigHandler.config.getString("Tablist.Moderator.Permission"))) {
            team = "003Moderator";
        } else if(p.hasPermission(ConfigHandler.config.getString("Tablist.Content.Permission"))) {
            team = "004Content";
        } else if(p.hasPermission(ConfigHandler.config.getString("Tablist.Supporter.Permission"))) {
            team = "005Supporter";
        } else if(p.hasPermission(ConfigHandler.config.getString("Tablist.Youtuber.Permission"))) {
            team = "006Youtuber";
        } else if(p.hasPermission(ConfigHandler.config.getString("Tablist.PremiumPlus.Permission"))) {
            team = "007PremiumPlus";
        } else if(p.hasPermission(ConfigHandler.config.getString("Tablist.Premium.Permission"))) {
            team = "008Premium";
        } else if(p.hasPermission(ConfigHandler.config.getString("Tablist.Spieler.Permission"))) {
            team = "009Spieler";
        }
        Main.getInstance().sb.getTeam(team).addPlayer(p);
        p.setDisplayName(Main.getInstance().sb.getTeam(team).getPrefix() + p.getName());

        for(Player all : Bukkit.getOnlinePlayers()) {
            all.setScoreboard(Main.getInstance().sb);
        }
    }


}
