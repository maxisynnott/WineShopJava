package com.wine.app;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Model {
    
    private static Model instance = null;
    
    public static Model getInstance(){
        if (instance == null){
            instance = new Model();
        }
        
        return instance;
    }
    
    List<Wine> wines;
    WineTableGateway gateway;
    
    private Model() {
        
        try {
            Connection conn = DBconnection.getInstance();
            this.gateway = new WineTableGateway(conn);
            
            this.wines = this.gateway.getWines();
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public boolean addWine (Wine w){
        boolean result = false;
        try{
        int id = this.gateway.insertWine(w.getWine(), w.getDescription(), w.getYear(), w.getType());
        if (id != -1){
            w.setId(id);
            this.wines.add(w);
            result = true;
        }
      }
       catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
    }
        return result;
    }
    
    public boolean removeWine (Wine w, boolean removed){
        boolean remove = false;
        
        try{
            remove = this.gateway.deleteWine(w.getId());
            if(remove){
                remove = this.wines.remove(w);
            }
                
            } 
        catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
             }
         return removed;
        }
    
    
    
    public List<Wine>getWines(){
      return this.wines;  
    }

    Wine findWineByid(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean removeWine(Wine w) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean updateWine(Wine w) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    
        Wine findWineByid (int id){
        Wine w = null;
        int i = 0;
        boolean found = false;
        while (i < this.wines.size() && !found){
             w = this.wines.get(i);
             if(w.getId () == id){
                found = true;
                 } else {
                       i++;

                    }
                 }
                       if(!found){
                        w = null;
              }
                    return w;
               }  {
        }
