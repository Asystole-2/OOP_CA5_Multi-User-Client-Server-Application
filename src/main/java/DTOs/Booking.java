package DTOs;

public class Booking {
    private int bookingID;
    private String status;
    private Float ticket_price;
    private int seat_number;

    public Booking() {

    }

    public Booking(String status, Float ticket_price, int seat_number) {
        this.status = status;
        this.ticket_price = ticket_price;
        this.seat_number = seat_number;
    }

    public Booking(int bookingID, String status, Float ticket_price, int seat_number) {
        this.bookingID = bookingID;
        this.status = status;
        this.ticket_price = ticket_price;
        this.seat_number = seat_number;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(int seat_number) {
        this.seat_number = seat_number;
    }

    public Float getTicket_price() {
        return ticket_price;
    }

    public void setTicket_price(Float ticket_price) {
        this.ticket_price = ticket_price;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingID=" + bookingID +
                ", status='" + status + '\'' +
                ", ticket_price=" + ticket_price +
                ", seat_number=" + seat_number +
                '}';
    }
}

