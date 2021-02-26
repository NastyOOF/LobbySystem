package com.nasty.lobby.commands;

import com.nasty.lobby.Main;
import com.nasty.lobby.addons.Actionbar;
import com.nasty.lobby.listener.JoinEvent;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class BuildCMD implements CommandExecutor {
    public static ArrayList<Player> build = new ArrayList<>();
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if(p.hasPermission("lobby.build")) {
            if(args.length == 0) {
                if(build.contains(p)) {
                    build.remove(p);
                    p.setGameMode(GameMode.SURVIVAL);
                  //  p.sendMessage(Main.getInstance().prefix + "§cDu hast den Build Modus deaktiviert!");
                    Actionbar.sendActionBar(p, "§cBuild Modus deaktiviert!");
                    JoinEvent.giveItems(p);
                } else {
                    build.add(p);
                    p.setGameMode(GameMode.CREATIVE);
                   // p.sendMessage(Main.getInstance().prefix + "§aDu hast den Build Modus aktiviert!");
                    Actionbar.sendActionBar(p, "§aBuild Modus aktiviert!");
                    p.getInventory().clear();
                }
            }
        } else {
            p.sendMessage(Main.getInstance().noperm);
        }
        return false;
    }
}
