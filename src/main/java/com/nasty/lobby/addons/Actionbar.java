package com.nasty.lobby.addons;

import net.minecraft.server.v1_8_R3.*;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Actionbar {
    public static void sendActionBar(Player p, String msg) {
        PlayerConnection connection = (((CraftPlayer)p).getHandle()).playerConnection;
        IChatBaseComponent chat = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + msg + "\"}");
        PacketPlayOutChat packetPlayOutChat = new PacketPlayOutChat(chat, (byte)2);
        connection.sendPacket((Packet)packetPlayOutChat);
    }

    public static void sendTitle(Player p, String title, String subtitle, int fadein, int stay, int fadeout) {
        PlayerConnection connection = (((CraftPlayer)p).getHandle()).playerConnection;
        IChatBaseComponent Ititle = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + title + "\"}");
        IChatBaseComponent Isub = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + subtitle + "\"}");
        PacketPlayOutTitle titletime = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, Ititle, fadein, stay, fadeout);
        PacketPlayOutTitle subtitletime = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, Isub);
        PacketPlayOutTitle titlepacket = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, Ititle);
        PacketPlayOutTitle subPacket = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, Isub);
        connection.sendPacket((Packet)titletime);
        connection.sendPacket((Packet)subtitletime);
        connection.sendPacket((Packet)titlepacket);
        connection.sendPacket((Packet)subPacket);
    }
}
