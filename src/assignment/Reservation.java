/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author user
 */
public class Reservation {
     private String hallID;
    private String hallType;
    private String startTime;
    private String endTime;
    private String reservationID;

    public Reservation(String hallID, String hallType, String startTime,
            String endTime, String reservationID) {
        this.hallID = hallID;
        this.hallType = hallType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.reservationID = reservationID;
    }

    public String getHallID() {
        return hallID;
    }

    public String getHallType() {
        return hallType;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getReservationID() {
        return reservationID;
    }
}
