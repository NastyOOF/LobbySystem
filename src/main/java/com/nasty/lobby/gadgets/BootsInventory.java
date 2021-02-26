package com.nasty.lobby.gadgets;

import com.mojang.authlib.GameProfile;
import com.nasty.lobby.Main;
import com.nasty.lobby.addons.BootBuilder;
import com.nasty.lobby.addons.GameProfileBuilder;
import com.nasty.lobby.addons.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.UUID;

public class BootsInventory implements Listener {



    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        Player p = (Player)e.getWhoClicked();

        ItemStack barrier = new ItemStack(Material.BARRIER);
        ItemMeta bmeta = barrier.getItemMeta();
        bmeta.setDisplayName("§cNichts vorhanden");
        barrier.setItemMeta(bmeta);

        if(e.getInventory().getName().equalsIgnoreCase("§6§lDeine Boots")) {
            e.setCancelled(true);
            if(e.getCurrentItem() != null) {
                try {
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cLoveBoots")) {
                        p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 2.0F);
                        p.closeInventory();
                        p.sendMessage(Main.getInstance().prefix + "§7Du hast jetzt die Love Boots!");

                        ItemStack love = BootBuilder.createBoot("§cLoveBoots", Color.RED);

                        p.getInventory().setBoots(love);
                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§2MusicBoots")) {
                        p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 2.0F);
                        p.closeInventory();
                        p.sendMessage(Main.getInstance().prefix + "§7Du hast jetzt die Music Boots!");

                        ItemStack love = BootBuilder.createBoot("§2MusicBoots", Color.GREEN);

                        p.getInventory().setBoots(love);
                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aSpeedBoots")) {
                        p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 2.0F);
                        p.closeInventory();
                        p.sendMessage(Main.getInstance().prefix + "§7Du hast jetzt die Speed Boots!");

                        ItemStack love = BootBuilder.createBoot("§aSpeedBoots", Color.fromRGB(0, 255, 68));

                        p.getInventory().setBoots(love);
                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bJetpackBoots")) {
                        p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 2.0F);
                        p.closeInventory();
                        p.sendMessage(Main.getInstance().prefix + "§7Du hast jetzt die Jetpack Boots");

                        ItemStack jetpack = BootBuilder.createBoot("§bJetpackBoots", Color.fromRGB(4, 4, 4));
                        p.getInventory().setBoots(jetpack);
                    }

                } catch (NullPointerException e1) {

                }
            }
        }

    }

}
