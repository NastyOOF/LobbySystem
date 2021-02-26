package com.nasty.lobby.commands;

import com.nasty.lobby.Main;
import com.nasty.lobby.addons.Actionbar;
import com.nasty.lobby.addons.CompassUtil;
import net.minecraft.server.v1_8_R3.EntitySheep;
import net.minecraft.server.v1_8_R3.EntityVillager;
import net.minecraft.server.v1_8_R3.EntityWitch;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftSheep;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftVillager;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftWitch;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.io.File;

public class SetupCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (p.hasPermission("lobby.setup")) {
            if(args.length == 0) {
                p.sendMessage(Main.getInstance().prefix + "§cNutze: /lobbysystem setup <villager, shop, navigator>");
            }
            if(args.length == 1) {
                if(args[0].equalsIgnoreCase("pos")) {
                    p.sendMessage("");
                    p.sendMessage(Main.getInstance().prefix + "§7Deine Position:");
                    p.sendMessage(Main.getInstance().prefix + "§7X: §c" + p.getLocation().getX());
                    p.sendMessage(Main.getInstance().prefix + "§7Y: §c" + p.getLocation().getY());
                    p.sendMessage(Main.getInstance().prefix + "§7Z: §c" + p.getLocation().getZ());
                    p.sendMessage(Main.getInstance().prefix + "§7YAW: §c" + p.getLocation().getYaw());
                    p.sendMessage(Main.getInstance().prefix + "§7PITCH: §c" + p.getLocation().getPitch());
                    p.sendMessage("");
                }
            }
            if(args.length == 2) {
                if(args[1].equalsIgnoreCase("villager")) {
                    p.sendMessage(Main.getInstance().prefix + "§cNutze: /lobbysystem setup <villager> <spawn, kill>");
                } else if(args[1].equalsIgnoreCase("navigator")) {
                    p.sendMessage(Main.getInstance().prefix + "§cNutze: /lobbysystem setup navigator <name> <material> <slot>");
                } else {
                    p.sendMessage(Main.getInstance().prefix + "§cNutze: /lobbysystem setup <villager, spawn>");
                }
            }
            if(args.length == 3) {
                if(args[1].equalsIgnoreCase("villager")) {
                    if(args[2].equalsIgnoreCase("kill")) {
                        if(BuildCMD.build.contains(p)) {
                            org.bukkit.inventory.ItemStack bucket = new ItemStack(Material.STICK);
                            ItemMeta bucket1 = bucket.getItemMeta();
                            bucket1.setDisplayName("§c§lMache §6§lLinksklick §c§lauf einen Villager, um diesen zu Löschen!");
                            bucket.setItemMeta(bucket1);

                            p.getInventory().addItem(bucket);
                            p.sendMessage("§7Du hast das Lösch Item in dein Inventar bekommen!");
                        } else {
                            p.sendMessage(Main.getInstance().prefix + "§cDu musst im Baumodus sein!");
                        }
                    } else if(args[2].equalsIgnoreCase("spawn")) {
                        Villager villager = (Villager) p.getWorld().spawnCreature(p.getLocation(), EntityType.VILLAGER);
                        villager.setProfession(Villager.Profession.FARMER);
                        villager.setCustomName("§e§lTägliche Belohnung");
                        villager.setCustomNameVisible(true);
                        villager.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 2147483647, 2147483647));
                        villager.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 2147483647, 2147483647));
                        setNoAI(villager);
                        p.sendMessage(Main.getInstance().prefix + "§7Der §cVillager §7wurde plaziert!");
                    } else {
                        p.sendMessage(Main.getInstance().prefix + "§cNutze: /lobbysystem setup villager <spawn, kill>");
                    }
                } else if(args[1].equalsIgnoreCase("shop")) {
                    if(args[2].equalsIgnoreCase("spawn")) {
                        Witch witch = (Witch) p.getWorld().spawnCreature(p.getLocation(), EntityType.WITCH);
                        witch.setCustomName("§c§lGadget-Shop");
                        witch.setCustomNameVisible(true);
                        witch.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 2147483647, 2147483647));
                        witch.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 2147483647, 2147483647));
                        setNoAIWitch(witch);
                        p.sendMessage(Main.getInstance().prefix + "§7Der §cGadget-Shop §7wurde plaziert!");
                    } else if(args[2].equalsIgnoreCase("kill")) {
                        if(BuildCMD.build.contains(p)) {

                            org.bukkit.inventory.ItemStack bucket = new ItemStack(Material.STICK);
                            ItemMeta bucket1 = bucket.getItemMeta();
                            bucket1.setDisplayName("§c§lMache §6§lLinksklick §c§lauf einen Gadget-Shop, um diesen zu Löschen!");
                            bucket.setItemMeta(bucket1);

                            p.getInventory().addItem(bucket);
                            p.sendMessage("§7Du hast das Lösch Item in dein Inventar bekommen!");
                        } else {
                            p.sendMessage(Main.getInstance().prefix + "§cDu musst im Baumodus sein!");
                        }
                    }
                }
            }
            if(args.length == 4) {
                if(args[1].equalsIgnoreCase("navigator")) {
                    if(args[2].equalsIgnoreCase("templates")) {
                        if(args[3].equalsIgnoreCase("Gomme")) {
                            if(CompassUtil.file.exists()) {
                                CompassUtil.file.delete();
                                Actionbar.sendTitle(p, "§c§lACHTUNG", "§4§lDER SERVER WIRD NEUGELADEN!", 5, 40, 5);
                                Bukkit.reload();
                                Actionbar.sendTitle(p, "§c§lACHTUNG", "§a§lDER SERVER WURDE ERFOLGREICH NEUGELADEN!", 5, 40, 5);
                                CompassUtil.file = new File(Main.getInstance().getDataFolder(), "locations.yml");
                                if(!CompassUtil.file.getParentFile().exists()) {
                                    CompassUtil.file.getParentFile().mkdirs();
                                }
                                if(!CompassUtil.file.exists()) {
                                    try {
                                        CompassUtil.file.createNewFile();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                try {
                                    CompassUtil.cfg = YamlConfiguration.loadConfiguration(CompassUtil.file);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
                                Actionbar.sendTitle(p, "§c§lACHTUNG", "§4§lDER SERVER WIRD NEUGELADEN!", 5, 40, 5);
                                Bukkit.reload();
                                Actionbar.sendTitle(p, "§c§lACHTUNG", "§a§lDER SERVER WURDE ERFOLGREICH NEUGELADEN!", 5, 40, 5);
                                Main.getCompassUtil().save("§6§lGommunity", Material.SKULL_ITEM, 2, p.getLocation());
                                Main.getCompassUtil().save("§a§lSpawn", Material.MAGMA_CREAM, 4, p.getLocation());
                                Main.getCompassUtil().save("§6§lPremium-Lounge", Material.GOLDEN_APPLE, 6, p.getLocation());
                                Main.getCompassUtil().save("§e§lSkyWars", Material.GRASS, 10, p.getLocation());
                                Main.getCompassUtil().save("§f§lBedWars", Material.BED, 11, p.getLocation());
                                Main.getCompassUtil().save("§b§lCores", Material.BEACON, 12, p.getLocation());
                                Main.getCompassUtil().save("§e§lCityBuild", Material.WORKBENCH, 13, p.getLocation());
                                Main.getCompassUtil().save("§c§lJumpLeague", Material.DIAMOND_BOOTS, 14, p.getLocation());
                                Main.getCompassUtil().save("§4§lTTT", Material.STICK, 15, p.getLocation());
                                Main.getCompassUtil().save("§e§lSpeedUHC", Material.GOLDEN_APPLE, 16, p.getLocation());
                                Main.getCompassUtil().save("§5§lEnderGames", Material.EYE_OF_ENDER, 19, p.getLocation());
                                Main.getCompassUtil().save("§3§lGunGame", Material.WOOD_AXE, 20, p.getLocation());
                                Main.getCompassUtil().save("§d§lFFA Hardcore", Material.DIAMOND_CHESTPLATE, 21, p.getLocation());
                                Main.getCompassUtil().save("§6§lCookies", Material.COOKIE, 22, p.getLocation());
                                Main.getCompassUtil().save("§9§lGame 1vs1", Material.GOLD_HELMET, 23, p.getLocation());
                                Main.getCompassUtil().save("§9§lKit 1vs1", Material.DIAMOND_SWORD, 24, p.getLocation());
                                Main.getCompassUtil().save("§b§lMasterBuilders", Material.IRON_PICKAXE, 25, p.getLocation());
                                Main.getCompassUtil().save("§a§lSurvivalGames", Material.IRON_SWORD, 31, p.getLocation());
                                Main.getCompassUtil().save("§a§lTraining", Material.ARMOR_STAND, 33, p.getLocation());
                                Actionbar.sendTitle(p, "§c§lACHTUNG", "§4§lDER SERVER WIRD NEUGELADEN!", 5, 40, 5);
                                Bukkit.reload();
                                Actionbar.sendTitle(p, "§c§lACHTUNG", "§a§lDER SERVER WURDE ERFOLGREICH NEUGELADEN!", 5, 40, 5);
                                p.sendMessage("");
                                p.sendMessage(Main.getInstance().prefix + "§7Dein §cNavigator §7ist nun der gleiche wie auf GommeHD.net");
                                p.sendMessage(Main.getInstance().prefix + "§7Du musst jedoch noch die Positionen verändern.");
                                p.sendMessage(Main.getInstance().prefix + "§7Dies kannst du in der Config tun.");
                                p.sendMessage(Main.getInstance().prefix + "§7Deine aktuelle Position bekommst du mit /lobby pos");
                                p.sendMessage(Main.getInstance().prefix + "§7Falls du dabei §cHilfe §7brauchst, schaue dir unser Tutorial \n" + Main.getInstance().prefix +  "Video an, oder melde dich im Support!");
                                p.sendMessage("");
                                p.sendMessage(Main.getInstance().prefix + "§7Tutorial: §cyoutube.com/TutorialVIDEOLobbySystem");
                                p.sendMessage(Main.getInstance().prefix + "§7Support: §chttps://your-plugin.eu/support");
                                p.sendMessage("");

                            }
                        }
                    } else {
                        p.sendMessage(Main.getInstance().prefix + "§cNutze: /lobbysystem setup navigator <templates> <Gomme>");
                    }
                }
            }
            if(args.length == 5) {
                if(args[1].equalsIgnoreCase("navigator")) {
                    if (args[2].equalsIgnoreCase("templates")) {

                    } else {
                        String name = args[2];
                        Material material = null;
                        int slot = 0;
                        try {
                            material = Material.valueOf(args[3].toUpperCase());
                        } catch (Exception e) {
                            p.sendMessage(Main.getInstance().prefix + "§c" + args[3].toUpperCase() + " §7ist kein gültiges Material!");
                            p.sendMessage(Main.getInstance().prefix + "§7Eine Liste aller Namen findest du hier: https://www.minecraftinfo.com/idnamelist.htm");
                            return true;
                        }
                        try {
                            slot = Integer.parseInt(args[4]);
                        } catch (Exception e) {
                            p.sendMessage(Main.getInstance().prefix + "§7Der §cSlot §7muss eine Zahl sein!");
                            return true;
                        }
                        Main.getCompassUtil().save(name.replace("&", "§"), material, slot, p.getLocation());
                        p.sendMessage("Location gesetzt!");
                    }
                }
            }
        } else {
            p.sendMessage(Main.getInstance().noperm);
        }
        return false;
    }
    private void setNoAI(Villager villager) {
        EntityVillager entityVillager = ((CraftVillager)villager).getHandle();
        NBTTagCompound tag = entityVillager.getNBTTag();
        if(tag == null) {
            tag = new NBTTagCompound();
            entityVillager.c(tag);
            tag.setInt("NoAI", 1);
            entityVillager.f(tag);
        }
    }

    private void setNoAIWitch(Witch witch) {
        EntityWitch entityWitch = ((CraftWitch)witch).getHandle();
        NBTTagCompound tag = entityWitch.getNBTTag();
        if(tag == null) {
            tag = new NBTTagCompound();
            entityWitch.c(tag);
            tag.setInt("NoAI", 1);
            entityWitch.f(tag);
        }
    }
}
