package com.nasty.lobby.listener;

import com.nasty.lobby.Main;
import com.nasty.lobby.addons.CoinsAPI;
import com.nasty.lobby.addons.LobbyScore;
import com.nasty.lobby.addons.Particle;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class HideListener implements Listener {
    public static List<Player> hide = new ArrayList<>();

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if(e.getItem() != null) {
            try {
                if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lSpielersichtbarkeit")) {
                    Inventory inv = Bukkit.createInventory(null, 9, "§6§lSpielersichtbarkeit");

                    ItemStack hide_show = new ItemStack(Material.INK_SACK, 1, (short)10);
                    ItemMeta hidemeta = hide_show.getItemMeta();
                    hidemeta.setDisplayName("§a§lZeige alle Spieler");
                    hide_show.setItemMeta(hidemeta);

                    ItemStack hide_no = new ItemStack(Material.INK_SACK, 1, (short)1);
                    ItemMeta hidemeta1 = hide_no.getItemMeta();
                    hidemeta1.setDisplayName("§c§lZeige keine Spieler");
                    hide_no.setItemMeta(hidemeta1);

                    ItemStack placeholder = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
                    ItemMeta placeholder1 = placeholder.getItemMeta();
                    placeholder1.setDisplayName(" ");
                    placeholder.setItemMeta(placeholder1);

                    inv.setItem(0, placeholder);
                    inv.setItem(1, placeholder);
                    inv.setItem(2, placeholder);
                    inv.setItem(3, hide_show);
                    inv.setItem(4, placeholder);
                    inv.setItem(5, hide_no);
                    inv.setItem(6, placeholder);
                    inv.setItem(7, placeholder);
                    inv.setItem(8, placeholder);

                    e.getPlayer().openInventory(inv);
                }
            } catch (NullPointerException e1) {

            }
        }
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        Player p = (Player)e.getWhoClicked();

        if(e.getInventory().getName().equalsIgnoreCase("§6§lSpielersichtbarkeit")) {
            e.setCancelled(true);
            if(e.getCurrentItem() != null) {
                try {
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lZeige alle Spieler")) {
                        p.closeInventory();
                        hide.remove(((Player) e.getWhoClicked()).getPlayer());
                        Bukkit.getOnlinePlayers().forEach(p1 -> {
                            if(((Player) e.getWhoClicked()).getPlayer() != p1) {
                                ((Player) e.getWhoClicked()).getPlayer().showPlayer(p1);
                            }
                        });
                        p.playSound(p.getLocation(), Sound.NOTE_BASS, 1, 1);
                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lZeige keine Spieler")) {
                        p.closeInventory();
                        hide.add(((Player) e.getWhoClicked()).getPlayer());
                        Bukkit.getOnlinePlayers().forEach(p1 -> {
                            if (((Player) e.getWhoClicked()).getPlayer() != p1) {
                                ((Player) e.getWhoClicked()).getPlayer().hidePlayer(p1);
                            }
                        });
                        p.playSound(p.getLocation(), Sound.NOTE_BASS, 1, 1);
                    }
                } catch (NullPointerException e1) {

                }
            }
            }

        }
}
