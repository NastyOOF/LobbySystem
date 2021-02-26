package com.nasty.lobby.commands;

import com.nasty.lobby.Main;
import com.nasty.lobby.addons.CoinsAPI;
import com.nasty.lobby.addons.LobbyScore;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CoinsCMD implements CommandExecutor {
    final CoinsAPI coinsAPI = new CoinsAPI();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 0) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(Main.getInstance().prefix + "Du musst ein Spieler sein, um diesen Command ausführen zu können!");
                return true;
            } else {
                Player p = (Player) sender;
                p.sendMessage(Main.getInstance().prefix + "§7Du hast aktuell §c" + CoinsAPI.getCoins(p.getUniqueId().toString()) + " §7Coins!");
            }
        }
        if(args.length == 1) {

            if (!(sender instanceof Player)) {
                Player p2 = Bukkit.getPlayer(args[0]);
                    try {
                        sender.sendMessage(Main.getInstance().prefix + "§7Der Spieler §c" + p2.getName() + " §7hat aktuell §c" + CoinsAPI.getCoins(p2.getUniqueId().toString()) + " §7Coins!");
                    } catch (NullPointerException e) {
                        sender.sendMessage(Main.getInstance().prefix + "§cDieser Spieler war noch nie auf dem Server!");
                    }
            } else {
                Player p = (Player) sender;
                Player p2 = Bukkit.getPlayer(args[0]);
                    try {
                        p.sendMessage(Main.getInstance().prefix + "§7Der Spieler §c" + p2.getName() + " §7hat aktuell §c" + CoinsAPI.getCoins(p2.getUniqueId().toString()) + " §7Coins!");

                    } catch (NullPointerException e) {
                        p.sendMessage(Main.getInstance().prefix + "§cDieser Spieler war noch nie auf dem Server!");

                    }
            }
        }
        if(args.length == 2) {
            if (args[0].contains("reset")) {
                if(!(sender instanceof Player)) {
                    Player p2 = Bukkit.getPlayer(args[1]);
                    sender.sendMessage(Main.getInstance().prefix  + "§7Die Coins von §c" + p2.getName() + " §7wurden zurückgesetzt!");
                    LobbyScore.sendScoreboard(p2);
                    CoinsAPI.resetCoins(p2.getUniqueId().toString());
                } else {
                    Player p = (Player) sender;
                    Player p2 = Bukkit.getPlayer(args[1]);
                    p.sendMessage(Main.getInstance().prefix  + "§7Die Coins von §c" + p2.getName() + " §7wurden zurückgesetzt!");
                    LobbyScore.sendScoreboard(p2);
                    CoinsAPI.resetCoins(p2.getUniqueId().toString());
                }
            }
        }
        if (args.length == 3) {
            try {
                int coins = Integer.parseInt(args[2]);
                Player p2 = Bukkit.getPlayer(args[1]);

                if (args[0].contains("add")) {
                    if(!(sender instanceof Player)) {
                        sender .sendMessage(Main.getInstance().prefix + "§7Dem Spieler §c" + p2.getName() + " §7wurden §c" + coins + " §7Coins hinzugefügt!");
                        CoinsAPI.addCoins(p2.getUniqueId().toString(), coins);
                        LobbyScore.sendScoreboard(p2);
                    } else {
                        Player p = (Player) sender;
                        p.sendMessage(Main.getInstance().prefix + "§7Dem Spieler §c" + p2.getName() + " §7wurden §c" + coins + " §7Coins hinzugefügt!");
                        CoinsAPI.addCoins(p2.getUniqueId().toString(), coins);
                        LobbyScore.sendScoreboard(p2);
                    }
                } else if (args[0].contains("remove")) {
                    if(!(sender instanceof Player)) {
                        sender.sendMessage(Main.getInstance().prefix + "§7Dem Spieler §c" + p2.getName() + " §7wurden §c" + coins + " §7Coins entfernt!!");
                        CoinsAPI.removeCoins(p2.getUniqueId().toString(), coins);
                        LobbyScore.sendScoreboard(p2);
                    } else {
                        Player p = (Player) sender;
                        p.sendMessage(Main.getInstance().prefix + "§7Dem Spieler §c" + p2.getName() + " §7wurden §c" + coins + " §7Coins entfernt!!");
                        CoinsAPI.removeCoins(p2.getUniqueId().toString(), coins);
                    }
                } else if (args[0].contains("set")) {
                    if(!(sender instanceof Player)) {
                        sender.sendMessage(Main.getInstance().prefix  + "§7Dem Spieler §c" + p2.getName() + " §7wurden die Coins auf §c" + coins + " §7Coins gesetzt!");
                        CoinsAPI.setCoins(p2.getUniqueId().toString(), coins);
                        LobbyScore.sendScoreboard(p2);
                    } else {
                        Player p = (Player) sender;
                        p.sendMessage(Main.getInstance().prefix  + "§7Dem Spieler §c" + p2.getName() + " §7wurden die Coins auf §c" + coins + " §7Coins gesetzt!");
                        CoinsAPI.setCoins(p2.getUniqueId().toString(), coins);
                        LobbyScore.sendScoreboard(p2);

                    }
                }
            } catch (NumberFormatException e) {
                if(!(sender instanceof Player)) {
                    sender.sendMessage(Main.getInstance().prefix  + "§7Du musst eine Zahl angeben!");
                } else {
                    Player p = (Player) sender;
                    p.sendMessage(Main.getInstance().prefix  + "§7Du musst eine Zahl angeben!");
                }
            } catch (NullPointerException e) {
                if(!(sender instanceof Player)) {
                    sender.sendMessage(Main.getInstance().prefix  + "§7Der Spieler ist derzeitig offline!");
                } else {
                    Player p = (Player) sender;
                    p.sendMessage(Main.getInstance().prefix  + "§7Der Spieler ist derzeitig offline!");
                }
            }
        }
        return false;
    }
}