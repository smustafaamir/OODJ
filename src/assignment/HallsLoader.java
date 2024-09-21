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

// Interface
interface Loadable {
    void load(String filename) throws IOException;
}

// Abstract class
abstract class Loader implements Loadable {
    protected List<Halls> halls = new ArrayList<>();

    public List<Halls> getHalls() {
        return halls;
    }

    // Abstract method
    public abstract void load(String filename) throws IOException;
}

// Public HallsLoader class extending Loader
public class HallsLoader extends Loader {
    @Override
    public void load(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(";");
            if (parts.length == 4) {
                String HallID = parts[0];
                String HallType = parts[1];
                int Capacity = Integer.parseInt(parts[2]);
                double BookingRate = Double.parseDouble(parts[3]);
                halls.add(new Halls(HallID, HallType, Capacity, BookingRate));
            }
        }

        reader.close();
    }

    // Method to load reservation IDs from a text file

// Method to load reservation IDs from a text file
    public List<String> loadReservationIds(String filename) throws IOException {
    List<String> reservationIds = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader(filename));
    String line;

    while ((line = reader.readLine()) != null) {
        String[] parts = line.split(";");
        if (parts.length > 4) {
            reservationIds.add(parts[4]);
        }
    }
    reader.close();
    //System.out.println("Reservation IDs loaded from file: " + reservationIds);
    return reservationIds;
    }
}

