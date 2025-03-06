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

    @Override
    public List<Movie> displayByKey(int tickets_purchased) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Movie movie = null;
        List<Movie> movies = new ArrayList<>();
        String query = "SELECT * FROM Movie WHERE tickets_purchased =  ";

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
    // third one
    public Movie deleteByKey(int idMovie){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Movie movie = null;

        try{
            connection = getConnection();

            String query = "SELECT * FROM movie WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,idMovie);

            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                float rating = resultSet.getFloat("rating");
                int duration = resultSet.getInt("duration");
                movie = new Movie(id, title, rating, duration);
            }

            if (movie != null) {
                String deleteQuery = "DELETE FROM movie WHERE id = ?";
                preparedStatement = connection.prepareStatement(deleteQuery);
                preparedStatement.setInt(1,idMovie);
                preparedStatement.executeUpdate();
            }else{
                System.out.println("Movie not found with the ID:"+ idMovie);
            }
        }catch(SQLException e){
            throw new DaoException("deleteMovie()"+e.getMessage());
        }finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    freeConnection(connection);
                }
            } catch (SQLException e) {
                throw new DaoException("deleteTask()" + e.getMessage());
            }
        }
        return movie;
    }

}
