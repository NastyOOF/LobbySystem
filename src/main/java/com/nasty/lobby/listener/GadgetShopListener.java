package com.nasty.lobby.listener;

import com.nasty.lobby.Main;
import com.nasty.lobby.addons.CoinsAPI;
import com.nasty.lobby.addons.Helper;
import com.nasty.lobby.addons.ItemBuilder;
import com.nasty.lobby.addons.LobbyScore;
import com.nasty.lobby.commands.BuildCMD;
import com.nasty.lobby.config.ShopConfigManager;
import com.nasty.lobby.gadgets.HutInventory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class GadgetShopListener implements Listener {
    public static ArrayList<String> type1a = new ArrayList<>();
    ArrayList<String> lore = new ArrayList<>();
    final Inventory inv = Bukkit.createInventory(null, 27, "§c§lGadget-Shop");
    final Inventory hut_shop_1 = Bukkit.createInventory(null, 27, "§7Alle Hüte - Seite 1/2");
    final Inventory hut_shop_2 = Bukkit.createInventory(null, 27, "§7Alle Hüte - Seite 2/2");


    @EventHandler
    public void onInteractEntity(PlayerInteractEntityEvent e) {

        if (e.getRightClicked().getType() == EntityType.WITCH &&
                e.getRightClicked().getCustomName().equalsIgnoreCase("§c§lGadget-Shop")) {
            final Player p = e.getPlayer();

            ItemStack hut = new ItemBuilder(Material.IRON_HELMET).setName("§7Hüte").toItemStack();
            ItemStack boots = new ItemBuilder(Material.GOLD_BOOTS).setName("§7Boots").toItemStack();
            ItemStack pets = new ItemBuilder(Material.EGG).setName("§7Pets").toItemStack();
            ItemStack gadgets = new ItemBuilder(Material.ENDER_PEARL).setName("§7Gadgets").toItemStack();
            inv.setItem(10, hut);
            inv.setItem(12, boots);
            inv.setItem(14, pets);
            inv.setItem(16, gadgets);

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
            inv.setItem(11, placeholder);
            inv.setItem(13, placeholder);
            inv.setItem(15, placeholder);
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
    public void onInvClick(InventoryClickEvent e) throws IOException {
        Player p = (Player)e.getWhoClicked();

        if(e.getInventory().getName().equalsIgnoreCase("§c§lGadget-Shop")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null) {
                if (e.getCurrentItem().getType() == Material.IRON_HELMET) {
                  openHutInv1(p);
                }

            }
        } else if(e.getInventory().getName().equalsIgnoreCase("§7Alle Hüte - Seite 1/2")) {
            if (e.getCurrentItem() != null) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a<< §7Vorherige Seite")) {
                    p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
                    p.openInventory(inv);
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Nächste Seite §a>>")) {
                    p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
                    openHutInv2(p);
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Kopf von GommeHD")) {
                    if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.GommeHD").equals(true)) {
                        p.sendMessage(Main.getInstance().prefix + "§cDu besitzt diesen Kopf bereits!");
                        return;
                    } else {
                        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 2499) {
                            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Huete.GommeHD", true);
                            Helper.saveShop();
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast erfolgreich den Kopf von §c" + "GommeHD" + " §7gekauft!");
                            CoinsAPI.removeCoins(p.getUniqueId().toString(), 2500);
                            LobbyScore.sendScoreboard(p);
                            p.closeInventory();
                        } else {
                            p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast zu wenig §cCoins§7!");
                        }
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Kopf von BastiGHG")) {
                    if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.BastiGHG").equals(true)) {
                        p.sendMessage(Main.getInstance().prefix + "§cDu besitzt diesen Kopf bereits!");
                        return;
                    } else {
                        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 2499) {
                            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Huete.BastiGHG", true);
                            Helper.saveShop();
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast erfolgreich den Kopf von §c" + "BastiGHG" + " §7gekauft!");
                            CoinsAPI.removeCoins(p.getUniqueId().toString(), 2500);
                            LobbyScore.sendScoreboard(p);
                            p.closeInventory();
                        } else {
                            p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast zu wenig §cCoins§7!");
                        }
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Kopf von Rewinside")) {
                    if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.Rewinside").equals(true)) {
                        p.sendMessage(Main.getInstance().prefix + "§cDu besitzt diesen Kopf bereits!");
                        return;
                    } else {
                        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 2499) {
                            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Huete.Rewinside", true);
                            Helper.saveShop();
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast erfolgreich den Kopf von §c" + "Rewinside" + " §7gekauft!");
                            CoinsAPI.removeCoins(p.getUniqueId().toString(), 2500);
                            LobbyScore.sendScoreboard(p);
                            p.closeInventory();
                        } else {
                            p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast zu wenig §cCoins§7!");
                        }
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Kopf von LetsHugo")) {
                    if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.LetsHugo").equals(true)) {
                        p.sendMessage(Main.getInstance().prefix + "§cDu besitzt diesen Kopf bereits!");
                        return;
                    } else {
                        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 2499) {
                            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Huete.LetsHugo", true);
                            Helper.saveShop();
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast erfolgreich den Kopf von §c" + "LetsHugo" + " §7gekauft!");
                            CoinsAPI.removeCoins(p.getUniqueId().toString(), 2500);
                            LobbyScore.sendScoreboard(p);
                            p.closeInventory();
                        } else {
                            p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast zu wenig §cCoins§7!");
                        }
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Kopf von NastyIsHere")) {
                    if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.NastyIsHere").equals(true)) {
                        p.sendMessage(Main.getInstance().prefix + "§cDu besitzt diesen Kopf bereits!");
                        return;
                    } else {
                        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 999) {
                            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Huete.NastyIsHere", true);
                            Helper.saveShop();
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast erfolgreich den Kopf von §c" + "NastyIsHere" + " §7gekauft!");
                            CoinsAPI.removeCoins(p.getUniqueId().toString(), 1000);
                            LobbyScore.sendScoreboard(p);
                            p.closeInventory();
                        } else {
                            p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast zu wenig §cCoins§7!");
                        }
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Kopf von CloudLess")) {
                    if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.CloudLess").equals(true)) {
                        p.sendMessage(Main.getInstance().prefix + "§cDu besitzt diesen Kopf bereits!");
                        return;
                    } else {
                        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 999) {
                            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Huete.CloudLess", true);
                            Helper.saveShop();
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast erfolgreich den Kopf von §c" + "CloudLess" + " §7gekauft!");
                            CoinsAPI.removeCoins(p.getUniqueId().toString(), 1000);
                            LobbyScore.sendScoreboard(p);
                            p.closeInventory();
                        } else {
                            p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast zu wenig §cCoins§7!");
                        }
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Kopf von JK1Gaming")) {
                    if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.JK1Gaming").equals(true)) {
                        p.sendMessage(Main.getInstance().prefix + "§cDu besitzt diesen Kopf bereits!");
                        return;
                    } else {
                        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 999) {
                            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Huete.JK1Gaming", true);
                            Helper.saveShop();
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast erfolgreich den Kopf von §c" + "JK1Gaming" + " §7gekauft!");
                            CoinsAPI.removeCoins(p.getUniqueId().toString(), 1000);
                            LobbyScore.sendScoreboard(p);
                            p.closeInventory();
                        } else {
                            p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast zu wenig §cCoins§7!");
                        }
                    }
                }
            }
        } else if(e.getInventory().getName().equalsIgnoreCase("§7Alle Hüte - Seite 2/2")) {
            if (e.getCurrentItem() != null) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a<< §7Vorherige Seite")) {
                    p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
                    openHutInv1(p);
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Kopf von GommeHD")) {
                    if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.GommeHD").equals(true)) {
                        p.sendMessage(Main.getInstance().prefix + "§cDu besitzt diesen Kopf bereits!");
                        return;
                    } else {
                        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 2499) {
                            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Huete.GommeHD", true);
                            Helper.saveShop();
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast erfolgreich den Kopf von §c" + "GommeHD" + " §7gekauft!");
                            CoinsAPI.removeCoins(p.getUniqueId().toString(), 2500);
                            LobbyScore.sendScoreboard(p);
                            p.closeInventory();
                        } else {
                            p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast zu wenig §cCoins§7!");
                        }
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Kopf von BastiGHG")) {
                    if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.BastiGHG").equals(true)) {
                        p.sendMessage(Main.getInstance().prefix + "§cDu besitzt diesen Kopf bereits!");
                        return;
                    } else {
                        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 2499) {
                            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Huete.BastiGHG", true);
                            Helper.saveShop();
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast erfolgreich den Kopf von §c" + "BastiGHG" + " §7gekauft!");
                            CoinsAPI.removeCoins(p.getUniqueId().toString(), 2500);
                            LobbyScore.sendScoreboard(p);
                            p.closeInventory();
                        } else {
                            p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast zu wenig §cCoins§7!");
                        }
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Kopf von Rewinside")) {
                    if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.Rewinside").equals(true)) {
                        p.sendMessage(Main.getInstance().prefix + "§cDu besitzt diesen Kopf bereits!");
                        return;
                    } else {
                        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 2499) {
                            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Huete.Rewinside", true);
                            Helper.saveShop();
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast erfolgreich den Kopf von §c" + "Rewinside" + " §7gekauft!");
                            CoinsAPI.removeCoins(p.getUniqueId().toString(), 2500);
                            LobbyScore.sendScoreboard(p);
                            p.closeInventory();
                        } else {
                            p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast zu wenig §cCoins§7!");
                        }
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Kopf von LetsHugo")) {
                    if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.LetsHugo").equals(true)) {
                        p.sendMessage(Main.getInstance().prefix + "§cDu besitzt diesen Kopf bereits!");
                        return;
                    } else {
                        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 2499) {
                            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Huete.LetsHugo", true);
                            Helper.saveShop();
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast erfolgreich den Kopf von §c" + "LetsHugo" + " §7gekauft!");
                            CoinsAPI.removeCoins(p.getUniqueId().toString(), 2500);
                            LobbyScore.sendScoreboard(p);
                            p.closeInventory();
                        } else {
                            p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast zu wenig §cCoins§7!");
                        }
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Kopf von NastyIsHere")) {
                    if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.NastyIsHere").equals(true)) {
                        p.sendMessage(Main.getInstance().prefix + "§cDu besitzt diesen Kopf bereits!");
                        return;
                    } else {
                        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 999) {
                            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Huete.NastyIsHere", true);
                            Helper.saveShop();
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast erfolgreich den Kopf von §c" + "NastyIsHere" + " §7gekauft!");
                            CoinsAPI.removeCoins(p.getUniqueId().toString(), 1000);
                            LobbyScore.sendScoreboard(p);
                            p.closeInventory();
                        } else {
                            p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast zu wenig §cCoins§7!");
                        }
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Kopf von CloudLess")) {
                    if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.CloudLess").equals(true)) {
                        p.sendMessage(Main.getInstance().prefix + "§cDu besitzt diesen Kopf bereits!");
                        return;
                    } else {
                        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 999) {
                            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Huete.CloudLess", true);
                            Helper.saveShop();
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast erfolgreich den Kopf von §c" + "CloudLess" + " §7gekauft!");
                            CoinsAPI.removeCoins(p.getUniqueId().toString(), 1000);
                            LobbyScore.sendScoreboard(p);
                            p.closeInventory();
                        } else {
                            p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast zu wenig §cCoins§7!");
                        }
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Kopf von JK1Gaming")) {
                    if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.JK1Gaming").equals(true)) {
                        p.sendMessage(Main.getInstance().prefix + "§cDu besitzt diesen Kopf bereits!");
                        return;
                    } else {
                        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 999) {
                            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Huete.JK1Gaming", true);
                            Helper.saveShop();
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast erfolgreich den Kopf von §c" + "JK1Gaming" + " §7gekauft!");
                            CoinsAPI.removeCoins(p.getUniqueId().toString(), 1000);
                            LobbyScore.sendScoreboard(p);
                            p.closeInventory();
                        } else {
                            p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast zu wenig §cCoins§7!");
                        }
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Kopf von Paluten")) {
                    if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.Paluten").equals(true)) {
                        p.sendMessage(Main.getInstance().prefix + "§cDu besitzt diesen Kopf bereits!");
                        return;
                    } else {
                        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 2499) {
                            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Huete.Paluten", true);
                            Helper.saveShop();
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast erfolgreich den Kopf von §c" + "Paluten" + " §7gekauft!");
                            CoinsAPI.removeCoins(p.getUniqueId().toString(), 2500);
                            LobbyScore.sendScoreboard(p);
                            p.closeInventory();
                        } else {
                            p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast zu wenig §cCoins§7!");
                        }
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Kopf von Abgegrieft")) {
                    if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.Abgegrieft").equals(true)) {
                        p.sendMessage(Main.getInstance().prefix + "§cDu besitzt diesen Kopf bereits!");
                        return;
                    } else {
                        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 2499) {
                            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Huete.Abgegrieft", true);
                            Helper.saveShop();
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast erfolgreich den Kopf von §c" + "Abgegrieft" + " §7gekauft!");
                            CoinsAPI.removeCoins(p.getUniqueId().toString(), 2500);
                            LobbyScore.sendScoreboard(p);
                            p.closeInventory();
                        } else {
                            p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast zu wenig §cCoins§7!");
                        }
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Kopf von TheJoCraft")) {
                    if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.TheJoCraft").equals(true)) {
                        p.sendMessage(Main.getInstance().prefix + "§cDu besitzt diesen Kopf bereits!");
                        return;
                    } else {
                        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 2499) {
                            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Huete.TheJoCraft", true);
                            Helper.saveShop();
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast erfolgreich den Kopf von §c" + "TheJoCraft" + " §7gekauft!");
                            CoinsAPI.removeCoins(p.getUniqueId().toString(), 2500);
                            LobbyScore.sendScoreboard(p);
                            p.closeInventory();
                        } else {
                            p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast zu wenig §cCoins§7!");
                        }
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Stein")) {
                    if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.Stein").equals(true)) {
                        p.sendMessage(Main.getInstance().prefix + "§cDu besitzt diesen Kopf bereits!");
                        return;
                    } else {
                        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 2999) {
                            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Huete.Stein", true);
                            Helper.saveShop();
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast erfolgreich den Kopf §c" + "Stein" + " §7gekauft!");
                            CoinsAPI.removeCoins(p.getUniqueId().toString(), 3000);
                            LobbyScore.sendScoreboard(p);
                            p.closeInventory();
                        } else {
                            p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast zu wenig §cCoins§7!");
                        }
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Grass")) {
                    if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.Grass").equals(true)) {
                        p.sendMessage(Main.getInstance().prefix + "§cDu besitzt diesen Kopf bereits!");
                        return;
                    } else {
                        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 2999) {
                            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Huete.Grass", true);
                            Helper.saveShop();
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast erfolgreich den Kopf §c" + "Grass" + " §7gekauft!");
                            CoinsAPI.removeCoins(p.getUniqueId().toString(), 3000);
                            LobbyScore.sendScoreboard(p);
                            p.closeInventory();
                        } else {
                            p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast zu wenig §cCoins§7!");
                        }
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Glas")) {
                    if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.Glas").equals(true)) {
                        p.sendMessage(Main.getInstance().prefix + "§cDu besitzt diesen Kopf bereits!");
                        return;
                    } else {
                        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 2999) {
                            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Huete.Glas", true);
                            Helper.saveShop();
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast erfolgreich den Kopf §c" + "Glas" + " §7gekauft!");
                            CoinsAPI.removeCoins(p.getUniqueId().toString(), 3000);
                            LobbyScore.sendScoreboard(p);
                            p.closeInventory();
                        } else {
                            p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast zu wenig §cCoins§7!");
                        }
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Diamantblock")) {
                    if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.Diamantblock").equals(true)) {
                        p.sendMessage(Main.getInstance().prefix + "§cDu besitzt diesen Kopf bereits!");
                        return;
                    } else {
                        if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 2999) {
                            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Huete.Diamantblock", true);
                            Helper.saveShop();
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast erfolgreich den Kopf §c" + "Diamantblock" + " §7gekauft!");
                            CoinsAPI.removeCoins(p.getUniqueId().toString(), 3000);
                            LobbyScore.sendScoreboard(p);
                            p.closeInventory();
                        } else {
                            p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast zu wenig §cCoins§7!");
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void sheepKill(EntityDamageByEntityEvent e) {
        if(!(e.getDamager() instanceof Player)) return;
        Player p = (Player)e.getDamager();
        if(p.hasPermission("lobby.setup")) {
            if(p.getItemInHand().getType() != Material.STICK) {
                return;
            } else {
                if (BuildCMD.build.contains(p)) {
                    if (p.getItemInHand().getType() == Material.STICK) {
                        Witch sheep = (Witch) e.getEntity();
                        sheep.setHealth(0);
                        p.sendMessage(Main.getInstance().prefix + "§7Der §cGadget-Shop §7wurde entfernt!");
                        p.getInventory().remove(Material.STICK);
                    }
                } else {
                    p.sendMessage(Main.getInstance().prefix + "§cDu musst im Baumodus sein!");
                }
            }
        }
    }

    public void openHutInv1(Player p) {
        p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
        ItemStack placeholder = Helper.setPlaceHolder();
        ItemStack left = Helper.setLeft();
        ItemStack right = Helper.setRight();

        ItemStack gomme_besitz = Helper.setHeadShop("Kopf von GommeHD", "GommeHD", "2.500", "§5Youtuber", "§aIn Besitz");
        ItemStack gomme_nicht_besitz = Helper.setHeadShop("Kopf von GommeHD", "GommeHD", "2.500", "§5Youtuber", "§cNicht in Besitz");

        ItemStack bastighg_besitz = Helper.setHeadShop("Kopf von BastiGHG", "BastiGHG", "2.500", "§5Youtuber", "§aIn Besitz");
        ItemStack bastighg_nicht_besitz = Helper.setHeadShop("Kopf von BastiGHG", "BastiGHG", "2.500", "§5Youtuber", "§cNicht in Besitz");

        ItemStack rewinside_besitz = Helper.setHeadShop("Kopf von Rewinside", "Rewinside", "2.500", "§5Youtuber", "§aIn Besitz");
        ItemStack rewinside_nicht_besitz = Helper.setHeadShop("Kopf von Rewinside", "Rewinside", "2.500", "§5Youtuber", "§cNicht in Besitz");

        ItemStack letshugo_besitz = Helper.setHeadShop("Kopf von LetsHugo", "LetsHugo", "2.500", "§5Youtuber", "§aIn Besitz");
        ItemStack letshugo_nicht_besitz = Helper.setHeadShop("Kopf von LetsHugo", "LetsHugo", "2.500", "§5Youtuber", "§cNicht in Besitz");

        ItemStack nasty_besitz = Helper.setHeadShop("Kopf von NastyIsHere", "NastyIsHere", "1.000", "§bEntwickler", "§aIn Besitz");
        ItemStack nasty_nicht_besitz = Helper.setHeadShop("Kopf von NastyIsHere", "NastyIsHere", "1.000", "§bEntwickler", "§cNicht in Besitz");

        ItemStack cloudless_besitz = Helper.setHeadShop("Kopf von CloudLess", "CloudLess_", "1.000", "§aTeam", "§aIn Besitz");
        ItemStack cloudless_nicht_besitz = Helper.setHeadShop("Kopf von CloudLess", "CloudLess_", "1.000", "§aTeam", "§cNicht in Besitz");


        ItemStack jk1gaming_besitz = Helper.setHeadShop("Kopf von JK1Gaming", "JK1Gaming", "1.000", "§aTeam", "§aIn Besitz");
        ItemStack jk1gaming_nicht_besitz = Helper.setHeadShop("Kopf von JK1Gaming", "JK1Gaming", "1.000", "§aTeam", "§cNicht in Besitz");




        //OBEN
        hut_shop_1.setItem(0, placeholder);
        hut_shop_1.setItem(1, placeholder);
        hut_shop_1.setItem(2, placeholder);
        hut_shop_1.setItem(3, placeholder);
        hut_shop_1.setItem(4, placeholder);
        hut_shop_1.setItem(5, placeholder);
        hut_shop_1.setItem(6, placeholder);
        hut_shop_1.setItem(7, placeholder);
        hut_shop_1.setItem(8, placeholder);


        //RECHTS / LINKS
        hut_shop_1.setItem(9, left);
        hut_shop_1.setItem(17, right);

        //MITTE
        if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.GommeHD").equals(true)) {
            hut_shop_1.setItem(10, gomme_besitz);
        } else {
            hut_shop_1.setItem(10, gomme_nicht_besitz);
        }

        if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.BastiGHG").equals(true)) {
            hut_shop_1.setItem(11, bastighg_besitz);
        } else {
            hut_shop_1.setItem(11, bastighg_nicht_besitz);
        }

        if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.Rewinside").equals(true)) {
            hut_shop_1.setItem(12, rewinside_besitz);
        } else {
            hut_shop_1.setItem(12, rewinside_nicht_besitz);
        }

        if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.LetsHugo").equals(true)) {
            hut_shop_1.setItem(13, letshugo_besitz);
        } else {
            hut_shop_1.setItem(13, letshugo_nicht_besitz);
        }

        if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.NastyIsHere").equals(true)) {
            hut_shop_1.setItem(14, nasty_besitz);

        } else {
            hut_shop_1.setItem(14, nasty_nicht_besitz);

        }
        if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.CloudLess").equals(true)) {
            hut_shop_1.setItem(15, cloudless_besitz);
        } else {
            hut_shop_1.setItem(15, cloudless_nicht_besitz);

        }

        if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.JK1Gaming").equals(true)) {
            hut_shop_1.setItem(16, jk1gaming_besitz);
        } else {
            hut_shop_1.setItem(16, jk1gaming_nicht_besitz);

        }


        //UNTEN
        hut_shop_1.setItem(18, placeholder);
        hut_shop_1.setItem(19, placeholder);
        hut_shop_1.setItem(20, placeholder);
        hut_shop_1.setItem(21, placeholder);
        hut_shop_1.setItem(22, placeholder);
        hut_shop_1.setItem(23, placeholder);
        hut_shop_1.setItem(24, placeholder);
        hut_shop_1.setItem(25, placeholder);
        hut_shop_1.setItem(26, placeholder);
        p.openInventory(hut_shop_1);
    }

    public void openHutInv2(Player p) {
        p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
        ItemStack placeholder = Helper.setPlaceHolder();
        ItemStack left = Helper.setLeft();
        ItemStack right = Helper.setRight();

        ItemStack paluten_besitz = Helper.setHeadShop("Kopf von Paluten", "Paluten", "2.500", "§5Youtuber", "§aIn Besitz");
        ItemStack paluten_nicht_besitz = Helper.setHeadShop("Kopf von Paluten", "Paluten", "2.500", "§5Youtuber", "§cNicht in Besitz");

        ItemStack abgegrieft_besitz = Helper.setHeadShop("Kopf von Abgegrieft", "AbgegrieftHD", "2.500", "§5Youtuber", "§aIn Besitz");
        ItemStack abgegrieft_nicht_besitz = Helper.setHeadShop("Kopf von Abgegrieft", "AbgegrieftHD", "2.500", "§5Youtuber", "§cNicht in Besitz");

        ItemStack thejocraft_besitz = Helper.setHeadShop("Kopf von TheJoCraft", "TheJoCraft", "2.500", "§5Youtuber", "§aIn Besitz");
        ItemStack thejocraft_nicht_besitz = Helper.setHeadShop("Kopf von TheJoCraft", "TheJoCraft", "2.500", "§5Youtuber", "§cNicht in Besitz");

        ItemStack stein_besitz = Helper.setBlockShop("Stein", Material.STONE, "3.000", "§2Block", "§aIn Besitz");
        ItemStack stein_nicht_besitz = Helper.setBlockShop("Stein", Material.STONE, "3.000", "§2Block", "§cNicht in Besitz");

        ItemStack grass_besitz = Helper.setBlockShop("Grass", Material.GRASS, "3.000", "§2Block", "§aIn Besitz");
        ItemStack grass_nicht_besitz = Helper.setBlockShop("Grass", Material.GRASS, "3.000", "§2Block", "§cNicht in Besitz");

        ItemStack glas_besitz = Helper.setBlockShop("Glas", Material.GLASS, "3.000", "§2Block", "§aIn Besitz");
        ItemStack glas_nicht_besitz = Helper.setBlockShop("Glas", Material.GLASS, "3.000", "§2Block", "§cNicht in Besitz");

        ItemStack dia_besitz = Helper.setBlockShop("Diamantblock", Material.DIAMOND_BLOCK, "3.000", "§2Block", "§aIn Besitz");
        ItemStack dia_nicht_besitz = Helper.setBlockShop("Diamantblock", Material.DIAMOND_BLOCK, "3.000", "§2Block", "§cNicht in Besitz");




        //OBEN
        hut_shop_2.setItem(0, placeholder);
        hut_shop_2.setItem(1, placeholder);
        hut_shop_2.setItem(2, placeholder);
        hut_shop_2.setItem(3, placeholder);
        hut_shop_2.setItem(4, placeholder);
        hut_shop_2.setItem(5, placeholder);
        hut_shop_2.setItem(6, placeholder);
        hut_shop_2.setItem(7, placeholder);
        hut_shop_2.setItem(8, placeholder);


        //RECHTS / LINKS
        hut_shop_2.setItem(9, left);
        hut_shop_2.setItem(17, right);

        //MITTE
        if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.Paluten").equals(true)) {
            hut_shop_2.setItem(10, paluten_besitz);
        } else {
            hut_shop_2.setItem(10, paluten_nicht_besitz);
        }

        if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.Abgegrieft").equals(true)) {
            hut_shop_2.setItem(11, abgegrieft_besitz);
        } else {
            hut_shop_2.setItem(11, abgegrieft_nicht_besitz);
        }

        if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.TheJoCraft").equals(true)) {
            hut_shop_2.setItem(12, thejocraft_besitz);
        } else {
            hut_shop_2.setItem(12, thejocraft_nicht_besitz);
        }

        if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.Stein").equals(true)) {
            hut_shop_2.setItem(13, stein_besitz);
        } else {
            hut_shop_2.setItem(13, stein_nicht_besitz);
        }

        if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.Grass").equals(true)) {
            hut_shop_2.setItem(14, grass_besitz);

        } else {
            hut_shop_2.setItem(14, grass_nicht_besitz);

        }
        if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.Glas").equals(true)) {
            hut_shop_2.setItem(15, glas_besitz);
        } else {
            hut_shop_2.setItem(15, glas_nicht_besitz);

        }

        if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.Diamantblock").equals(true)) {
            hut_shop_2.setItem(16, dia_besitz);
        } else {
            hut_shop_2.setItem(16, dia_nicht_besitz);

        }


        //UNTEN
        hut_shop_2.setItem(18, placeholder);
        hut_shop_2.setItem(19, placeholder);
        hut_shop_2.setItem(20, placeholder);
        hut_shop_2.setItem(21, placeholder);
        hut_shop_2.setItem(22, placeholder);
        hut_shop_2.setItem(23, placeholder);
        hut_shop_2.setItem(24, placeholder);
        hut_shop_2.setItem(25, placeholder);
        hut_shop_2.setItem(26, placeholder);
        p.openInventory(hut_shop_2);
    }
}