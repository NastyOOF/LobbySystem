package com.nasty.lobby.gadgets;

import com.mojang.authlib.GameProfile;
import com.nasty.lobby.Main;
import com.nasty.lobby.addons.GameProfileBuilder;
import com.nasty.lobby.addons.Helper;
import com.nasty.lobby.addons.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

public class HutInventory implements Listener {



    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        Player p = (Player)e.getWhoClicked();

        ItemStack barrier = new ItemStack(Material.BARRIER);
        ItemMeta bmeta = barrier.getItemMeta();
        bmeta.setDisplayName("§cNichts vorhanden");
        barrier.setItemMeta(bmeta);

        if(e.getInventory().getName().equalsIgnoreCase("§6§lDeine Hüte")) {
            e.setCancelled(true);
            if(e.getCurrentItem() != null) {
                try {
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7GommeHD")) {
                        p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 2.0F);
                        p.closeInventory();
                        p.sendMessage(Main.getInstance().prefix + "§7Du hast jetzt den Kopf von §5GommeHD");
                        setHead(p, "GommeHD");
                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7BastiGHG")) {
                        p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 2.0F);
                        p.closeInventory();
                        p.sendMessage(Main.getInstance().prefix + "§7Du hast jetzt den Kopf von §5BastiGHG");
                        setHead(p, "BastiGHG");
                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Rewinside")) {
                        p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 2.0F);
                        p.closeInventory();
                        p.sendMessage(Main.getInstance().prefix + "§7Du hast jetzt den Kopf von §5Rewinside");
                        setHead(p, "Rewinside");
                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7LetsHugo")) {
                        p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 2.0F);
                        p.closeInventory();
                        p.sendMessage(Main.getInstance().prefix + "§7Du hast jetzt den Kopf von §5LetsHugo");
                        setHead(p, "LetsHugo");
                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7NastyIsHere")) {
                        p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 2.0F);
                        p.closeInventory();
                        p.sendMessage(Main.getInstance().prefix + "§7Du hast jetzt den Kopf von §bNastyIsHere");
                        setHead(p, "NastyIsHere");
                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7CloudLess_")) {
                        p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 2.0F);
                        p.closeInventory();
                        p.sendMessage(Main.getInstance().prefix + "§7Du hast jetzt den Kopf von §aCloudLess");
                        setHead(p, "CloudLess_");
                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7JK1Gaming")) {
                        p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 2.0F);
                        p.closeInventory();
                        p.sendMessage(Main.getInstance().prefix + "§7Du hast jetzt den Kopf von §aJK1Gaming");
                        setHead(p, "JK1Gaming");
                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Paluten")) {
                        p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 2.0F);
                        p.closeInventory();
                        p.sendMessage(Main.getInstance().prefix + "§7Du hast jetzt den Kopf von §5Paluten");
                        setHead(p, "Paluten");
                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Abgegrieft")) {
                        p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 2.0F);
                        p.closeInventory();
                        p.sendMessage(Main.getInstance().prefix + "§7Du hast jetzt den Kopf von §5Abgegrieft");
                        setHead(p, "AbgegrieftHD");
                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7TheJoCraft")) {
                        p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 2.0F);
                        p.closeInventory();
                        p.sendMessage(Main.getInstance().prefix + "§7Du hast jetzt den Kopf von §5TheJoCraft");
                        setHead(p, "TheJoCraft");
                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Stein")) {
                        p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 2.0F);
                        p.closeInventory();
                        p.sendMessage(Main.getInstance().prefix + "§7Du hast jetzt einen §2Steinblock §7als Kopf");
                        Helper.setBlock(p, Material.STONE, "§2Stein");
                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Grass")) {
                        p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 2.0F);
                        p.closeInventory();
                        p.sendMessage(Main.getInstance().prefix + "§7Du hast jetzt einen §2Grassblock §7als Kopf");
                        Helper.setBlock(p, Material.GRASS, "§2Grass");
                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Glas")) {
                        p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 2.0F);
                        p.closeInventory();
                        p.sendMessage(Main.getInstance().prefix + "§7Du hast jetzt einen §2Glasblock §7als Kopf");
                        Helper.setBlock(p, Material.GLASS, "§2Glas");
                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Diamantblock")) {
                        p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 2.0F);
                        p.closeInventory();
                        p.sendMessage(Main.getInstance().prefix + "§7Du hast jetzt einen §2Diamantblock §7als Kopf");
                        Helper.setBlock(p, Material.DIAMOND_BLOCK, "§2Diamantblock");
                    }

                } catch (NullPointerException e1) {

                }
            }
        }

    }

    public static void setHead(Player p, String name){

        @SuppressWarnings("deprecation")
        ItemStack item = new ItemStack (397, 1, (short) 3);
        SkullMeta meta = (SkullMeta)item.getItemMeta();
        meta.setDisplayName("§7" + name);
        meta.setOwner(name);
        item.setItemMeta(meta);


        p.getInventory().setHelmet(item);
    }



}
