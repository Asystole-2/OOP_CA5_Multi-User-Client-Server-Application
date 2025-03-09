package DAOs;

import DTOs.Booking;
import java.util.List;

public interface BookingDaoInterface {

    List<Booking> getAllBookings();
    List<Booking> findBookingsApplyFilter(String statusFilter);


}

