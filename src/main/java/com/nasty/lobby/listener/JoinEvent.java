package com.nasty.lobby.listener;

import com.nasty.lobby.Main;
import com.nasty.lobby.addons.*;
import com.nasty.lobby.config.ConfigHandler;
import com.nasty.lobby.config.ShopConfigManager;
import com.nasty.lobby.prefixsystem.TabList;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.io.IOException;

public class JoinEvent implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        clearChat(p);
        checkConfig(p);
        if(ConfigHandler.config.getBoolean("Tablist.Enable")) {
            TabList.setPrefix(p);
        }
        Bukkit.getOnlinePlayers().forEach(p1 -> {
            if(HideListener.hide.contains(p1)) {
                if (p1 != e.getPlayer()) {
                    p1.hidePlayer(e.getPlayer());
                }
            }
        });
        giveItems(p);
        p.setGameMode(GameMode.SURVIVAL);
        for(Player all : Bukkit.getOnlinePlayers()) {
            AntiBuildListener.onPvP(all);
        }
        if(p.getUniqueId().toString().equals("dfe27689-db6e-4192-8a7d-468f2f75e08e")) {
            p.sendMessage("§7[§cPLUGIN-SYSTEM§7] §cDieser Server nutzt dein LobbySystem!");
            p.sendMessage("§7[§cPLUGIN-SYSTEM§7] §cLizenz: §7" + Main.getInstance().getConfig().getString("LICENSE.key"));
        }
        if(p.getUniqueId().toString().equals("74fd9dff-4749-45b9-b243-0c3d6a75fe0c") || p.getUniqueId().toString().equals("f17f493f-b416-4a8b-9132-c6710e4549ec") ||
                p.getUniqueId().toString().equals("7d34b8db-5405-4a51-8ce7-877d56a6bdb9")) {

            p.sendMessage("§7[§cPLUGIN-SYSTEM§7] §cDieser Server nutzt das LobbySystem von Your-Plugin!");
            if (p.getUniqueId().toString().equals("7d34b8db-5405-4a51-8ce7-877d56a6bdb9")) {
                p.sendMessage("§7[§cPLUGIN-SYSTEM§7] §cLizenz: §7" + Main.getInstance().getConfig().getString("LICENSE.key"));
            }
        }
        final CoinsAPI coinsAPI = new CoinsAPI();

            if(!coinsAPI.isExisting(p.getUniqueId().toString())) {
                coinsAPI.create(p.getUniqueId().toString());
            }
            for(Player all : Bukkit.getOnlinePlayers()) {
                LobbyScore.sendScoreboard(all);
            }



        if(Main.getInstance().getConfig().getBoolean("JoinTitle.Enable")) {
            Actionbar.sendTitle(p, Main.getInstance().getConfig().getString("JoinTitle.FirstLine").replace("&", "§"),
                    Main.getInstance().getConfig().getString("JoinTitle.ThirdLine").replace("&", "§"), 5, 40, 5);
        }

        if(Main.getInstance().getConfig().getBoolean("Join.Sound")) {
            p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 10, 10);
        }
        if(Main.getInstance().getConfig().getBoolean("Join.Particle")) {
            Particle particle = new Particle(EnumParticle.EXPLOSION_LARGE, p.getLocation().add(0,2.5,0), true, 0, 0 ,0, 1, 1);
            particle.sendPlayer(p);
        }
        if(Main.getInstance().getConfig().getBoolean("Join.Message.Enable")) {
            e.setJoinMessage(null);
            Bukkit.broadcastMessage(Main.getInstance().prefix + Main.getInstance().getConfig().getString("Join.Message.Message").replace("&", "§").replace("%player%", p.getName()));
        }
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        if(Main.getInstance().getConfig().getBoolean("Leave.Message.Enable")) {
            e.setQuitMessage(null);
            Bukkit.broadcastMessage(Main.getInstance().prefix + Main.getInstance().getConfig().getString("Leave.Message.Message").replace("&", "§").replace("%player%", p.getName()));

            if(HideListener.hide.contains(e.getPlayer())) {
                HideListener.hide.remove(e.getPlayer());
            }
            if(LobbyPets.isUsingPet.containsKey(p)) {
                LobbyPets.removePet(p);
            }


        }
    }
    public void clearChat(Player p) {
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
    }

    public static void giveItems(Player p) {
        p.getInventory().clear();
        p.getInventory().setArmorContents(null);
        ItemStack navi = new ItemStack(Material.COMPASS);
        ItemMeta navimeta = navi.getItemMeta();
        navimeta.setDisplayName("§6§lNavigator");
        navi.setItemMeta(navimeta);

        ItemStack hide_show = new ItemStack(Material.MAGMA_CREAM);
        ItemMeta hidemeta = hide_show.getItemMeta();
        hidemeta.setDisplayName("§6§lSpielersichtbarkeit");
        hide_show.setItemMeta(hidemeta);

        ItemStack inv = new ItemStack(Material.CHEST);
        ItemMeta invmeta = inv.getItemMeta();
        invmeta.setDisplayName("§6§lDein Inventar");
        inv.setItemMeta(invmeta);

        ItemStack profile = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta profileMETA = (SkullMeta) profile.getItemMeta();
        profileMETA.setDisplayName("§6§lDein Profil");
        profileMETA.setLore(null);
        profileMETA.setOwner(p.getName());
        profile.setItemMeta(profileMETA);

        p.getInventory().setItem(0, navi);
        p.getInventory().setItem(1, hide_show);
        p.getInventory().setItem(4, inv);
        p.getInventory().setItem(8, profile);
        p.updateInventory();
    }

    private void checkConfig(Player p) {
        if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.GommeHD") == null) {
            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Huete.GommeHD", false);
        }
        if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.BastiGHG") == null) {
            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Huete.BastiGHG", false);
        }
        if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.Rewinside") == null) {
            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Huete.Rewinside", false);
        }
        if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.LetsHugo") == null) {
            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Huete.LetsHugo", false);
        }
        if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.NastyIsHere") == null) {
            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Huete.NastyIsHere", false);
        }
        if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.CloudLess") == null) {
            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Huete.CloudLess", false);
        }
        if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.JK1Gaming") == null) {
            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Huete.JK1Gaming", false);
        }
        if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.Paluten") == null) {
            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Huete.Paluten", false);
        }
        if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.Abgegrieft") == null) {
            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Huete.Abgegrieft", false);
        }
        if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.TheJoCraft") == null) {
            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Huete.TheJoCraft", false);
        }
        if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.Stein") == null) {
            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Huete.Stein", false);
        }
        if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.Grass") == null) {
            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Huete.Grass", false);
        }
        if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.Glas") == null) {
            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Huete.Glas", false);
        }
        if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Huete.Diamantblock") == null) {
            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Huete.Diamantblock", false);
        }


        if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Boots.LoveBoots") == null) {
            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Boots.LoveBoots", false);
        }
        if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Boots.MusicBoots") == null) {
            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Boots.MusicBoots", false);
        }
        if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Boots.SpeedBoots") == null) {
            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Boots.SpeedBoots", false);
        }
        if(ShopConfigManager.config.get(p.getUniqueId().toString() + ".Boots.JetpackBoots") == null) {
            ShopConfigManager.config.set(p.getUniqueId().toString() + ".Boots.JetpackBoots", false);
        }
        try {
            ShopConfigManager.config.save(ShopConfigManager.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}