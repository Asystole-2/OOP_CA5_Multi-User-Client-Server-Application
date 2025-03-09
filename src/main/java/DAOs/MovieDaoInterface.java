package DAOs;

import DTOs.Movie;
import Exceptions.DaoException;

import java.util.List;

public interface MovieDaoInterface {
    List<Movie> getAllMovies();
    List <Movie> displayByKey(int tickets_purchased);
    Movie deleteByKey(int id);
     Movie insertMovie(Movie movie) throws DaoException;
     Movie updateMovieById(int id, Movie updatedMovie) throws DaoException;
     List<Movie> filterMoviesByRating(float minRating) throws DaoException;
    Movie getMovieById(int id) throws DaoException;
}

