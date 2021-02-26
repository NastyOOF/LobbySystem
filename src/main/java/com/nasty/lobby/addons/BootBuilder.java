package com.nasty.lobby.addons;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;


public class BootBuilder {

    public static ItemStack createBoot(String name, Color color) {
        ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta imeta = (LeatherArmorMeta) item.getItemMeta();
        imeta.setDisplayName(name);
        imeta.setColor(color);
        item.setItemMeta((ItemMeta) imeta);
        return item;
    }
}
