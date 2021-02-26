package com.nasty.lobby.gadgets;

import com.mojang.authlib.GameProfile;
import com.nasty.lobby.Main;
import com.nasty.lobby.addons.GameProfileBuilder;
import com.nasty.lobby.addons.ItemBuilder;
import com.nasty.lobby.addons.LobbyPets;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.UUID;

public class PetsInventory implements Listener {


    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        ItemStack barrier = new ItemStack(Material.BARRIER);
        ItemMeta bmeta = barrier.getItemMeta();
        bmeta.setDisplayName("§cNichts vorhanden");
        barrier.setItemMeta(bmeta);

        if (e.getInventory().getName().equalsIgnoreCase("§6§lDeine Pets")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null) {
                try {
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cSkelett")) {
                        p.closeInventory();
                        p.sendMessage(Main.getInstance().prefix + "§7Du hast jetzt ein §cSkelett §7als Pet!");

                        LobbyPets.getPet(p, EntityType.SKELETON);
                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cZombie")) {
                        p.closeInventory();
                        p.sendMessage(Main.getInstance().prefix + "§7Du hast jetzt ein §cZombie §7als Pet!");

                        LobbyPets.getPet(p, EntityType.ZOMBIE);
                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cSpinne")) {
                        p.closeInventory();
                        p.sendMessage(Main.getInstance().prefix + "§7Du hast jetzt eine §cSpinne §7als Pet!");

                        LobbyPets.getPet(p, EntityType.SPIDER);
                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cZombie Pigman")) {
                        p.closeInventory();
                        p.sendMessage(Main.getInstance().prefix + "§7Du hast jetzt ein §cZombie Pigman §7als Pet!");

                        LobbyPets.getPet(p, EntityType.PIG_ZOMBIE);
                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cEnderman")) {
                        p.closeInventory();
                        p.sendMessage(Main.getInstance().prefix + "§7Du hast jetzt ein §cEnderman §7als Pet!");

                        LobbyPets.getPet(p, EntityType.ENDERMAN);
                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cKuh")) {
                        p.closeInventory();
                        p.sendMessage(Main.getInstance().prefix + "§7Du hast jetzt eine §cKuh §7als Pet!");

                        LobbyPets.getPet(p, EntityType.COW);
                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cWolf")) {
                        p.closeInventory();
                        p.sendMessage(Main.getInstance().prefix + "§7Du hast jetzt einen §cWolf §7als Pet!");

                        LobbyPets.getPet(p, EntityType.WOLF);
                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cPferd")) {
                        p.closeInventory();
                        p.sendMessage(Main.getInstance().prefix + "§7Du hast jetzt ein §cPferd §7als Pet!");

                        LobbyPets.getPet(p, EntityType.HORSE);
                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cKaninchen")) {
                        p.closeInventory();
                        p.sendMessage(Main.getInstance().prefix + "§7Du hast jetzt ein §cKaninchen §7als Pet!");

                        LobbyPets.getPet(p, EntityType.RABBIT);
                    }

                } catch (NullPointerException e1) {

                }
            }
        }

    }
}