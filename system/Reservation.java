package hotel.system;

import java.time.LocalDate;

public class Reservation {
    private Room room;
    private String customerName;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Reservation(Room room, String customerName, LocalDate checkIn, LocalDate checkOut) {
        this.room = room;
        this.customerName = customerName;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        
        // Mark the room as unavailable once reserved
        room.setAvailable(false);
    }

    public Room getRoom() {
        return room;
    }

    public String getCustomerName() {
        return customerName;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "room=" + room +
                ", customerName='" + customerName + '\'' +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                '}';
    }
}
