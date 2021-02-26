package com.nasty.lobby.gadgets.boots;

import com.nasty.lobby.addons.Particle;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class LoveBoots implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        try {
        if(p.getInventory().getBoots().getItemMeta().getDisplayName().equalsIgnoreCase("§cLoveBoots")) {
            for(Player all : Bukkit.getOnlinePlayers()) {
                Particle particle = new Particle(EnumParticle.HEART, p.getLocation().add(0,0.5,0), true, 0, 0 ,0, 1, 1);
                particle.sendPlayer(all);
            }
        }
            } catch (NullPointerException e1) {}

    }

}
