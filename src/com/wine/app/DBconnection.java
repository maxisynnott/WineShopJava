package com.wine.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    
    private static Connection sConnection;
    
    public static Connection getInstance() throws ClassNotFoundException, SQLException{
        String host, db, user, password;
        
        host = "daneel";
        db = "n00133912";
        user = "N00133912";
        password = "N00133912";
        
        if (sConnection == null || sConnection.isClosed()){
            String url = "jdbc:mysql://" + host + "/" + db;
            Class.forName ("com.mysql.jdbc.Driver");
            sConnection = DriverManager.getConnection(url, user, password);
        }
        
        return sConnection;
    }
}