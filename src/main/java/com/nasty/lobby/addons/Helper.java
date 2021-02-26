package com.nasty.lobby.addons;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import com.nasty.lobby.config.ShopConfigManager;
import com.nasty.lobby.gadgets.HutInventory;
import org.apache.commons.codec.binary.Base64;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class Helper {
    private static final Base64 base64 = new Base64();

    public static void setHead(Player p, String name, String lore){

        @SuppressWarnings("deprecation")
        ItemStack item = new ItemStack (397, 1, (short) 3);
        SkullMeta meta = (SkullMeta)item.getItemMeta();
        meta.setDisplayName("§7" + name);
        meta.setOwner(name);
        ArrayList<String> text = new ArrayList<>();
        text.add("");
        text.add(lore);
        meta.setLore(text);
        item.setItemMeta(meta);


        p.getInventory().setHelmet(item);
    }

    public static ItemStack setHeadInv(String name, String lore){

        @SuppressWarnings("deprecation")
        ItemStack item = new ItemStack (397, 1, (short) 3);
        SkullMeta meta = (SkullMeta)item.getItemMeta();
        meta.setDisplayName("§7" + name);
        meta.setOwner(name);
        ArrayList<String> text = new ArrayList<>();
        text.add("");
        text.add(lore);
        meta.setLore(text);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack setHeadInvCustom(String title, String name, String lore){

        @SuppressWarnings("deprecation")
        ItemStack item = new ItemStack (397, 1, (short) 3);
        SkullMeta meta = (SkullMeta)item.getItemMeta();
        meta.setDisplayName(title);
        meta.setOwner(name);
        ArrayList<String> text = new ArrayList<>();
        text.add("");
        text.add(lore);
        meta.setLore(text);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack setHeadShop(String title, String name, String coins, String category, String besitz){

        @SuppressWarnings("deprecation")
        ItemStack item = new ItemStack (397, 1, (short) 3);
        SkullMeta meta = (SkullMeta)item.getItemMeta();
        meta.setDisplayName("§7" + title);
        meta.setOwner(name);
        ArrayList<String> text = new ArrayList<>();
        text.add("");
        text.add("§7Preis: §e" + coins + " Coins");
        text.add("§7Kategorie: §e" + category + "");
        text.add("");
        text.add(besitz);
        meta.setLore(text);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack setHead(String name){

        @SuppressWarnings("deprecation")
        ItemStack item = new ItemStack (397, 1, (short) 3);
        SkullMeta meta = (SkullMeta)item.getItemMeta();
        meta.setDisplayName("§7" + name);
        meta.setOwner(name);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack setBlockShop(String title, Material material, String coins, String category, String besitz){

        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§7" + title);
        ArrayList<String> text = new ArrayList<>();
        text.add("");
        text.add("§7Preis: §e" + coins + " Coins");
        text.add("§7Kategorie: §e" + category + "");
        text.add("");
        text.add(besitz);
        meta.setLore(text);
        item.setItemMeta(meta);

        return item;
    }



    public static void setBlock(Player p, Material material, String name){

        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§7" +name);
        item.setItemMeta(meta);

        p.getInventory().setHelmet(item);

    }

    public static ItemStack setBlockInv(Material material, String name){

        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§7" +name);
        item.setItemMeta(meta);

        return item;

    }

    public static ItemStack setPlaceHolder(){

        ItemStack placeholder = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
        ItemMeta placeholder1 = placeholder.getItemMeta();
        placeholder1.setDisplayName(" ");
        placeholder.setItemMeta(placeholder1);
        return placeholder;
    }

    public static ItemStack setLeft() {
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        PropertyMap propertyMap = profile.getProperties();
        if (propertyMap == null) {
            throw new IllegalStateException("Profile doesn't contain a property map");
        }
        byte[] encodedData = base64.encode(String.format("{textures:{SKIN:{url:\"%s\"}}}", "http://textures.minecraft.net/texture/bb0f6e8af46ac6faf88914191ab66f261d6726a7999c637cf2e4159fe1fc477").getBytes());
        propertyMap.put("textures", new Property("textures", new String(encodedData)));
        ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        ItemMeta headMeta = head.getItemMeta();
        headMeta.setDisplayName("§a<< §7Vorherige Seite");
        ArrayList<String> text = new ArrayList<>();
      //  text.add("");
      //  text.add("§cKlicke um zum Hauptmenü zu kommen");
      //  headMeta.setLore(text);
        Class<?> headMetaClass = headMeta.getClass();
        Reflections.getField(headMetaClass, "profile", GameProfile.class).set(headMeta, profile);
        head.setItemMeta(headMeta);
        return head;
    }

    public static ItemStack setRight() {
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        PropertyMap propertyMap = profile.getProperties();
        if (propertyMap == null) {
            throw new IllegalStateException("Profile doesn't contain a property map");
        }
        byte[] encodedData = base64.encode(String.format("{textures:{SKIN:{url:\"%s\"}}}", "http://textures.minecraft.net/texture/f2f3a2dfce0c3dab7ee10db385e5229f1a39534a8ba2646178e37c4fa93b").getBytes());
        propertyMap.put("textures", new Property("textures", new String(encodedData)));
        ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        ItemMeta headMeta = head.getItemMeta();
        headMeta.setDisplayName("§7Nächste Seite §a>>");
        ArrayList<String> text = new ArrayList<>();
     //   text.add("");
     //   text.add("§cKlicke um zum Hauptmenü zu kommen");
     //   headMeta.setLore(text);
        Class<?> headMetaClass = headMeta.getClass();
        Reflections.getField(headMetaClass, "profile", GameProfile.class).set(headMeta, profile);
        head.setItemMeta(headMeta);
        return head;
    }

    public static void saveShop() {
        try {
            ShopConfigManager.config.save(ShopConfigManager.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
