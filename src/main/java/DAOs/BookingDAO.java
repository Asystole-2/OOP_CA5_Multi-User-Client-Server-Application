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
        String query = "SELECT * FROM Booking";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                bookings.add(new Booking(rs.getInt("id"), rs.getString("status"), rs.getFloat("ticket_price"), rs.getInt("seat_number")));
            }
        } catch (SQLException e) {
            throw new DaoException("Error fetching bookings: " + e.getMessage());
        }
        return bookings;
    }
}
