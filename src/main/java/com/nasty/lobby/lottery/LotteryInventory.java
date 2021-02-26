package com.nasty.lobby.lottery;

import com.nasty.lobby.Main;
import com.nasty.lobby.addons.CoinsAPI;
import com.nasty.lobby.addons.ItemBuilder;
import com.nasty.lobby.addons.LobbyScore;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.Random;

public class LotteryInventory implements Listener {
    public static Inventory inv_lose = Bukkit.createInventory(null, 45, "§cWähle 5 Kisten aus");
    public static Inventory inv = Bukkit.createInventory(null, 27, "§aLotterie übersicht");

    public static int generateRandomIntIntRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    



    @EventHandler
    public void onLotteryClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        try {
            if (e.getClickedBlock().getType().equals(Material.ENDER_CHEST)) {
                e.setCancelled(true);

                ItemStack lose = new ItemBuilder(Material.EMPTY_MAP).setName("§eEinlösen").addLoreLine("").addLoreLine("§aKlicke, um das Ticket einzulösen").toItemStack();


                ItemStack lose_buy = new ItemBuilder(Material.GOLD_INGOT).setName("§aNeues Ticket kaufen").addLoreLine("").addLoreLine("§e1.000 Coins").toItemStack();

                inv.clear();
                checkTickets(p);

                inv.setItem(22, lose_buy);
                p.openInventory(inv);
                p.playSound(p.getLocation(), Sound.CLICK, 10F, 10F);
            }
        } catch (NullPointerException e1) {

        }
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        if (e.getInventory().getName().equalsIgnoreCase("§aLotterie übersicht")) {
            try {
                if (e.getCurrentItem() != null) {
                    if (e.getCurrentItem().getType() == Material.GOLD_INGOT) {
                        if (CoinsAPI.getTickets(p.getUniqueId().toString()) > 17) {
                            p.sendMessage(Main.getInstance().prefix + "§7Du hast die maximale Anzahl an §cTickets §7erreicht!");
                            p.playSound(p.getLocation(), Sound.BAT_DEATH, 10, 10);
                            return;
                        } else {
                            if (CoinsAPI.getCoins(p.getUniqueId().toString()) > 999) {
                                CoinsAPI.addTickets(p.getUniqueId().toString(), 1);
                                CoinsAPI.removeCoins(p.getUniqueId().toString(), 1000);
                                LobbyScore.sendScoreboard(p);
                                ItemStack lose = new ItemBuilder(Material.EMPTY_MAP).setName("§eEinlösen").addLoreLine("").addLoreLine("§aKlicke, um das Ticket einzulösen").toItemStack();
                                ItemStack lose_buy = new ItemBuilder(Material.GOLD_INGOT).setName("§aNeues Ticket kaufen").addLoreLine("").addLoreLine("§e1.000 Coins").toItemStack();

                                if(CoinsAPI.getTickets(p.getUniqueId().toString()) == 1) {
                                    inv.setItem(0, lose);
                                    inv.setItem(22, lose_buy);
                                    p.updateInventory();
                                } else if(CoinsAPI.getTickets(p.getUniqueId().toString()) == 0) {
                                    inv.setItem(22, lose_buy);
                                    p.updateInventory();
                                } else if(CoinsAPI.getTickets(p.getUniqueId().toString()) == 2) {
                                    inv.setItem(0, lose);
                                    inv.setItem(1, lose);
                                    inv.setItem(22, lose_buy);
                                    p.updateInventory();
                                } else if(CoinsAPI.getTickets(p.getUniqueId().toString()) == 3) {
                                    inv.setItem(0, lose);
                                    inv.setItem(1, lose);
                                    inv.setItem(2, lose);
                                    inv.setItem(22, lose_buy);
                                    p.updateInventory();
                                } else if(CoinsAPI.getTickets(p.getUniqueId().toString()) == 4) {
                                    inv.setItem(0, lose);
                                    inv.setItem(1, lose);
                                    inv.setItem(2, lose);
                                    inv.setItem(3, lose);
                                    inv.setItem(22, lose_buy);
                                    p.updateInventory();
                                } else if(CoinsAPI.getTickets(p.getUniqueId().toString()) == 5) {
                                    inv.setItem(0, lose);
                                    inv.setItem(1, lose);
                                    inv.setItem(2, lose);
                                    inv.setItem(3, lose);
                                    inv.setItem(4, lose);
                                    inv.setItem(22, lose_buy);
                                    p.updateInventory();
                                } else if(CoinsAPI.getTickets(p.getUniqueId().toString()) == 6) {
                                    inv.setItem(0, lose);
                                    inv.setItem(1, lose);
                                    inv.setItem(2, lose);
                                    inv.setItem(3, lose);
                                    inv.setItem(4, lose);
                                    inv.setItem(5, lose);
                                    inv.setItem(22, lose_buy);
                                    p.updateInventory();
                                } else if(CoinsAPI.getTickets(p.getUniqueId().toString()) == 7) {
                                    inv.setItem(0, lose);
                                    inv.setItem(1, lose);
                                    inv.setItem(2, lose);
                                    inv.setItem(3, lose);
                                    inv.setItem(4, lose);
                                    inv.setItem(5, lose);
                                    inv.setItem(6, lose);
                                    inv.setItem(22, lose_buy);
                                    p.updateInventory();
                                } else if(CoinsAPI.getTickets(p.getUniqueId().toString()) == 8) {
                                    inv.setItem(0, lose);
                                    inv.setItem(1, lose);
                                    inv.setItem(2, lose);
                                    inv.setItem(3, lose);
                                    inv.setItem(4, lose);
                                    inv.setItem(5, lose);
                                    inv.setItem(6, lose);
                                    inv.setItem(7, lose);
                                    inv.setItem(22, lose_buy);
                                    p.updateInventory();
                                } else if(CoinsAPI.getTickets(p.getUniqueId().toString()) == 9) {
                                    inv.setItem(0, lose);
                                    inv.setItem(1, lose);
                                    inv.setItem(2, lose);
                                    inv.setItem(3, lose);
                                    inv.setItem(4, lose);
                                    inv.setItem(5, lose);
                                    inv.setItem(6, lose);
                                    inv.setItem(7, lose);
                                    inv.setItem(8, lose);
                                    inv.setItem(22, lose_buy);
                                    p.updateInventory();
                                } else if(CoinsAPI.getTickets(p.getUniqueId().toString()) == 10) {
                                    inv.setItem(0, lose);
                                    inv.setItem(1, lose);
                                    inv.setItem(2, lose);
                                    inv.setItem(3, lose);
                                    inv.setItem(4, lose);
                                    inv.setItem(5, lose);
                                    inv.setItem(6, lose);
                                    inv.setItem(7, lose);
                                    inv.setItem(8, lose);
                                    inv.setItem(9, lose);
                                    inv.setItem(22, lose_buy);
                                    p.updateInventory();
                                } else if(CoinsAPI.getTickets(p.getUniqueId().toString()) == 11) {
                                    inv.setItem(0, lose);
                                    inv.setItem(1, lose);
                                    inv.setItem(2, lose);
                                    inv.setItem(3, lose);
                                    inv.setItem(4, lose);
                                    inv.setItem(5, lose);
                                    inv.setItem(6, lose);
                                    inv.setItem(7, lose);
                                    inv.setItem(8, lose);
                                    inv.setItem(9, lose);
                                    inv.setItem(10, lose);
                                    inv.setItem(22, lose_buy);
                                    p.updateInventory();
                                } else if(CoinsAPI.getTickets(p.getUniqueId().toString()) == 12) {
                                    inv.setItem(0, lose);
                                    inv.setItem(1, lose);
                                    inv.setItem(2, lose);
                                    inv.setItem(3, lose);
                                    inv.setItem(4, lose);
                                    inv.setItem(5, lose);
                                    inv.setItem(6, lose);
                                    inv.setItem(7, lose);
                                    inv.setItem(8, lose);
                                    inv.setItem(9, lose);
                                    inv.setItem(10, lose);
                                    inv.setItem(11, lose);
                                    inv.setItem(22, lose_buy);
                                    p.updateInventory();
                                } else if(CoinsAPI.getTickets(p.getUniqueId().toString()) == 13) {
                                    inv.setItem(0, lose);
                                    inv.setItem(1, lose);
                                    inv.setItem(2, lose);
                                    inv.setItem(3, lose);
                                    inv.setItem(4, lose);
                                    inv.setItem(5, lose);
                                    inv.setItem(6, lose);
                                    inv.setItem(7, lose);
                                    inv.setItem(8, lose);
                                    inv.setItem(9, lose);
                                    inv.setItem(10, lose);
                                    inv.setItem(11, lose);
                                    inv.setItem(12, lose);
                                    inv.setItem(22, lose_buy);
                                    p.updateInventory();
                                } else if(CoinsAPI.getTickets(p.getUniqueId().toString()) == 14) {
                                    inv.setItem(0, lose);
                                    inv.setItem(1, lose);
                                    inv.setItem(2, lose);
                                    inv.setItem(3, lose);
                                    inv.setItem(4, lose);
                                    inv.setItem(5, lose);
                                    inv.setItem(6, lose);
                                    inv.setItem(7, lose);
                                    inv.setItem(8, lose);
                                    inv.setItem(9, lose);
                                    inv.setItem(10, lose);
                                    inv.setItem(11, lose);
                                    inv.setItem(12, lose);
                                    inv.setItem(13, lose);
                                    inv.setItem(22, lose_buy);
                                    p.updateInventory();
                                } else if(CoinsAPI.getTickets(p.getUniqueId().toString()) == 15) {
                                    inv.setItem(0, lose);
                                    inv.setItem(1, lose);
                                    inv.setItem(2, lose);
                                    inv.setItem(3, lose);
                                    inv.setItem(4, lose);
                                    inv.setItem(5, lose);
                                    inv.setItem(6, lose);
                                    inv.setItem(7, lose);
                                    inv.setItem(8, lose);
                                    inv.setItem(9, lose);
                                    inv.setItem(10, lose);
                                    inv.setItem(11, lose);
                                    inv.setItem(12, lose);
                                    inv.setItem(13, lose);
                                    inv.setItem(14, lose);
                                    inv.setItem(22, lose_buy);
                                    p.updateInventory();
                                } else if(CoinsAPI.getTickets(p.getUniqueId().toString()) == 16) {
                                    inv.setItem(0, lose);
                                    inv.setItem(1, lose);
                                    inv.setItem(2, lose);
                                    inv.setItem(3, lose);
                                    inv.setItem(4, lose);
                                    inv.setItem(5, lose);
                                    inv.setItem(6, lose);
                                    inv.setItem(7, lose);
                                    inv.setItem(8, lose);
                                    inv.setItem(9, lose);
                                    inv.setItem(10, lose);
                                    inv.setItem(11, lose);
                                    inv.setItem(12, lose);
                                    inv.setItem(13, lose);
                                    inv.setItem(14, lose);
                                    inv.setItem(15, lose);
                                    inv.setItem(22, lose_buy);
                                    p.updateInventory();
                                } else if(CoinsAPI.getTickets(p.getUniqueId().toString()) == 17) {
                                    inv.setItem(0, lose);
                                    inv.setItem(1, lose);
                                    inv.setItem(2, lose);
                                    inv.setItem(3, lose);
                                    inv.setItem(4, lose);
                                    inv.setItem(5, lose);
                                    inv.setItem(6, lose);
                                    inv.setItem(7, lose);
                                    inv.setItem(8, lose);
                                    inv.setItem(9, lose);
                                    inv.setItem(10, lose);
                                    inv.setItem(11, lose);
                                    inv.setItem(12, lose);
                                    inv.setItem(13, lose);
                                    inv.setItem(14, lose);
                                    inv.setItem(15, lose);
                                    inv.setItem(16, lose);
                                    inv.setItem(22, lose_buy);
                                    p.updateInventory();
                                } else if(CoinsAPI.getTickets(p.getUniqueId().toString()) == 18) {
                                    inv.setItem(0, lose);
                                    inv.setItem(1, lose);
                                    inv.setItem(2, lose);
                                    inv.setItem(3, lose);
                                    inv.setItem(4, lose);
                                    inv.setItem(5, lose);
                                    inv.setItem(6, lose);
                                    inv.setItem(7, lose);
                                    inv.setItem(8, lose);
                                    inv.setItem(9, lose);
                                    inv.setItem(10, lose);
                                    inv.setItem(11, lose);
                                    inv.setItem(12, lose);
                                    inv.setItem(13, lose);
                                    inv.setItem(14, lose);
                                    inv.setItem(15, lose);
                                    inv.setItem(16, lose);
                                    inv.setItem(17, lose);
                                    inv.setItem(22, lose_buy);
                                    p.updateInventory();
                                }

                            } else {
                                p.sendMessage(Main.getInstance().prefix + "§7Du hast zu wenig §cCoins§7!");
                            }
                        }
                    } else if (e.getCurrentItem().getType() == Material.EMPTY_MAP) {
                      //  CoinsAPI.removeTickets(p.getUniqueId().toString(), 1);

                        inv_lose.clear();
                        p.openInventory(inv_lose);
                        setLotteryInv(p);
                    }
                }
            } catch (NullPointerException e1) {

            }


        }
    }

    public void setLotteryInv(Player p) {
        ItemStack enderchest = new ItemBuilder(Material.ENDER_CHEST).setName("§7Klicken um zu Öffnen").toItemStack();
        for (int i = 0; i < 8; i++) {

            int time = i + 1;

            int finalI = i;
            Player finalPlayer = p;
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), new Runnable() {
                @Override
                public void run() {

                    switch (finalI) {
                        case 0:
                            if (finalPlayer.getOpenInventory() != null && p.getOpenInventory().getTitle().equals("§cWähle 5 Kisten aus")) {
                                finalPlayer.playSound(finalPlayer.getLocation(), Sound.CLICK, 1, 1);
                                inv_lose.setItem(0, enderchest);
                                inv_lose.setItem(9, enderchest);
                                inv_lose.setItem(18, enderchest);
                                inv_lose.setItem(27, enderchest);
                                inv_lose.setItem(18, enderchest);
                                inv_lose.setItem(36, enderchest);

                                inv_lose.setItem(8, enderchest);
                                inv_lose.setItem(17, enderchest);
                                inv_lose.setItem(26, enderchest);
                                inv_lose.setItem(35, enderchest);
                                inv_lose.setItem(44, enderchest);

                            } else {
                                return;
                            }
                            break;
                        case 1:
                            if (finalPlayer.getOpenInventory() != null && p.getOpenInventory().getTitle().equals("§cWähle 5 Kisten aus")) {
                                finalPlayer.playSound(finalPlayer.getLocation(), Sound.CLICK, 1, 1);
                                inv_lose.clear();
                                inv_lose.setItem(1, enderchest);
                                inv_lose.setItem(10, enderchest);
                                inv_lose.setItem(19, enderchest);
                                inv_lose.setItem(28, enderchest);
                                inv_lose.setItem(37, enderchest);

                                inv_lose.setItem(7, enderchest);
                                inv_lose.setItem(16, enderchest);
                                inv_lose.setItem(25, enderchest);
                                inv_lose.setItem(34, enderchest);
                                inv_lose.setItem(43, enderchest);




                            } else {
                                return;
                            }
                            break;
                        case 2:
                            if (finalPlayer.getOpenInventory() != null && p.getOpenInventory().getTitle().equals("§cWähle 5 Kisten aus")) {
                                finalPlayer.playSound(finalPlayer.getLocation(), Sound.CLICK, 1, 1);
                                inv_lose.clear();

                                inv_lose.setItem(2, enderchest);
                                inv_lose.setItem(11, enderchest);
                                inv_lose.setItem(20, enderchest);
                                inv_lose.setItem(29, enderchest);
                                inv_lose.setItem(38, enderchest);

                                inv_lose.setItem(6, enderchest);
                                inv_lose.setItem(15, enderchest);
                                inv_lose.setItem(24, enderchest);
                                inv_lose.setItem(33, enderchest);
                                inv_lose.setItem(42, enderchest);


                            } else {
                                return;
                            }
                            break;
                        case 3:
                            if (finalPlayer.getOpenInventory() != null && p.getOpenInventory().getTitle().equals("§cWähle 5 Kisten aus")) {
                                finalPlayer.playSound(finalPlayer.getLocation(), Sound.CLICK, 1, 1);
                                inv_lose.clear();

                                inv_lose.setItem(3, enderchest);
                                inv_lose.setItem(12, enderchest);
                                inv_lose.setItem(21, enderchest);
                                inv_lose.setItem(30, enderchest);
                                inv_lose.setItem(39, enderchest);

                                inv_lose.setItem(5, enderchest);
                                inv_lose.setItem(14, enderchest);
                                inv_lose.setItem(23, enderchest);
                                inv_lose.setItem(32, enderchest);
                                inv_lose.setItem(41, enderchest);

                            } else {
                                return;
                            }
                            break;
                        case 4:
                            if (finalPlayer.getOpenInventory() != null && p.getOpenInventory().getTitle().equals("§cWähle 5 Kisten aus")) {
                                finalPlayer.playSound(finalPlayer.getLocation(), Sound.CLICK, 1, 1);

                                inv_lose.setItem(4, enderchest);
                                inv_lose.setItem(13, enderchest);
                                inv_lose.setItem(22, enderchest);
                                inv_lose.setItem(31, enderchest);
                                inv_lose.setItem(40, enderchest);

                            } else {
                                return;
                            }
                            break;
                        case 5:
                            if (finalPlayer.getOpenInventory() != null && p.getOpenInventory().getTitle().equals("§cWähle 5 Kisten aus")) {
                                finalPlayer.playSound(finalPlayer.getLocation(), Sound.CLICK, 1, 1);

                                inv_lose.setItem(2, enderchest);
                                inv_lose.setItem(11, enderchest);
                                inv_lose.setItem(20, enderchest);
                                inv_lose.setItem(29, enderchest);
                                inv_lose.setItem(38, enderchest);

                                inv_lose.setItem(6, enderchest);
                                inv_lose.setItem(15, enderchest);
                                inv_lose.setItem(24, enderchest);
                                inv_lose.setItem(33, enderchest);
                                inv_lose.setItem(42, enderchest);


                            } else {
                                return;
                            }
                            break;
                        case 6:
                            if (finalPlayer.getOpenInventory() != null && p.getOpenInventory().getTitle().equals("§cWähle 5 Kisten aus")) {
                                finalPlayer.playSound(finalPlayer.getLocation(), Sound.CLICK, 1, 1);

                                inv_lose.setItem(1, enderchest);
                                inv_lose.setItem(10, enderchest);
                                inv_lose.setItem(19, enderchest);
                                inv_lose.setItem(28, enderchest);
                                inv_lose.setItem(37, enderchest);

                                inv_lose.setItem(7, enderchest);
                                inv_lose.setItem(16, enderchest);
                                inv_lose.setItem(25, enderchest);
                                inv_lose.setItem(34, enderchest);
                                inv_lose.setItem(43, enderchest);


                            } else {
                                return;
                            }
                            break;
                        case 7:
                            if (finalPlayer.getOpenInventory() != null && p.getOpenInventory().getTitle().equals("§cWähle 5 Kisten aus")) {
                                finalPlayer.playSound(finalPlayer.getLocation(), Sound.CLICK, 1, 1);

                                inv_lose.setItem(0, enderchest);
                                inv_lose.setItem(9, enderchest);
                                inv_lose.setItem(18, enderchest);
                                inv_lose.setItem(27, enderchest);
                                inv_lose.setItem(18, enderchest);
                                inv_lose.setItem(36, enderchest);

                                inv_lose.setItem(8, enderchest);
                                inv_lose.setItem(17, enderchest);
                                inv_lose.setItem(26, enderchest);
                                inv_lose.setItem(35, enderchest);
                                inv_lose.setItem(44, enderchest);

                                finalPlayer.playSound(finalPlayer.getLocation(), Sound.NOTE_PIANO, 1, 1);
                                InLotteryInventory.clickedchests.put(p.getUniqueId().toString(), 0);

                            } else {
                                return;
                            }
                            break;
                    }
                }
            }, i * 5);
        }
        CoinsAPI.removeTickets(p.getUniqueId().toString(), 1);
        checkTickets(p);
    }

    //  for(int zahl = 0; zahl < 45;zahl++) {
    //     inv_lose.setItem(zahl, enderchest);
    //  }


    public void checkTickets(Player p) {
        ItemStack lose = new ItemBuilder(Material.EMPTY_MAP).setName("§eEinlösen").addLoreLine("").addLoreLine("§aKlicke, um das Ticket einzulösen").toItemStack();
        ItemStack lose_buy = new ItemBuilder(Material.GOLD_INGOT).setName("§aNeues Ticket kaufen").addLoreLine("").addLoreLine("§e1.000 Coins").toItemStack();

        if(CoinsAPI.getTickets(p.getUniqueId().toString()) == 1) {
            inv.setItem(0, lose);
            inv.setItem(22, lose_buy);
            p.updateInventory();
        } else if(CoinsAPI.getTickets(p.getUniqueId().toString()) == 0) {
            inv.setItem(22, lose_buy);
            p.updateInventory();
        } else if(CoinsAPI.getTickets(p.getUniqueId().toString()) == 2) {
            inv.setItem(0, lose);
            inv.setItem(1, lose);
            inv.setItem(22, lose_buy);
            p.updateInventory();
        } else if(CoinsAPI.getTickets(p.getUniqueId().toString()) == 3) {
            inv.setItem(0, lose);
            inv.setItem(1, lose);
            inv.setItem(2, lose);
            inv.setItem(22, lose_buy);
            p.updateInventory();
        } else if(CoinsAPI.getTickets(p.getUniqueId().toString()) == 4) {
            inv.setItem(0, lose);
            inv.setItem(1, lose);
            inv.setItem(2, lose);
            inv.setItem(3, lose);
            inv.setItem(22, lose_buy);
            p.updateInventory();
        } else if(CoinsAPI.getTickets(p.getUniqueId().toString()) == 5) {
            inv.setItem(0, lose);
            inv.setItem(1, lose);
            inv.setItem(2, lose);
            inv.setItem(3, lose);
            inv.setItem(4, lose);
            inv.setItem(22, lose_buy);
            p.updateInventory();
        } else if(CoinsAPI.getTickets(p.getUniqueId().toString()) == 6) {
            inv.setItem(0, lose);
            inv.setItem(1, lose);
            inv.setItem(2, lose);
            inv.setItem(3, lose);
            inv.setItem(4, lose);
            inv.setItem(5, lose);
            inv.setItem(22, lose_buy);
            p.updateInventory();
        } else if(CoinsAPI.getTickets(p.getUniqueId().toString()) == 7) {
            inv.setItem(0, lose);
            inv.setItem(1, lose);
            inv.setItem(2, lose);
            inv.setItem(3, lose);
            inv.setItem(4, lose);
            inv.setItem(5, lose);
            inv.setItem(6, lose);
            inv.setItem(22, lose_buy);
            p.updateInventory();
        } else if(CoinsAPI.getTickets(p.getUniqueId().toString()) == 8) {
            inv.setItem(0, lose);
            inv.setItem(1, lose);
            inv.setItem(2, lose);
            inv.setItem(3, lose);
            inv.setItem(4, lose);
            inv.setItem(5, lose);
            inv.setItem(6, lose);
            inv.setItem(7, lose);
            inv.setItem(22, lose_buy);
            p.updateInventory();
        } else if(CoinsAPI.getTickets(p.getUniqueId().toString()) == 9) {
            inv.setItem(0, lose);
            inv.setItem(1, lose);
            inv.setItem(2, lose);
            inv.setItem(3, lose);
            inv.setItem(4, lose);
            inv.setItem(5, lose);
            inv.setItem(6, lose);
            inv.setItem(7, lose);
            inv.setItem(8, lose);
            inv.setItem(22, lose_buy);
            p.updateInventory();
        } else if(CoinsAPI.getTickets(p.getUniqueId().toString()) == 10) {
            inv.setItem(0, lose);
            inv.setItem(1, lose);
            inv.setItem(2, lose);
            inv.setItem(3, lose);
            inv.setItem(4, lose);
            inv.setItem(5, lose);
            inv.setItem(6, lose);
            inv.setItem(7, lose);
            inv.setItem(8, lose);
            inv.setItem(9, lose);
            inv.setItem(22, lose_buy);
            p.updateInventory();
        } else if(CoinsAPI.getTickets(p.getUniqueId().toString()) == 11) {
            inv.setItem(0, lose);
            inv.setItem(1, lose);
            inv.setItem(2, lose);
            inv.setItem(3, lose);
            inv.setItem(4, lose);
            inv.setItem(5, lose);
            inv.setItem(6, lose);
            inv.setItem(7, lose);
            inv.setItem(8, lose);
            inv.setItem(9, lose);
            inv.setItem(10, lose);
            inv.setItem(22, lose_buy);
            p.updateInventory();
        } else if(CoinsAPI.getTickets(p.getUniqueId().toString()) == 12) {
            inv.setItem(0, lose);
            inv.setItem(1, lose);
            inv.setItem(2, lose);
            inv.setItem(3, lose);
            inv.setItem(4, lose);
            inv.setItem(5, lose);
            inv.setItem(6, lose);
            inv.setItem(7, lose);
            inv.setItem(8, lose);
            inv.setItem(9, lose);
            inv.setItem(10, lose);
            inv.setItem(11, lose);
            inv.setItem(22, lose_buy);
            p.updateInventory();
        } else if(CoinsAPI.getTickets(p.getUniqueId().toString()) == 13) {
            inv.setItem(0, lose);
            inv.setItem(1, lose);
            inv.setItem(2, lose);
            inv.setItem(3, lose);
            inv.setItem(4, lose);
            inv.setItem(5, lose);
            inv.setItem(6, lose);
            inv.setItem(7, lose);
            inv.setItem(8, lose);
            inv.setItem(9, lose);
            inv.setItem(10, lose);
            inv.setItem(11, lose);
            inv.setItem(12, lose);
            inv.setItem(22, lose_buy);
            p.updateInventory();
        } else if(CoinsAPI.getTickets(p.getUniqueId().toString()) == 14) {
            inv.setItem(0, lose);
            inv.setItem(1, lose);
            inv.setItem(2, lose);
            inv.setItem(3, lose);
            inv.setItem(4, lose);
            inv.setItem(5, lose);
            inv.setItem(6, lose);
            inv.setItem(7, lose);
            inv.setItem(8, lose);
            inv.setItem(9, lose);
            inv.setItem(10, lose);
            inv.setItem(11, lose);
            inv.setItem(12, lose);
            inv.setItem(13, lose);
            inv.setItem(22, lose_buy);
            p.updateInventory();
        } else if(CoinsAPI.getTickets(p.getUniqueId().toString()) == 15) {
            inv.setItem(0, lose);
            inv.setItem(1, lose);
            inv.setItem(2, lose);
            inv.setItem(3, lose);
            inv.setItem(4, lose);
            inv.setItem(5, lose);
            inv.setItem(6, lose);
            inv.setItem(7, lose);
            inv.setItem(8, lose);
            inv.setItem(9, lose);
            inv.setItem(10, lose);
            inv.setItem(11, lose);
            inv.setItem(12, lose);
            inv.setItem(13, lose);
            inv.setItem(14, lose);
            inv.setItem(22, lose_buy);
            p.updateInventory();
        } else if(CoinsAPI.getTickets(p.getUniqueId().toString()) == 16) {
            inv.setItem(0, lose);
            inv.setItem(1, lose);
            inv.setItem(2, lose);
            inv.setItem(3, lose);
            inv.setItem(4, lose);
            inv.setItem(5, lose);
            inv.setItem(6, lose);
            inv.setItem(7, lose);
            inv.setItem(8, lose);
            inv.setItem(9, lose);
            inv.setItem(10, lose);
            inv.setItem(11, lose);
            inv.setItem(12, lose);
            inv.setItem(13, lose);
            inv.setItem(14, lose);
            inv.setItem(15, lose);
            inv.setItem(22, lose_buy);
            p.updateInventory();
        } else if(CoinsAPI.getTickets(p.getUniqueId().toString()) == 17) {
            inv.setItem(0, lose);
            inv.setItem(1, lose);
            inv.setItem(2, lose);
            inv.setItem(3, lose);
            inv.setItem(4, lose);
            inv.setItem(5, lose);
            inv.setItem(6, lose);
            inv.setItem(7, lose);
            inv.setItem(8, lose);
            inv.setItem(9, lose);
            inv.setItem(10, lose);
            inv.setItem(11, lose);
            inv.setItem(12, lose);
            inv.setItem(13, lose);
            inv.setItem(14, lose);
            inv.setItem(15, lose);
            inv.setItem(16, lose);
            inv.setItem(22, lose_buy);
            p.updateInventory();
        } else if(CoinsAPI.getTickets(p.getUniqueId().toString()) == 18) {
            inv.setItem(0, lose);
            inv.setItem(1, lose);
            inv.setItem(2, lose);
            inv.setItem(3, lose);
            inv.setItem(4, lose);
            inv.setItem(5, lose);
            inv.setItem(6, lose);
            inv.setItem(7, lose);
            inv.setItem(8, lose);
            inv.setItem(9, lose);
            inv.setItem(10, lose);
            inv.setItem(11, lose);
            inv.setItem(12, lose);
            inv.setItem(13, lose);
            inv.setItem(14, lose);
            inv.setItem(15, lose);
            inv.setItem(16, lose);
            inv.setItem(17, lose);
            inv.setItem(22, lose_buy);
            p.updateInventory();
        }
    }
}
