/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;


public class Halls {
    private String HallID;
    private String HallType;
    private int Capacity;
    private double BookingRate;

    public Halls(String HallID, String HallType, int Capacity, double BookingRate) {
        this.HallID = HallID;
        this.HallType = HallType;
        this.Capacity = Capacity;
        this.BookingRate = BookingRate;
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
    
   
}

