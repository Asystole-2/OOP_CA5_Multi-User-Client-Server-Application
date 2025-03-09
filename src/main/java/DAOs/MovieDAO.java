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
            throw new DaoException("Error while getting movies: " + e.getMessage());
        }
        return movies;
    }

    @Override
    public List<Movie> displayByKey(int tickets_purchased) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Movie> movies = new ArrayList<>();
        String query = "SELECT * FROM Movie WHERE tickets_purchased = ?";

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, tickets_purchased);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                movies.add(new Movie(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getFloat("rating"), resultSet.getInt("duration")));
            }
        } catch (SQLException e) {
            throw new DaoException("Error getting movies by tickets_purchased: " + e.getMessage());
        } finally {
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
                throw new DaoException("Error  " + e.getMessage());
            }
        }
        return movies;
    }

    @Override
    public Movie deleteByKey(int idMovie) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Movie movie = null;

        try {
            connection = getConnection();

            String query = "SELECT * FROM movie WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idMovie);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                float rating = resultSet.getFloat("rating");
                int duration = resultSet.getInt("duration");
                movie = new Movie(id, title, rating, duration);
            }

            if (movie != null) {
                String deleteQuery = "DELETE FROM movie WHERE id = ?";
                preparedStatement = connection.prepareStatement(deleteQuery);
                preparedStatement.setInt(1, idMovie);
                preparedStatement.executeUpdate();
            } else {
                System.out.println("there is no movie  with the ID: " + idMovie);
            }
        } catch (SQLException e) {
            throw new DaoException("deleteMovie() " + e.getMessage());
        } finally {
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
                throw new DaoException("deleteTask() " + e.getMessage());
            }
        }
        return movie;
    }

    @Override
    public Movie insertMovie(Movie movie) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            String query = "INSERT INTO movie (id, title, rating, duration) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, movie.getId());
            preparedStatement.setString(2, movie.getTitle());
            preparedStatement.setFloat(3, movie.getRating());
            preparedStatement.setInt(4, movie.getDuration());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("insertMovie() " + e.getMessage());
        } finally {
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
                throw new DaoException("add movie " + e.getMessage());
            }
        }
        return movie;
    }

    @Override
    public Movie updateMovieById(int id, Movie updatedMovie) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            String query = "UPDATE movie SET title = ?, rating = ?, duration = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, updatedMovie.getTitle());
            preparedStatement.setFloat(2, updatedMovie.getRating());
            preparedStatement.setInt(3, updatedMovie.getDuration());
            preparedStatement.setInt(4, id);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 0) {
                throw new DaoException("there is no movie  with the ID: " + id);
            }
        } catch (SQLException e) {
            throw new DaoException("updateMovieById " + e.getMessage());
        } finally {
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
                throw new DaoException("updateMovieById" + e.getMessage());
            }
        }
        return updatedMovie;
    }

    @Override
    public List<Movie> filterMoviesByRating(float minRating) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Movie> movies = new ArrayList<>();

        try {
            connection = getConnection();
            String query = "SELECT * FROM movie WHERE rating >= ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setFloat(1, minRating);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                movies.add(new Movie(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getFloat("rating"), resultSet.getInt("duration")));
            }
        } catch (SQLException e) {
            throw new DaoException("filterMoviesByRating " + e.getMessage());
        } finally {
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
                throw new DaoException("filterMoviesByRating " + e.getMessage());
            }
        }
        return movies;
    }

    @Override
    public Movie getMovieById(int id) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Movie movie = null;

        try {
            connection = getConnection();
            String query = "SELECT * FROM movie WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int movieId = resultSet.getInt("id");
                String title = resultSet.getString("title");
                float rating = resultSet.getFloat("rating");
                int duration = resultSet.getInt("duration");
                movie = new Movie(movieId, title, rating, duration);
            }
        } catch (SQLException e) {
            throw new DaoException("getMovieById() " + e.getMessage());
        } finally {
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
                throw new DaoException("getMovieById() " + e.getMessage());
            }
        }
        return movie;
    }
}