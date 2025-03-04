package DAOs;

import DTOs.Customer;
import Exceptions.DaoException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO extends MysqlDao implements CustomerDaoInterface {
    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM Customer";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                customers.add(new Customer(rs.getInt("id"), rs.getString("username"), rs.getFloat("wallet_balance"), rs.getInt("tickets_purchased")));
            }
        } catch (SQLException e) {
            throw new DaoException("Error fetching customers: " + e.getMessage());
        }
        return customers;
    }
}
