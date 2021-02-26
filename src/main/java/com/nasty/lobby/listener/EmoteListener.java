package com.nasty.lobby.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class EmoteListener implements Listener {

    @EventHandler
    public void onChat(PlayerChatEvent e) {
        String message = e.getMessage();
        message = message.replaceAll("<3", "❤");
        message = message.replaceAll(":heart:", "❤");
        message = message.replaceAll(":star:", "★");
        message = message.replaceAll(":peace:", "✌");
        message = message.replaceAll(":no:", "✖");
        message = message.replaceAll(":yes:", "✔");
        e.setMessage(message);
    }


}
