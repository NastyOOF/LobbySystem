package com.nasty.lobby.gadgets.boots;

import com.nasty.lobby.addons.Particle;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Map;

public class SpeedBoots implements Listener {


    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        try {
            if(p.getInventory().getBoots().getItemMeta().getDisplayName().equalsIgnoreCase("§aSpeedBoots")) {
                for(Player all : Bukkit.getOnlinePlayers()) {
                    Particle particle = new Particle(EnumParticle.PORTAL, p.getLocation().add(0,0,0), true, 0, 0 ,0, 1, 1);
                    particle.sendPlayer(all);
                }
                if(e.getPlayer().isSprinting()) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2147483647, 10));

                } else {
                    for(PotionEffect all : p.getActivePotionEffects()) {
                        p.removePotionEffect(all.getType());
                    }

                }
            }
        } catch (NullPointerException e1) {}

    }

}