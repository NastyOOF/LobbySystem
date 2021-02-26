package com.nasty.lobby.gadgets.boots;

import com.nasty.lobby.addons.Particle;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class JetpackBoots implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        try {
            if(p.getInventory().getBoots().getItemMeta().getDisplayName().equalsIgnoreCase("§bJetpackBoots")) {
                if (p.isSneaking()) {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.getWorld().playEffect(p.getLocation().add(0.0D, 0.0D, 0.0D), Effect.MOBSPAWNER_FLAMES, 1);
                        p.playSound(p.getLocation(), Sound.FIRE, 2.0F, 1.0F);
                    }
                    Vector v = p.getLocation().getDirection().multiply(1.5D).setY(0.8D);
                    p.setVelocity(v);

                }
            }
        } catch (NullPointerException e1) {}

    }

}
