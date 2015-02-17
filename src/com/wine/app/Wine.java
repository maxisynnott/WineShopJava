package com.wine.app;


public class Wine {
    
    private int id;
    private String wine;
    private String description;
    private int year;
    private double temperature;
    private String type;
    
   public Wine(int id, String w, String d, int y, double t, String ty){
       this.id = id;
       this.wine = w;
       this.description = d;
       this.year = y;
       this.temperature = t;
       this.type = ty;
             
   } 
   
   public Wine(String w, String d, int y, double t, String ty){
       this(-1, w, d, y, t, ty);
   }
        public int getId(){
            return id;
        }
        
        public void setId(int id){
            this.id = id;
        }
        
        public String getWine(){
            return wine; 
        }
        
        public void setWine(String wine){
            this.wine = wine;
        }
        
        public String getDescription(){
            return description; 
        }
        
        public void setDescription(String description){
            this.description = description;
        }
        
        public int getYear(){
            return year; 
        }
        
        public void setYear(int year){
            this.year = year;
        }
        
        public double getTemperature(){
            return temperature; 
        }
        
        public void setTemperature(double temperature){
            this.temperature = temperature;
        }
        
        public String getType(){
            return type; 
        }
        
        public void setType(String type){
            this.type = type;
        }
        
}
        
        