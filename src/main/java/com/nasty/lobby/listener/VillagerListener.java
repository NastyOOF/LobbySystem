package com.nasty.lobby.listener;

import com.nasty.lobby.Main;
import com.nasty.lobby.addons.CoinsAPI;
import com.nasty.lobby.addons.LobbyScore;
import com.nasty.lobby.commands.BuildCMD;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.HashMap;

public class VillagerListener implements Listener {
    public static ArrayList<String> type1a = new ArrayList<>();
    ArrayList<String> lore = new ArrayList<>();
    final Inventory inv = Bukkit.createInventory(null, 27, "§e§lTägliche Belohnung");


    @EventHandler
    public void onInteractEntity(PlayerInteractEntityEvent e) {

        if (e.getRightClicked().getType() == EntityType.VILLAGER &&
                e.getRightClicked().getCustomName().equalsIgnoreCase("§e§lTägliche Belohnung")) {
            final Player p = e.getPlayer();
            ItemStack type1 = new ItemStack(Material.FIREBALL);
            ItemMeta type1meta = type1.getItemMeta();
            type1meta.setDisplayName("§7Login-Belohnung");
            if(!(Main.getInstance().rewardManager.getAllowReward(p))) {
                lore.clear();
                lore.add("");
                lore.add("§cHeute schon eingefordert");
                lore.add("");
                long current = System.currentTimeMillis();
                long release = (Main.getInstance()).rewardManager.getTime(p);
                long millis = release - current;
                lore.add("§7Du kannst diese Belohnung wieder in");
                lore.add("§c" + (Main.getInstance()).rewardManager.getRemainingTime(millis) + " §7einfordern!");
            } else {
                lore.clear();
                lore.add(" ");
                lore.add("§7+ §c500 §7Coins");
                lore.add("§7+ §c1 §7Lotterie Ticket");
                lore.add("  ");
                lore.add("§aKlicke, um die Belohnung zu erhalten!");
            }
            type1meta.setLore(lore);
            type1.setItemMeta(type1meta);
            inv.setItem(13, type1);

            ItemStack placeholder = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
            ItemMeta placeholder1 = placeholder.getItemMeta();
            placeholder1.setDisplayName(" ");
            placeholder.setItemMeta(placeholder1);


            inv.setItem(0, placeholder);
            inv.setItem(1, placeholder);
            inv.setItem(2, placeholder);
            inv.setItem(3, placeholder);
            inv.setItem(4, placeholder);
            inv.setItem(5, placeholder);
            inv.setItem(6, placeholder);
            inv.setItem(7, placeholder);
            inv.setItem(8, placeholder);
            inv.setItem(9, placeholder);
            inv.setItem(10, placeholder);
            inv.setItem(11, placeholder);
            inv.setItem(12, placeholder);
            inv.setItem(14, placeholder);
            inv.setItem(15, placeholder);
            inv.setItem(16, placeholder);
            inv.setItem(17, placeholder);
            inv.setItem(18, placeholder);
            inv.setItem(19, placeholder);
            inv.setItem(20, placeholder);
            inv.setItem(21, placeholder);
            inv.setItem(22, placeholder);
            inv.setItem(23, placeholder);
            inv.setItem(24, placeholder);
            inv.setItem(25, placeholder);
            inv.setItem(26, placeholder);


            Bukkit.getScheduler().runTaskLater((Plugin) Main.getInstance(), new Runnable() {
                public void run() {
                    p.openInventory(inv);

                }
            },  1L);
        }
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        Player p = (Player)e.getWhoClicked();

        if(e.getInventory().getName().equalsIgnoreCase("§e§lTägliche Belohnung")) {
            e.setCancelled(true);
            if(e.getCurrentItem() != null) {
                if(e.getCurrentItem().getType() == Material.FIREBALL) {
                    if (!(Main.getInstance()).rewardManager.getAllowReward(p)) {
                        p.updateInventory();
                        e.setCancelled(true);
                        p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 10, 10);
                        lore.clear();
                    } else {
                        CoinsAPI.addCoins(p.getUniqueId().toString(), 500);
                        p.sendMessage(Main.getInstance().prefix + "§7Du hast deine Täglichen Belohnungen abgeholt!");
                        p.sendMessage(Main.getInstance().prefix +"§7+ §c500 §7Coins");
                        p.sendMessage(Main.getInstance().prefix +"§7+ §c1 §7Lotterie Ticket");
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
                        (Main.getInstance()).rewardManager.setReward(p);
                        lore.clear();
                        LobbyScore.sendScoreboard(p);
                        p.closeInventory();
                    }
                }
            }

        }
    }
    @EventHandler
    public void villagerKill(EntityDamageByEntityEvent e) {
        if(!(e.getDamager() instanceof Player)) return;
        Player p = (Player)e.getDamager();
        if(p.hasPermission("lobby.setup")) {
            if(p.getItemInHand().getType() != Material.STICK) {
                return;
            } else {
                if (BuildCMD.build.contains(p)) {
                    if (p.getItemInHand().getType() == Material.STICK) {
                        Villager villager = (Villager) e.getEntity();
                        villager.setHealth(0);
                        p.sendMessage(Main.getInstance().prefix + "§7Der §cVillager §7wurde entfernt!");
                        p.getInventory().remove(Material.STICK);
                    }
                } else {
                    p.sendMessage(Main.getInstance().prefix + "§cDu musst im Baumodus sein!");
                }
            }
        }
    }
}
