/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class HallsLoader {
   public static ArrayList<Halls> loadHalls(String filename) throws IOException 
   {
    ArrayList<Halls> halls = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader(filename));
    String line;
 
    while ((line = reader.readLine()) != null)
    {
      String[] parts = line.split(";");
      if (parts.length == 4) 
      {
        String HallID = parts[0];
        String HallType = parts[1];
        int Capacity = Integer.parseInt(parts[2]);
        double BookingRate = Double.parseDouble(parts[3]); 
        halls.add(new Halls(HallID, HallType, Capacity, BookingRate));
      }
    }
 
    reader.close();
    return halls;    
   }    
    
}


