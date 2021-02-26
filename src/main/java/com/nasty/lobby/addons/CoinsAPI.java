package com.nasty.lobby.addons;

import com.nasty.lobby.database.MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CoinsAPI {

    public static int getCoins(String uuid) {
        try {
            PreparedStatement preparedStatement = MySQL.con.prepareStatement("SELECT * FROM coinsapi WHERE uuid = ?");
            preparedStatement.setString(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getInt("coins");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;

    }

    public static int getTickets(String uuid) {
        try {
            PreparedStatement preparedStatement = MySQL.con.prepareStatement("SELECT * FROM coinsapi WHERE uuid = ?");
            preparedStatement.setString(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getInt("tickets");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;

    }

    public static void setCoins(String uuid, int coins) {
        if(getCoins(uuid) == -1) {
            try {
                PreparedStatement preparedStatement = MySQL.con.prepareStatement("INSERT INTO coinsapi (uuid,coins) VALUES (?,?)");
                preparedStatement.setString(1, uuid);
                preparedStatement.setInt(2, coins);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                PreparedStatement preparedStatement = MySQL.con.prepareStatement("UPDATE coinsapi SET coins = ? WHERE uuid = ?");
                preparedStatement.setString(2, uuid);
                preparedStatement.setInt(1, coins);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void setTickets(String uuid, int tickets) {
        if(getCoins(uuid) == -1) {
            try {
                PreparedStatement preparedStatement = MySQL.con.prepareStatement("INSERT INTO coinsapi (uuid,tickets) VALUES (?,?)");
                preparedStatement.setString(1, uuid);
                preparedStatement.setInt(2, tickets);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                PreparedStatement preparedStatement = MySQL.con.prepareStatement("UPDATE coinsapi SET tickets = ? WHERE uuid = ?");
                preparedStatement.setString(2, uuid);
                preparedStatement.setInt(1, tickets);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void resetCoins(String uuid) {
        if(getCoins(uuid) == -1) {
            try {
                PreparedStatement preparedStatement = MySQL.con.prepareStatement("INSERT INTO coinsapi (uuid,coins) VALUES (?,?)");
                preparedStatement.setString(1, uuid);
                preparedStatement.setInt(2, 0);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                PreparedStatement preparedStatement = MySQL.con.prepareStatement("UPDATE coinsapi SET coins = ? WHERE uuid = ?");
                preparedStatement.setString(2, uuid);
                preparedStatement.setInt(1, 0);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addCoins(String uuid, int coins) {
        int oldcoins = getCoins(uuid);
        int newcoins = coins + oldcoins;
        setCoins(uuid, newcoins);

    }

    public static void addTickets(String uuid, int tickets) {
        int oldcoins = getTickets(uuid);
        int newcoins = tickets + oldcoins;
        setTickets(uuid, newcoins);

    }
    public static void removeCoins(String uuid, int coins) {
        int oldcoins = getCoins(uuid);
        int newcoins = oldcoins - coins;
        setCoins(uuid, newcoins);
    }

    public static void removeTickets(String uuid, int tickets) {
        int oldcoins = getTickets(uuid);
        int newcoins = oldcoins - tickets;
        setTickets(uuid, newcoins);
    }

    public boolean isExisting(String uuid) {
        try {
            ResultSet resultSet = MySQL.getResult("SELECT * FROM coinsapi WHERE uuid='" + uuid + "'");
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void create(String uuid) {
        MySQL.update("INSERT INTO coinsapi(uuid, coins, tickets) VALUES('" + uuid + "', '" + 0 + "', '" + 0 + "')");
    }
}