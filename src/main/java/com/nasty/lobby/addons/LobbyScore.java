package com.nasty.lobby.addons;

import net.minecraft.server.v1_8_R3.*;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class LobbyScore {

    public static void sendScoreboard(Player p) {
        Scoreboard board = new Scoreboard();
        ScoreboardObjective obj = board.registerObjective("§f§lYOUR-PLUGIN", IScoreboardCriteria.b);
        PacketPlayOutScoreboardObjective removepacket = new PacketPlayOutScoreboardObjective(obj, 1);
        sendPacket(p, removepacket);
        PacketPlayOutScoreboardObjective createpacket = new PacketPlayOutScoreboardObjective(obj, 0);
        sendPacket(p, createpacket);
        PacketPlayOutScoreboardDisplayObjective display = new PacketPlayOutScoreboardDisplayObjective(1, obj);
        sendPacket(p, display);
        ScoreboardScore s1 = new ScoreboardScore(board, obj, " ");
        s1.setScore(12);

        ScoreboardScore s2 = new ScoreboardScore(board, obj, "§fCoins:");
        s2.setScore(11);
        ScoreboardScore s3 = new ScoreboardScore(board, obj, "§6" + CoinsAPI.getCoins(p.getUniqueId().toString()));
        s3.setScore(10);

        ScoreboardScore s4 = new ScoreboardScore(board, obj, "  ");
        s4.setScore(9);

        ScoreboardScore s5 = new ScoreboardScore(board, obj, "§fDein Rang:");
        s5.setScore(8);
        ScoreboardScore s6 = new ScoreboardScore(board, obj, "§c" + "Admin");
        s6.setScore(7);


        ScoreboardScore s7 = new ScoreboardScore(board, obj, "   ");
        s7.setScore(6);

        ScoreboardScore s8 = new ScoreboardScore(board, obj, "§fTwitter");
        s8.setScore(5);
        ScoreboardScore s9 = new ScoreboardScore(board, obj, "§b" + "@YourPluginEU");
        s9.setScore(4);

      //  ScoreboardScore s10 = new ScoreboardScore(board, obj, "    ");
      //  s10.setScore(3);

     //   ScoreboardScore s11 = new ScoreboardScore(board, obj, "§fYoutube:");
     //   s11.setScore(2);
     //   ScoreboardScore s12 = new ScoreboardScore(board, obj, "§aYour-Plugin");
     //   s12.setScore(1);


        PacketPlayOutScoreboardScore ps1 = new PacketPlayOutScoreboardScore(s1);
        PacketPlayOutScoreboardScore ps2 = new PacketPlayOutScoreboardScore(s2);
        PacketPlayOutScoreboardScore ps3 = new PacketPlayOutScoreboardScore(s3);
        PacketPlayOutScoreboardScore ps4 = new PacketPlayOutScoreboardScore(s4);
        PacketPlayOutScoreboardScore ps5 = new PacketPlayOutScoreboardScore(s5);
        PacketPlayOutScoreboardScore ps6 = new PacketPlayOutScoreboardScore(s6);
        PacketPlayOutScoreboardScore ps7 = new PacketPlayOutScoreboardScore(s7);
        PacketPlayOutScoreboardScore ps8 = new PacketPlayOutScoreboardScore(s8);
        PacketPlayOutScoreboardScore ps9 = new PacketPlayOutScoreboardScore(s9);
     //   PacketPlayOutScoreboardScore ps10 = new PacketPlayOutScoreboardScore(s10);
     //   PacketPlayOutScoreboardScore ps11 = new PacketPlayOutScoreboardScore(s11);
    //    PacketPlayOutScoreboardScore ps12 = new PacketPlayOutScoreboardScore(s12);

        sendPacket(p, ps1);
        sendPacket(p, ps2);
        sendPacket(p, ps3);
        sendPacket(p, ps4);
        sendPacket(p, ps5);
        sendPacket(p, ps6);
        sendPacket(p, ps7);
        sendPacket(p, ps8);
        sendPacket(p, ps9);
    //    sendPacket(p, ps10);
     //   sendPacket(p, ps11);
     //   sendPacket(p, ps12);

    }

    public static void sendPacket(Player p, Packet<?> packet) {
        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
    }
}
