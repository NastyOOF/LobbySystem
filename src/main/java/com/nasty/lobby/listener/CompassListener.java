package com.nasty.lobby.listener;

import com.nasty.lobby.Main;
import com.nasty.lobby.addons.CompassUtil;
import com.nasty.lobby.addons.Particle;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Bukkit;
import org.bukkit.Location;
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
import java.util.HashMap;
import java.util.List;

public class CompassListener implements Listener {
    public HashMap<String, Location> locationHashMap = new HashMap<>();


    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        if(e.getItem() != null) {
            try {
                if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lNavigator")) {
                    Inventory inv = Bukkit.createInventory(null, 36, "§6§lNavigator");
                    List<String> list = getWarps();

                    for(String s : list) {
                        try {
                            String name = s.split(":")[0];
                            Material material = Material.valueOf(s.split(":")[1].toUpperCase());
                            int slot = Integer.parseInt(s.split(":")[2]);
                            Location location = new Location(Bukkit.getWorld(s.split(":")[3]), Double.valueOf(s.split(":")[4]),
                                    Double.valueOf(s.split(":")[5]), Double.valueOf(s.split(":")[6]), Float.valueOf(s.split(":")[7]),
                                    Float.valueOf(s.split(":")[8]));
                            locationHashMap.put(name, location);

                            ItemStack item = new ItemStack(material);
                            ItemMeta invmeta = item.getItemMeta();
                            invmeta.setDisplayName(name);
                            item.setItemMeta(invmeta);

                            inv.setItem(slot, item);
                        } catch (Exception e1) {

                        }
                    }
                    e.getPlayer().openInventory(inv);
                }
            } catch (NullPointerException e1) {

            }
        }
    }
    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        Player p = (Player)e.getWhoClicked();
        if(e.getInventory().getName().equalsIgnoreCase("§6§lNavigator")) {
            if(e.getCurrentItem() != null) {
                try {
                    String displayname = e.getCurrentItem().getItemMeta().getDisplayName();
                    if (locationHashMap.containsKey(displayname)) {
                        e.getWhoClicked().closeInventory();
                        e.getWhoClicked().teleport(locationHashMap.get(displayname));
                          Particle particle = new Particle(EnumParticle.EXPLOSION_HUGE, p.getLocation().add(0,2.5,0), true, 0, 0 ,0, 1, 1);
                        particle.sendPlayer(p);
                        p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1, 1);
                    }
                } catch (NullPointerException e1) {
                    return;
                }
            }
        }
    }

    public List<String> getWarps() {
        try {
            return CompassUtil.cfg.getStringList("navigator");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
