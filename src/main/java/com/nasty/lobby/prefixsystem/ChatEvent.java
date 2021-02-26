package com.nasty.lobby.prefixsystem;

import com.nasty.lobby.config.ConfigHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String msg = e.getMessage();

        if(ConfigHandler.config.getBoolean("Chat.Enable")) {
            if (p.hasPermission(ConfigHandler.config.getString("Chat.Owner.Permission"))) {
                e.setFormat(ConfigHandler.config.getString("Chat.Owner.Prefix").replace("&", "§").replace("%player%", p.getName()).replace("%message%", msg));
            } else if (p.hasPermission(ConfigHandler.config.getString("Chat.Admin.Permission"))) {
                e.setFormat(ConfigHandler.config.getString("Chat.Admin.Prefix").replace("&", "§").replace("%player%", p.getName()).replace("%message%", msg));
            } else if (p.hasPermission(ConfigHandler.config.getString("Chat.Developer.Permission"))) {
                e.setFormat(ConfigHandler.config.getString("Chat.Developer.Prefix").replace("&", "§").replace("%player%", p.getName()).replace("%message%", msg));
            } else if (p.hasPermission(ConfigHandler.config.getString("Chat.Moderator.Permission"))) {
                e.setFormat(ConfigHandler.config.getString("Chat.Moderator.Prefix").replace("&", "§").replace("%player%", p.getName()).replace("%message%", msg));
            } else if (p.hasPermission(ConfigHandler.config.getString("Chat.Content.Permission"))) {
                e.setFormat(ConfigHandler.config.getString("Chat.Content.Prefix").replace("&", "§").replace("%player%", p.getName()).replace("%message%", msg));
            } else if (p.hasPermission(ConfigHandler.config.getString("Chat.Supporter.Permission"))) {
                e.setFormat(ConfigHandler.config.getString("Chat.Supporter.Prefix").replace("&", "§").replace("%player%", p.getName()).replace("%message%", msg));
            } else if (p.hasPermission(ConfigHandler.config.getString("Chat.Youtuber.Permission"))) {
                e.setFormat(ConfigHandler.config.getString("Chat.Youtuber.Prefix").replace("&", "§").replace("%player%", p.getName()).replace("%message%", msg));
            } else if (p.hasPermission(ConfigHandler.config.getString("Chat.PremiumPlus.Permission"))) {
                e.setFormat(ConfigHandler.config.getString("Chat.PremiumPlus.Prefix").replace("&", "§").replace("%player%", p.getName()).replace("%message%", msg));
            } else if (p.hasPermission(ConfigHandler.config.getString("Chat.Premium.Permission"))) {
                e.setFormat(ConfigHandler.config.getString("Chat.Premium.Prefix").replace("&", "§").replace("%player%", p.getName()).replace("%message%", msg));
            } else if (p.hasPermission(ConfigHandler.config.getString("Chat.Spieler.Permission"))) {
                e.setFormat(ConfigHandler.config.getString("Chat.Spieler.Prefix").replace("&", "§").replace("%player%", p.getName()).replace("%message%", msg));
            }
        }
    }
}
