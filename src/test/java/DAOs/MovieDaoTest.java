package DAOs;

import DTOs.Customer;
import DTOs.Movie;
import Exceptions.DaoException;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieDaoTest {
    MovieDaoInterface IMovieDao = null;

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws DaoException {
        IMovieDao = new MovieDAO();
    }

    @org.junit.jupiter.api.Test
    void getAllMovies() throws DaoException {
        List<Movie> Movies = IMovieDao.getAllMovies();

        assertNotNull(Movies, "The list of customers should not be null.");
        assertFalse(Movies.isEmpty(), "The list of customers should not be empty.");
        assertEquals(20, Movies.size(), "Expected 20 Movies in the list.");
        assertEquals("Inception", Movies.get(0).getTitle(), "Expected title is 'Inception' .");
    }

    @org.junit.jupiter.api.Test
    void insertMovie() throws DaoException {

        Movie newMovie = new Movie(21, "Avatar", 7.8f, 162);
        Movie insertedMovie = IMovieDao.insertMovie(newMovie);

        assertNotNull(insertedMovie, "The inserted movie should not be null.");
        assertEquals(21, insertedMovie.getId(), "The movie ID should be 21.");
        assertEquals("Avatar", insertedMovie.getTitle(), "The movie title should be 'Avatar'.");
        assertEquals(7.8f, insertedMovie.getRating(), 0.0001f, "The movie rating should be 7.8.");
        assertEquals(162, insertedMovie.getDuration(), "The movie duration should be 162 minutes.");
    }

    // this movie isn't in the database.Run the method above to insert the movie to be deleted using the method below, or just check the tables if its there and run the tests accordingly
    @org.junit.jupiter.api.Test
    void deleteByKey() throws DaoException {
        Movie deletedMovie = (Movie) IMovieDao.deleteByKey(21);
        assertNotNull(deletedMovie,"The deleted movie should not be null.");

        assertEquals("Avatar", deletedMovie.getTitle(), "The movie title should be 'Avatar'.");
        assertEquals(7.8f, deletedMovie.getRating(), 0.0001f, "The movie rating should be 7.8.");
        assertEquals(162, deletedMovie.getDuration(), "The movie duration should be 162 minutes.");

    }

    @org.junit.jupiter.api.Test
    void deleteByMissingKey() throws DaoException {
        Movie deletedMovie = (Movie) IMovieDao.deleteByKey(26);
        assertNull(deletedMovie, "there is no movie  with the ID:26");
    }

    @org.junit.jupiter.api.Test
    void getMovieById() throws DaoException {
        Movie movie = (Movie) IMovieDao.getMovieById(17);
        assertNotNull(movie, "The movie should not be null.");
        assertEquals("Coco", movie.getTitle(), "Expected title is 'coco' .");

        // rating is stored as 8.399999618530273 in memory. To counter that I used a delta (tolerance) value for comparing the floating-point numbers in assertions.
        // The delta specifies the maximum allowed difference between the expected and actual values for them to still be considered equal.
        // So we can still use the same value we see in our rating column in the movie table
        assertEquals(8.4f, movie.getRating(), 0.0001f, "Expected rating is '8.4'.");
        assertEquals(105, movie.getDuration(), "Expected duration is '148' .");
    }

    @org.junit.jupiter.api.Test
    void getMovieByMissingId() throws DaoException {
        Movie movie = (Movie) IMovieDao.getMovieById(37);
        assertNull(movie, "there is no movie  with the ID:37");
    }


}
