package com.wine.app;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        Model model = Model.getInstance();
        int opt;
        
        do {
            System.out.println("1. Create new Wine");
            System.out.println("2. Delete existing Wine");
            System.out.println("3. Edit existing Wine");
            System.out.println("4. View all Wine");
            System.out.println("5. Exit");
            System.out.println();

            System.out.println("Enter option: ");
            String line = keyboard.nextLine();
            opt = Integer.parseInt(line);

            System.out.println("you chose option " + opt);
            switch(opt){
                case 1: {
                    System.out.println("Creating wine");
                    createWine(keyboard,model);
                    break;
                }
                case 2: {
                    System.out.println("Deleting wine");
                    deleteWine(keyboard ,model);
                    break;
                }
                case 3: {
                    System.out.println("editing wine");
                    editWine(keyboard, model);
                    break;
                }
                case 4: {
                    System.out.println("Viewing wine");
                   viewWines(model);
                   break;
                }
               
            }
            
        }
        
        while(opt != 5);
    }   
    
    private static void createWine(Scanner keyboard, Model model){
        Wine w = readWine(keyboard);
          if(model.addWine(w)){
           System.out.println("Wine added to the database");
               }
          else{
           System.out.println("Wine not added to the database"); 
               }
           System.out.println();
    } 

    private static void viewWines(Model mdl) {
         List<Wine>wines = mdl.getWines();
                System.out.println();
              if(wines.isEmpty()){
                System.out.println("There are no wines in the datatbse");
                   }
              else{
                System.out.printf("%5s %20s %20s %15s %20s\n", "Id", "Wine", "Description", "Year", "temperature", "type");
              for (Wine wr: wines){
               System.out.printf("%5s %20s %20s %15s %20s\n",
                   wr.getId(),
                   wr.getWine(),
                   wr.getDescription(),
                   wr.getYear(),
                   wr.getTemperature(),
                   wr.getType());
                            
                    }
                  }
        System.out.println();
                    
    }
    
    private static Wine readWine(Scanner keyb){
        String wine, description, type;
        int year;
        double temperature;
        String line = null;
        
        wine = getString(keyb, "Enter Wine: ");
        description = getString(keyb, "Enter Description: ");
        type = getString(keyb, "Enter Type: ");
        year = Integer.parseInt(line);
        line = getString(keyb, "Enter Year: ");
        line = getString(keyb, "Enter Temperature: ");
        temperature = Double.parseDouble(line);
        
        Wine w =
                new Wine(wine, description, year, temperature, type);
        
        
        return w;
        
    
    }
    
     private static String getString(Scanner keyboard, String prompt){
        System.out.print(prompt);
        return keyboard.nextLine();
    }

    private static void deleteWine(Scanner keyboard, Model model) {
        System.out.print("Enter the wine of the wine to delete");
             int id = Integer.parseInt(keyboard.nextLine());
          Wine w;

          w = model.findWineByid(id);
           if(w != null){
         if(model.removeWine(w)){
             System.out.println("Wine deleted");
             }
         else{
               System.out.println("wine not deleted");
              }
              }
          else{
               System.out.println("Wine not found");
              }
                    
    }

    private static void editWine(Scanner keyboard, Model model) {
        System.out.print("Enter the id of the wine to edit");
        int id = Integer.parseInt(keyboard.nextLine());
        Wine w;
        
        w = model.findWineByid(id);
        if (w != null){
            editWineDetails(keyboard, w);
            if(model.updateWine(w)){
                System.out.println("Wine update");
            }
            else{
                System.out.println("Wine not updated");
            }
        }
            else{
                    System.out.println("Wine not found");
            }
            
            }

    private static void editWineDetails(Scanner keyboard, Wine w) {
        String wine, description 
    }
   
        }

