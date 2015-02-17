package com.wine.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WineTableGateway {
    
    private Connection mConnection;
    
        
        private  static final String TABLE_NAME = "wine";
        private  static final String COLUMN_ID = "id";
        private  static final String COLUMN_WINE = "wine";       
        private  static final String COLUMN_DESCRIPTION = "description";          
        private  static final String COLUMN_YEAR = "year";
        private  static final String COLUMN_TEMPERATURE = "temperature";       
        private  static final String COLUMN_TYPE = "type";       
                
    public WineTableGateway(Connection connection){
        mConnection = connection;
    }
    
    public int insertWine(String w, String d, int y, double t, String ty, int numRowsAffected) throws SQLException {
    String query;
    PreparedStatement stmt;
    int numRowAffected;
    int id = -1;
    
    query = "INSERT INTO " + TABLE_NAME + " (" +
            COLUMN_WINE + ", " +
            COLUMN_DESCRIPTION + ", " +
            COLUMN_YEAR + ", " +
            COLUMN_TEMPERATURE  + ", " +
            COLUMN_TYPE +
            ") VALUES (? ,? ,? ,? ,?)";
    
            stmt = mConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, w);
            stmt.setString(2, d);
            stmt.setInt(3, y);
            stmt.setDouble(4, t);
            stmt.setString(5, ty);
            
            numRowAffected = stmt.executeUpdate();
            if(numRowsAffected == 1){
                
                ResultSet keys = stmt.getGeneratedKeys();
                keys.next();
                
                id = keys.getInt(1);
            }
            
            return id;
        }
            
    public boolean deleteWine (int id) throws SQLException{
        String query;
        PreparedStatement stmt;
        int numRowsAffected;
        
        query = "DELETE FROM" + TABLE_NAME + "WHERE" + COLUMN_ID + " = ?";
        
        stmt = mConnection.prepareStatement(query);
        stmt.setInt(1 , id);
        
        numRowsAffected = stmt.executeUpdate();
        
        return (numRowsAffected == 1);
        
    }
            
    
            
    public List<Wine> getWines() throws SQLException {
          String query;
          Statement stmt;
          ResultSet rs;
          List<Wine> wines;
          
          String wine, description, type;
          int id, year;
          double temperature;
          
          Wine w; 
          
          query = "SELECT * FORM" + TABLE_NAME;
          stmt = this.mConnection.createStatement();
          rs = stmt.executeQuery(query);
          
          wines = new ArrayList<Wine>();
          while (rs.next()){
              id = rs.getInt(COLUMN_ID);
              wine = rs.getString(COLUMN_WINE);
              description = rs.getString(COLUMN_DESCRIPTION);
              year = rs.getInt(COLUMN_YEAR);
              temperature = rs.getDouble(COLUMN_TEMPERATURE);
              type = rs.getString(COLUMN_TYPE);
              
              w = new Wine(id, wine, description, year, temperature, type);
              wines.add(w);
         
          }
           
          return wines;
    }

   
    
           
}
          
          
    
