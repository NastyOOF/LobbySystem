package com.nasty.lobby.gadgets;

import com.nasty.lobby.Main;
import com.nasty.lobby.addons.ItemBuilder;
import com.nasty.lobby.addons.LobbyPets;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GadgetsInventory implements Listener {

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        ItemStack barrier = new ItemStack(Material.BARRIER);
        ItemMeta bmeta = barrier.getItemMeta();
        bmeta.setDisplayName("§cNichts vorhanden");
        barrier.setItemMeta(bmeta);

        if (e.getInventory().getName().equalsIgnoreCase("§6§lDeine Gadgets")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null) {
                try {
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5Enterhaken")) {
                        p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 2.0F);
                        p.closeInventory();
                        p.sendMessage(Main.getInstance().prefix + "§7Du hast jetzt einen Enterhaken als Gadget!");


                        ItemStack rod = new ItemBuilder(Material.FISHING_ROD).setName("§5Enterhaken").toItemStack();
                        p.getInventory().setItem(5, rod);
                        p.updateInventory();
                    }

                } catch (NullPointerException e1) {

                }
            }
        }

    }
}
