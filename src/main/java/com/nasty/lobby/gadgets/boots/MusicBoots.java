package com.nasty.lobby.gadgets.boots;

import com.nasty.lobby.addons.Particle;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MusicBoots implements Listener {


    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        try {
            if(p.getInventory().getBoots().getItemMeta().getDisplayName().equalsIgnoreCase("§2MusicBoots")) {
                for(Player all : Bukkit.getOnlinePlayers()) {
                    Particle particle = new Particle(EnumParticle.NOTE, p.getLocation().add(0,0.5,0.5), true, 0, 0 ,0, 1, 1);
                    particle.sendPlayer(all);
                    p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 2.0F);
                }
            }
        } catch (NullPointerException e1) {}

    }
}
