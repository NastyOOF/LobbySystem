package com.nasty.lobby.gadgets;

import com.nasty.lobby.Main;
import com.nasty.lobby.addons.BootBuilder;
import com.nasty.lobby.addons.Helper;
import com.nasty.lobby.addons.ItemBuilder;
import com.nasty.lobby.addons.LobbyPets;
import com.nasty.lobby.commands.BuildCMD;
import com.nasty.lobby.config.ShopConfigManager;
import com.nasty.lobby.listener.JoinEvent;
import org.bukkit.Color;
import org.bukkit.event.Listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;

public class MainInventory implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if(e.getItem() != null) {
            try {
                if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lDein Inventar")) {
                    Inventory inv = Bukkit.createInventory(null, 9, "§6Dein Inventar");

                    ItemStack hut = new ItemBuilder(Material.IRON_HELMET).setName("§7Hüte").toItemStack();
                    ItemStack boots = new ItemBuilder(Material.GOLD_BOOTS).setName("§7Boots").toItemStack();
                    ItemStack pets = new ItemBuilder(Material.EGG).setName("§7Pets").toItemStack();
                    ItemStack gadgets = new ItemBuilder(Material.ENDER_PEARL).setName("§7Gadgets").toItemStack();
                    ItemStack remove = new ItemBuilder(Material.BARRIER).setName("§cAlles entfernen").toItemStack();

                    inv.setItem(0, hut);
                    inv.setItem(1, boots);
                    inv.setItem(2, pets);
                    inv.setItem(3, gadgets);
                    inv.setItem(8, remove);

                    e.getPlayer().openInventory(inv);
                }
            } catch (NullPointerException e1) {

            }
        }
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        if(BuildCMD.build.contains(e.getWhoClicked())) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
        Player p = (Player)e.getWhoClicked();

        ItemStack barrier = new ItemStack(Material.BARRIER);
        ItemMeta bmeta = barrier.getItemMeta();
        bmeta.setDisplayName("§cNichts vorhanden");
        barrier.setItemMeta(bmeta);

        if(e.getInventory().getName().equalsIgnoreCase("§6Dein Inventar")) {
            e.setCancelled(true);
            if(e.getCurrentItem() != null) {
                try {
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Hüte")) {
                        p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 2.0F);
                        Inventory inv = Bukkit.createInventory(null, 36, "§6§lDeine Hüte");

                        if (ShopConfigManager.config.getBoolean(p.getUniqueId().toString() + ".Huete.GommeHD")) {
                            inv.addItem(Helper.setHead("GommeHD"));
                        }
                        if (ShopConfigManager.config.getBoolean(p.getUniqueId().toString() + ".Huete.BastiGHG")) {
                            inv.addItem(Helper.setHead("BastiGHG"));
                        }
                        if (ShopConfigManager.config.getBoolean(p.getUniqueId().toString() + ".Huete.Rewinside")) {
                            inv.addItem(Helper.setHead("Rewinside"));
                        }
                        if (ShopConfigManager.config.getBoolean(p.getUniqueId().toString() + ".Huete.LetsHugo")) {
                            inv.addItem(Helper.setHead("LetsHugo"));
                        }
                        if (ShopConfigManager.config.getBoolean(p.getUniqueId().toString() + ".Huete.NastyIsHere")) {
                            inv.addItem(Helper.setHead("NastyIsHere"));
                        }
                        if (ShopConfigManager.config.getBoolean(p.getUniqueId().toString() + ".Huete.CloudLess")) {
                            inv.addItem(Helper.setHead("CloudLess_"));
                        }
                        if (ShopConfigManager.config.getBoolean(p.getUniqueId().toString() + ".Huete.JK1Gaming")) {
                            inv.addItem(Helper.setHead("JK1Gaming"));
                        }
                        if (ShopConfigManager.config.getBoolean(p.getUniqueId().toString() + ".Huete.Paluten")) {
                            inv.addItem(Helper.setHead("Paluten"));
                        }
                        if (ShopConfigManager.config.getBoolean(p.getUniqueId().toString() + ".Huete.Abgegrieft")) {
                            inv.addItem(Helper.setHead("AbgegrieftHD"));
                        }
                        if (ShopConfigManager.config.getBoolean(p.getUniqueId().toString() + ".Huete.TheJoCraft")) {
                            inv.addItem(Helper.setHead("TheJoCraft"));
                        }
                        if (ShopConfigManager.config.getBoolean(p.getUniqueId().toString() + ".Huete.Stein")) {
                            inv.addItem(Helper.setBlockInv(Material.STONE, "Stein"));
                        }
                        if (ShopConfigManager.config.getBoolean(p.getUniqueId().toString() + ".Huete.Grass")) {
                            inv.addItem(Helper.setBlockInv(Material.GRASS, "Grass"));
                        }
                        if (ShopConfigManager.config.getBoolean(p.getUniqueId().toString() + ".Huete.Glas")) {
                            inv.addItem(Helper.setBlockInv(Material.GLASS, "Glas"));
                        }
                        if (ShopConfigManager.config.getBoolean(p.getUniqueId().toString() + ".Huete.Diamantblock")) {
                            inv.addItem(Helper.setBlockInv(Material.DIAMOND_BLOCK, "Diamantblock"));
                        }


                        if (inv.getItem(0) == null) {
                            inv.setItem(13, barrier);
                        }

                        p.openInventory(inv);
                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Boots")) {
                        p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 2.0F);
                        Inventory inv = Bukkit.createInventory(null, 36, "§6§lDeine Boots");

                        if(ShopConfigManager.config.getBoolean(p.getUniqueId().toString() + ".Boots.LoveBoots") || p.hasPermission("lobby.*")) {
                            ItemStack love = BootBuilder.createBoot("§cLoveBoots", Color.RED);
                            inv.addItem(love);
                        }
                        if(ShopConfigManager.config.getBoolean(p.getUniqueId().toString() + ".Boots.MusicBoots") || p.hasPermission("lobby.*")) {
                            ItemStack love = BootBuilder.createBoot("§2MusicBoots", Color.GREEN);
                            inv.addItem(love);
                        }
                        if(ShopConfigManager.config.getBoolean(p.getUniqueId().toString() + ".Boots.SpeedBoots") || p.hasPermission("lobby.*")) {
                            ItemStack love = BootBuilder.createBoot("§aSpeedBoots", Color.fromRGB(0, 255, 68));
                            inv.addItem(love);
                        }
                        if(ShopConfigManager.config.getBoolean(p.getUniqueId().toString() + ".Boots.JetpackBoots") || p.hasPermission("lobby.*")) {
                            ItemStack jetpack = BootBuilder.createBoot("§bJetpackBoots", Color.fromRGB(4, 4, 4));
                            inv.addItem(jetpack);
                        }


                        if (inv.getItem(0) == null) {
                            inv.setItem(13, barrier);
                        }

                        p.openInventory(inv);
                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Pets")) {
                        p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 2.0F);
                        Inventory inv = Bukkit.createInventory(null, 36, "§6§lDeine Pets");

                        ItemStack tier1 = new ItemBuilder(Material.GRASS).setName("§cSkelett").toItemStack();
                        ItemStack tier2 = new ItemBuilder(Material.GRASS).setName("§cZombie").toItemStack();
                        ItemStack tier3 = new ItemBuilder(Material.GRASS).setName("§cSpinne").toItemStack();
                        ItemStack tier4 = new ItemBuilder(Material.GRASS).setName("§cZombie Pigman").toItemStack();
                        ItemStack tier5 = new ItemBuilder(Material.GRASS).setName("§cEnderman").toItemStack();
                        ItemStack tier6 = new ItemBuilder(Material.GRASS).setName("§cKuh").toItemStack();
                        ItemStack tier7 = new ItemBuilder(Material.GRASS).setName("§cWolf").toItemStack();
                        ItemStack tier8 = new ItemBuilder(Material.GRASS).setName("§cPferd").toItemStack();
                        ItemStack tier9 = new ItemBuilder(Material.GRASS).setName("§cKaninchen").toItemStack();

                        inv.addItem(tier1);
                        inv.addItem(tier2);
                        inv.addItem(tier3);
                        inv.addItem(tier4);
                        inv.addItem(tier5);
                        inv.addItem(tier6);
                        inv.addItem(tier7);
                        inv.addItem(tier8);
                        inv.addItem(tier9);

                        if (inv.getItem(0) == null) {
                            inv.setItem(13, barrier);
                        }

                        p.openInventory(inv);
                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Gadgets")) {
                        p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 2.0F);
                        Inventory inv = Bukkit.createInventory(null, 36, "§6§lDeine Gadgets");

                        ItemStack rod = new ItemBuilder(Material.FISHING_ROD).setName("§5Enterhaken").toItemStack();
                        inv.addItem(rod);


                        if (inv.getItem(0) == null) {
                            inv.setItem(13, barrier);
                        }

                        p.openInventory(inv);
                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cAlles entfernen")) {
                        p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 2.0F);
                        p.getInventory().clear();
                        p.getInventory().setArmorContents(null);
                        JoinEvent.giveItems(p);
                        if(LobbyPets.isUsingPet.containsKey(p)) {
                            LobbyPets.removePet(p);
                        }
                        p.sendMessage(Main.getInstance().prefix + "§7Du hast alle Items entfernt!");
                        p.closeInventory();
                    }

                } catch (NullPointerException e1) {

                }
            }
        }

    }
}
