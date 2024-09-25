/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;
//import java.util.Date;

public class Halls {// Class definition: OOP principle
    private String HallID; // Encapsulation: private fields
    private String HallType;
    private int Capacity;
    private double BookingRate;
    private String reservationId;


    public Halls(String HallID, String HallType, // Constructor: OOP principle
            int Capacity, double BookingRate) {
        this.HallID = HallID;
        this.HallType = HallType;
        this.Capacity = Capacity;
        this.BookingRate = BookingRate;
    }

    public Halls(String reservationId) { // Constructor overloading: OOP principle
        this.reservationId = reservationId;
    }

    public String getReservationId() { // Getter method: OOP principle
        return reservationId;
    }

    public void setReservationId(String reservationId) { // Setter method: OOP principle
        this.reservationId = reservationId;
    }

    public String getHallID() { 
        return HallID;
    }

    public String getHallType() {
        return HallType;
    }
    

    public int getCapacity() {
        return Capacity;
    }

    public double getBookingRate() {
        return BookingRate;
    }
    
/*
    public void setHallID(String HallID) {
        this.HallID = HallID;
    }

    public void setHallType(String HallName) {
        this.HallType = HallName;
    }

    public void setCapacity(int Capacity) {
        this.Capacity = Capacity;
    }

    public void setBookingRate(double BookingRate) {
        this.BookingRate = BookingRate;
    }
    */
}

