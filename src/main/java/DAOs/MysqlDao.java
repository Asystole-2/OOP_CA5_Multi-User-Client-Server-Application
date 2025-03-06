package DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import Exceptions.DaoException;

public class MysqlDao {
    public Connection getConnection() throws DaoException {
        String url = "jdbc:mysql://localhost:3306/movieticketbooking";
        String username = "root";
        String password = "";

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new DaoException("Connection failed: " + e.getMessage());
        }
        return connection;
    }

    public void freeConnection(Connection connection) throws DaoException {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new DaoException("Failed to close connection: " + e.getMessage());
        }
    }
}

