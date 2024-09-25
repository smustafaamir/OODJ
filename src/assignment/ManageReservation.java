/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManageReservation {
    private String thefile;

    public ManageReservation(String thefile) {
        this.thefile = thefile;
    }

    public List<String> loadReservationIds() {
        List<String> reservationIds = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(thefile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length > 4) {
                    reservationIds.add(parts[4]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reservationIds;
    }

    public List<Reservation> getReservationsById(String reservationId) {
        List<Reservation> reservations = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(thefile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length > 4 && parts[4].equals(reservationId)) {
                    reservations.add(new Reservation(parts[0], parts[1],
                            parts[2], parts[3], parts[4]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reservations;
    }
    
    public List<Reservation> getAllReservations() {
    List<Reservation> reservations = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(thefile))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(";");
            if (parts.length > 4) {
                reservations.add(new Reservation(parts[0], parts[1], parts[2],
                        parts[3], parts[4]));
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return reservations;
}

public void updateReservation(Reservation reservation) {
    File inputFile = new File(thefile);
    File tempFile = new File("temp_" + thefile);
    try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
         BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
        String line;
        boolean found = false;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(";");
            if (parts.length > 4 && parts[4].equals(reservation.getReservationID())) {
                writer.write(String.format("%s;%s;%s;%s;%s%n",
                        reservation.getHallID(),
                        reservation.getHallType(),
                        reservation.getStartTime(),
                        reservation.getEndTime(),
                        reservation.getReservationID()));
                found = true;
            } else {
                writer.write(line + System.lineSeparator());
            }
        }
        if (!found) {
            throw new IOException("Reservation ID not found.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    try {
        replaceOriginalFile(inputFile, tempFile); // Handle IOException here if declared
    } catch (IOException e) {
        e.printStackTrace(); // Handle the exception
    }
}

   public void deleteReservation(String reservationId) {
    File inputFile = new File(thefile);
    File tempFile = new File("temp_" + thefile);
    try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
         BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
        String line;
        boolean found = false;
        while ((line = reader.readLine()) != null) {
            if (!line.contains(reservationId)) {
                writer.write(line + System.lineSeparator());
            } else {
                found = true; // Mark that the reservation was found and deleted
            }
        }
        if (!found) {
            throw new IOException("Reservation ID not found.");
        }
    } catch (IOException e) {
        e.printStackTrace(); // Handle the exception (e.g., log it or show a message)
    }
    try {
        replaceOriginalFile(inputFile, tempFile); // Handle IOException here if declared
    } catch (IOException e) {
        e.printStackTrace(); // Handle the exception
    }
}

private void replaceOriginalFile(File inputFile, File tempFile) throws IOException {
    if (!inputFile.delete()) {
        throw new IOException("Could not delete the original file");
    }
    if (!tempFile.renameTo(inputFile)) {
        throw new IOException("Could not rename temp file");
    }
}
}
