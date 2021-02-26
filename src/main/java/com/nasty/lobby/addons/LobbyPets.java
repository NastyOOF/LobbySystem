package com.nasty.lobby.addons;

import com.nasty.lobby.Main;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftCreature;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class LobbyPets {
    public static Entity ent;

    public static HashMap<Player, Entity> isUsingPet = new HashMap<>();

    public static void getPet(Player p, EntityType type) {
        if(isUsingPet.containsKey(p)) {
            removePet(p);
        }
        try {
            Entity e = p.getWorld().spawnEntity(p.getLocation(), type);
            e.setCustomName(p.getName() + "'s Pet");
            e.setCustomNameVisible(true);
            isUsingPet.put(p, e);
        } catch (Exception e) {}
    }

    public static void removePet(Player p) {
        if(isUsingPet.containsKey(p)) {
            isUsingPet.get(p).remove();
        }
    }

    public static void moveEntity(Player p) {
        Entity e = isUsingPet.get(p);

        Location loc = p.getLocation();
        loc.subtract(2,0,2);

                    if(p.getLocation().distance(e.getLocation()) > 3) {
                        CraftCreature cc = (CraftCreature) e;
                        cc.getHandle().getNavigation().a(loc.getX(), loc.getY(), loc.getZ(), 1.7);
                        cc.setTarget(p);

                    } else if(p.getLocation().distance(e.getLocation()) > 15) {
                        e.teleport(p.getLocation());
                    }
    }
}