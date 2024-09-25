/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Class responsible for managing hall data persistence
public class HallAdding {
    private String filename;

     // Method to add a new hall to the file
    public HallAdding(String filename) {
        this.filename = filename;
    }

     // Append the new hall information to the file
    public void addHall(Halls hall) throws IOException {
        String hallInfo = String.format("%s;%s;%d;%.2f%n", 
            hall.getHallID(), hall.getHallType(), hall.getCapacity(), hall.getBookingRate());
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(hallInfo);
        }
    }
    
    // Method to remove a hall from the file based on hall ID
    public void removeHall(String hallId) throws IOException {
        File inputFile = new File(filename);
        File tempFile = new File("temp_" + filename);

        /* Read from the original file and write to a temporary file,
        excluding the hall to be removed*/
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (!parts[0].equals(hallId)) {
                    writer.write(line + System.lineSeparator());
                }
            }
        }

         // Replace the original file with the updated temporary file
        if (!inputFile.delete() || !tempFile.renameTo(inputFile)) {
            throw new IOException("Could not update hall file.");
        }
    }

     // Method to update an existing hall's information in the file
    public void updateHall(Halls hall) throws IOException {
        File inputFile = new File(filename);
        File tempFile = new File("temp_" + filename);

         // Read from the original file and write to a temporary file, updating the hall information
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts[0].equals(hall.getHallID())) {
                    // Update the line with new information
                    writer.write(String.format("%s;%s;%d;%.2f%n", 
                        hall.getHallID(), hall.getHallType(), hall.getCapacity(), hall.getBookingRate()));
                } else {
                    // Write the original line
                    writer.write(line + System.lineSeparator());
                }
            }
        }

        // Replace the original file with the updated temporary file
        if (!inputFile.delete() || !tempFile.renameTo(inputFile)) {
            throw new IOException("Could not update hall file.");
        }
    }

     // Method to load all halls from the file into a list
    public List<Halls> loadHalls() throws IOException {
        List<Halls> halls = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4) {
                    halls.add(new Halls(parts[0], parts[1], Integer.parseInt(parts[2]), Double.parseDouble(parts[3])));
                }
            }
        }
        return halls;
    }
}