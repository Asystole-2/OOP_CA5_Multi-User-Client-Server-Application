package DAOs;

import DTOs.Movie;
import Exceptions.DaoException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO extends MysqlDao implements MovieDaoInterface {
    @Override
    public List<Movie> getAllMovies() {

        List<Movie> movies = new ArrayList<>();
        String query = "SELECT * FROM Movie";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                movies.add(new Movie(rs.getInt("id"), rs.getString("title"), rs.getFloat("rating"), rs.getInt("duration")));
            }
        } catch (SQLException e) {
            throw new DaoException("Error fetching movies: " + e.getMessage());
        }
        return movies;
    }
}
