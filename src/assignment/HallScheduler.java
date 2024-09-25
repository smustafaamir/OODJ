/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HallScheduler { // Class definition: OOP principle
    private String thefile; /* Encapsulation: private fields 
                             restrict direct access, promoting data hiding.*/
    private List<Halls> allHalls;

    public HallScheduler(String thefile) { // Constructor: OOP principle
        this.thefile = thefile;
        this.allHalls = loadAllHalls(); // Method call: OOP principle
    }

    private List<Halls> loadAllHalls() {  // Method: OOP principle
        List<Halls> halls = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(thefile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4) {
                    halls.add(new Halls(parts[0], parts[1], 
                    Integer.parseInt(parts[2]),
                      Double.parseDouble(parts[3])));
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return halls;
    }

    public List<Halls> filterHalls(String filterType, int minCapacity) { // Method: OOP principle
        List<Halls> filteredHalls = new ArrayList<>();
        for (Halls hall : allHalls) {
            boolean typeMatch = filterType == null || filterType.isEmpty() 
                    || hall.getHallType().equalsIgnoreCase(filterType);
            boolean capacityMatch = hall.getCapacity() >= minCapacity;
            if (typeMatch && capacityMatch) {
                filteredHalls.add(hall);
            }
        }
        return filteredHalls;
    }
}
