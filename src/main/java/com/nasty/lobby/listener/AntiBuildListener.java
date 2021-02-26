package com.nasty.lobby.listener;

import com.nasty.lobby.addons.LobbyPets;
import com.nasty.lobby.commands.BuildCMD;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.EntityBlockFormEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class AntiBuildListener implements Listener {

    @EventHandler
    public void onBuild(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if(BuildCMD.build.contains(p)) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if(BuildCMD.build.contains(p)) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        Player p = e.getPlayer();
        if(BuildCMD.build.contains(p)) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onPickup(PlayerPickupItemEvent e) {
        Player p = e.getPlayer();
        if(BuildCMD.build.contains(p)) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onWeather(WeatherChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
            e.setCancelled(true);
    }

    @EventHandler
    public void onDamageByMob(EntityDamageByEntityEvent e) {
        e.setCancelled(true);
    }
    @EventHandler
    public void onFood(FoodLevelChangeEvent e) {
        if (e.getEntity() instanceof Player) {
            e.setCancelled(true);
            ((Player) e.getEntity()).setFoodLevel(20);
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        if(LobbyPets.isUsingPet.containsKey(e.getPlayer())) {
            LobbyPets.moveEntity(e.getPlayer());
        }
    }

    @EventHandler
    public void onExplode(EntityExplodeEvent e) {
        e.setCancelled(true);
    }
    @EventHandler
    public void onBreakDoor(EntityBreakDoorEvent e) {
        e.setCancelled(true);
    }
    @EventHandler
    public void onBlockChange(EntityChangeBlockEvent e) {
        e.setCancelled(true);
    }
    @EventHandler
    public void onSnow(EntityBlockFormEvent e) {
        e.setCancelled(true);
    }


    public static void onPvP(Player p) {
        p.getWorld().setPVP(false);
    }
}
