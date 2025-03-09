package DAOs;

import DTOs.Booking;
import Exceptions.DaoException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO extends MysqlDao implements BookingDaoInterface {

    @Override
    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT * FROM booking";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                bookings.add(new Booking(
                        rs.getInt("id"),
                        rs.getString("status"),
                        rs.getFloat("ticket_price"),
                        rs.getInt("seat_number")
                ));
            }
        } catch (SQLException e) {
            throw new DaoException("Error fetching bookings: " + e.getMessage());
        }

        return bookings;
    }

    @Override
    public List<Booking> findBookingsApplyFilter(String statusFilter) {
        List<Booking> filteredBookings = new ArrayList<>();
        String query = "SELECT * FROM booking WHERE status = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, statusFilter);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                filteredBookings.add(new Booking(
                        rs.getInt("id"),
                        rs.getString("status"),
                        rs.getFloat("ticket_price"),
                        rs.getInt("seat_number")
                ));
            }
        } catch (SQLException e) {
            throw new DaoException("Error fetching filtered bookings: " + e.getMessage());
        }

        return filteredBookings;
    }
}
