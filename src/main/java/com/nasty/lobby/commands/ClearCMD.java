package com.nasty.lobby.commands;

import com.nasty.lobby.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;
        if(p.hasPermission("lobby.clear")) {
            for(int i = 0; i < 100; i++)
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(Main.getInstance().prefix + "§7Der Chat wurde von §c" + p.getDisplayName() + " §7geleert!");
        } else {
            p.sendMessage(Main.getInstance().noperm);
        }
        return false;
    }
}
