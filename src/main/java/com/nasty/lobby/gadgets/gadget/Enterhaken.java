package com.nasty.lobby.gadgets.gadget;

import com.nasty.lobby.addons.ItemBuilder;
import net.minecraft.server.v1_8_R3.Items;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class Enterhaken implements Listener {

    @EventHandler

    public void onFish(PlayerFishEvent e){

        Player p = e.getPlayer();
        FishHook h = e.getHook();

        if(h.getLocation().subtract(0, 1, 0).getBlock().getType() != Material.AIR){

            Location ploc = p.getLocation();
            Location hloc = h.getLocation();

            Vector v  = p.getVelocity();

            double d = ploc.distance(hloc);

            v.setX((1.08 * d) * (hloc.getX() - ploc.getX()) / d);
            v.setY((0.1 * d) * (hloc.getY() - ploc.getY()) / d - -0.05D * d);
            v.setZ((1.08 * d) * (hloc.getZ() - ploc.getZ()) / d);

            p.setVelocity(v);
            ItemStack rod = new ItemBuilder(Material.FISHING_ROD).setName("§5Enterhaken").toItemStack();
            p.getInventory().setItem(5, rod);
            p.updateInventory();
        }


    }
}
