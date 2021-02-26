package com.nasty.lobby.listener;

import com.nasty.lobby.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.help.HelpTopic;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(PlayerChatEvent e) {
        Player p = e.getPlayer();
        String message = e.getMessage();
        if (p.hasPermission("lobby.color")) {
            message = message.replaceAll("&", "§");
                    e.setMessage(message);
        }
    }
    @EventHandler
    public void Command(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        String cmd = e.getMessage().split(" ")[0];
        HelpTopic helptopic = Bukkit.getHelpMap().getHelpTopic(cmd);
        if (helptopic == null) {
            p.sendMessage(String.valueOf(Main.getInstance().prefix) + "§cDer Befehl §7" + cmd + " §cexistiert nicht!");
            e.setCancelled(true);
        } else {
            e.setCancelled(false);
        }
    }
}
