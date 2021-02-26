package com.nasty.lobby.database;


import com.nasty.lobby.config.ConfigHandler;

import java.sql.*;

public class MySQL {
    public static Connection con;

    public static void connect() {
        if(!isConnected()) {
            try {
                con = DriverManager.getConnection("jdbc:mysql://" + ConfigHandler.config.getString("MySQL.host") + ":" + ConfigHandler.config.getInt("MySQL.port") + "/" + ConfigHandler.config.getString("MySQL.database"), ConfigHandler.config.getString("MySQL.username"), ConfigHandler.config.getString("MySQL.password"));
                System.out.println("[MYSQL] Die Verbindung wurde erfolgreich hergestellt!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void disonnect() {
        if(isConnected()) {
            try {
                con.close();
                System.out.println("[MYSQL] Die Verbindung wurde beendet!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static boolean isConnected() {
        return (con == null ? false : true);
    }

    public static void update(String qry) {
        try {
            PreparedStatement ps = con.prepareStatement(qry);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getResult(String qry) throws SQLException {
        try {
            PreparedStatement ps = con.prepareStatement(qry);
            return ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}