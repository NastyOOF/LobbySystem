package com.nasty.lobby.commands;

import com.nasty.lobby.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LobbyBroadcastCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;
        if(p.hasPermission("lobby.broadcast")) {
            if(args.length >=1) {
                String msg = "";
                for(int i = 0; i< args.length; i++) {
                    msg = msg + args[i] + " ";
                }
                Bukkit.broadcastMessage(msg);
            }
        } else {
            p.sendMessage(Main.getInstance().noperm);
        }
        return false;
    }
}
