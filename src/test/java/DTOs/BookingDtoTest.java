package DTOs;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookingDtoTest {

    @Test
    void testBookingDefaultConstructor() {
        Booking booking = new Booking();
        assertNotNull(booking);
        assertNull(booking.getStatus());
        assertNull(booking.getTicket_price());
        assertEquals(0, booking.getSeat_number());
        assertEquals(0, booking.getBookingID());
    }

    @Test
    void testBookingConstructorWithParameters() {
        Booking booking = new Booking("Confirmed", 12.5f, 5);
        assertEquals("Confirmed", booking.getStatus());
        assertEquals(12.5f, booking.getTicket_price());
        assertEquals(5, booking.getSeat_number());
    }

    @Test
    void testBookingConstructorWithAllParameters() {
        Booking booking = new Booking(1, "Cancelled", 15.0f, 10);
        assertEquals(1, booking.getBookingID());
        assertEquals("Cancelled", booking.getStatus());
        assertEquals(15.0f, booking.getTicket_price());
        assertEquals(10, booking.getSeat_number());
    }

    @Test
    void testSettersAndGetters() {
        Booking booking = new Booking();
        booking.setBookingID(100);
        booking.setStatus("Pending");
        booking.setTicket_price(20.75f);
        booking.setSeat_number(7);

        assertEquals(100, booking.getBookingID());
        assertEquals("Pending", booking.getStatus());
        assertEquals(20.75f, booking.getTicket_price());
        assertEquals(7, booking.getSeat_number());
    }

    @Test
    void testToString() {
        Booking booking = new Booking(2, "Confirmed", 30.0f, 12);
        String expected = "Booking{bookingID=2, status='Confirmed', ticket_price=30.0, seat_number=12}";
        assertEquals(expected, booking.toString());
    }
}

