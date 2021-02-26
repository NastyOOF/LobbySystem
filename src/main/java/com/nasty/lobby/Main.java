package com.nasty.lobby;


import com.nasty.lobby.addons.CompassUtil;
import com.nasty.lobby.addons.RewardManager;
import com.nasty.lobby.prefixsystem.ChatEvent;
import com.nasty.lobby.commands.*;
import com.nasty.lobby.config.ConfigHandler;
import com.nasty.lobby.config.ShopConfigManager;
import com.nasty.lobby.database.MySQL;
import com.nasty.lobby.gadgets.*;
import com.nasty.lobby.gadgets.boots.JetpackBoots;
import com.nasty.lobby.gadgets.boots.LoveBoots;
import com.nasty.lobby.gadgets.boots.MusicBoots;
import com.nasty.lobby.gadgets.boots.SpeedBoots;
import com.nasty.lobby.gadgets.gadget.Enterhaken;
import com.nasty.lobby.listener.*;
import com.nasty.lobby.lottery.InLotteryInventory;
import com.nasty.lobby.lottery.LotteryInventory;
import com.nasty.lobby.prefixsystem.TabList;
import org.apache.commons.io.IOUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public final class Main extends JavaPlugin {
    public String prefix;
    public String prefix1;
    public String noperm;
    public static String license;
    private static Main instance;
    private ConfigHandler configHandler;
    private ShopConfigManager ShopConfigHandler;
    public RewardManager rewardManager;
    private static CompassUtil compassUtil;
    public static Scoreboard sb;

    @Override
    public void onEnable() {
        sb = Bukkit.getScoreboardManager().getNewScoreboard();
        setInstance(this);
        setConfigHandler(new ConfigHandler());
        getConfigHandler().setup();

        setShopConfigHandler(new ShopConfigManager());
        getShopConfigHandler().setup();

        this.rewardManager = new RewardManager(this);
        prefix1 = getConfig().getString("Prefix.Prefix").replace("&", "§");
        noperm = prefix + getConfig().getString("Messages.NoPermission").replace("&", "§");;
        prefix = prefix1 + " ";

        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
        Bukkit.getPluginManager().registerEvents(new EmoteListener(), this);
        Bukkit.getPluginManager().registerEvents(new AntiBuildListener(), this);
        Bukkit.getPluginManager().registerEvents(new VillagerListener(), this);
        Bukkit.getPluginManager().registerEvents(new CompassListener(), this);
        Bukkit.getPluginManager().registerEvents(new HideListener(), this);
        Bukkit.getPluginManager().registerEvents(new GadgetShopListener(), this);

        Bukkit.getPluginManager().registerEvents(new MainInventory(), this);
        Bukkit.getPluginManager().registerEvents(new HutInventory(), this);
        Bukkit.getPluginManager().registerEvents(new BootsInventory(), this);
        Bukkit.getPluginManager().registerEvents(new PetsInventory(), this);
        Bukkit.getPluginManager().registerEvents(new GadgetsInventory(), this);

        Bukkit.getPluginManager().registerEvents(new LoveBoots(), this);
        Bukkit.getPluginManager().registerEvents(new MusicBoots(), this);
        Bukkit.getPluginManager().registerEvents(new SpeedBoots(), this);
        Bukkit.getPluginManager().registerEvents(new JetpackBoots(), this);

        Bukkit.getPluginManager().registerEvents(new Enterhaken(), this);

        Bukkit.getPluginManager().registerEvents(new LotteryInventory(), this);
        Bukkit.getPluginManager().registerEvents(new InLotteryInventory(), this);

        Bukkit.getPluginManager().registerEvents(new ChatEvent(), this);

        compassUtil  = new CompassUtil(this);

        this.getCommand("coins").setExecutor(new CoinsCMD());
        this.getCommand("build").setExecutor(new BuildCMD());
        this.getCommand("cc").setExecutor(new ClearCMD());
        this.getCommand("lobbysystem").setExecutor(new SetupCMD());

        TabList.setTeam();

        checkLicense();
    }

    @Override
    public void onDisable() {
        if (MySQL.isConnected()) {
            MySQL.disonnect();
        }
    }

    public static Main getInstance() {
        return instance;
    }

    public static CompassUtil getCompassUtil() {
        return compassUtil;
    }

    private static void setInstance(Main instance) {
        Main.instance = instance;
    }

    private ConfigHandler getConfigHandler() {
        return configHandler;
    }

    public void setConfigHandler(ConfigHandler config) {
        this.configHandler = config;
    }


    private ShopConfigManager getShopConfigHandler() {
        return ShopConfigHandler;
    }

    public void setShopConfigHandler(ShopConfigManager config) {
        this.ShopConfigHandler = config;
    }


    private static void check(URL url) throws IOException {
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder(128000);
        try {
            reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            int count;
            char[] data = new char[5000];
            while ((count = reader.read(data)) != -1) {
                builder.append(data, 0, count);
            }
        }finally {
            IOUtils.closeQuietly(reader);
        }
        license = builder.toString();


    }

    public void checkLicense() {
        try {
            check(new URL("http://159.69.193.12/api/license/check/check.php?license=" + ConfigHandler.config.getString("LICENSE.key")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(ConfigHandler.config.getString("LICENSE.key").equals("yourkey")) {
            Bukkit.getConsoleSender().sendMessage("§7[§cLICENSE-SERVER§7] §cBitte trage deinen Lizenzschluessel in die Config ein, um das Plugin zu benutzen!");
            Bukkit.getConsoleSender().sendMessage("§7[§cLICENSE-SERVER§7] §cStarte danach das Plugin einmal neu!");
            Bukkit.getPluginManager().disablePlugin(this);
        } else {
            String ip = null;
            try(final DatagramSocket socket = new DatagramSocket()){
                socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
                ip = socket.getLocalAddress().getHostAddress();
            } catch (SocketException | UnknownHostException e) {
                e.printStackTrace();
            }
            Bukkit.getConsoleSender().sendMessage("§7[§cLICENSE-SERVER§7] §cDer Lizenzschluessel wird ueberprueft...");
            if (license.contains("Lizenz ist gültig<br>1<br>" + ip)) {
                Bukkit.getConsoleSender().sendMessage(" ");
                Bukkit.getConsoleSender().sendMessage("§7> §aLobbySystem §7- §aBukkit §7- §aby Your-Plugin.eu §7| §aWebsite: https://your-plugin.eu");
                Bukkit.getConsoleSender().sendMessage("§7> §aVersion: 1.0-SNAPSHOT");
                Bukkit.getConsoleSender().sendMessage(" ");
                MySQL.connect();
                MySQL.update("CREATE TABLE IF NOT EXISTS coinsapi (uuid VARCHAR(100), coins INT(16), tickets INT(16))");
            } else {
                Bukkit.getConsoleSender().sendMessage("§7[§cLICENSE-SERVER§7] §cDer Lizenzschluessel wurde noch nicht registriert, oder wurde bereits auf einer anderen IP-Adresse genutzt!");
                Bukkit.getConsoleSender().sendMessage("§7[§cLICENSE-SERVER§7] §cFalls dies ein Fehler ist, melde dich bitte auf unserem Discord Server!");
                Bukkit.getConsoleSender().sendMessage("§7[§cLICENSE-SERVER§7] §c> Discord: DISCORDLINK");
                Bukkit.getConsoleSender().sendMessage("§7[§cLICENSE-SERVER§7] §cDie Lizenz kannst du hier Registrieren: https://cp.your-plugin.eu");
                Bukkit.getPluginManager().disablePlugin(this);
                return;
            }
        }
    }

}