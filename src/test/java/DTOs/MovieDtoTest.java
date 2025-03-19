package DTOs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MovieDtoTest {

    @Test
    void testMovieDefaultConstructor() {
        Movie movie = new Movie();
        assertNotNull(movie);
        assertNull(movie.getTitle());
        assertEquals(0, movie.getId());
        assertEquals(0.0f, movie.getRating());
        assertEquals(0, movie.getDuration());
    }

    @Test
    void testMovieConstructorWithParameters() {
        Movie movie = new Movie(1, "Inception", 8.8f, 148);
        assertEquals(1, movie.getId());
        assertEquals("Inception", movie.getTitle());
        assertEquals(8.8f, movie.getRating());
        assertEquals(148, movie.getDuration());
    }

    @Test
    void testSettersAndGetters() {
        Movie movie = new Movie();
        movie.setId(2);
        movie.setTitle("The Dark Knight");
        movie.setRating(9.0f);
        movie.setDuration(152);

        assertEquals(2, movie.getId());
        assertEquals("The Dark Knight", movie.getTitle());
        assertEquals(9.0f, movie.getRating());
        assertEquals(152, movie.getDuration());
    }

    @Test
    void testToString() {
        Movie movie = new Movie(3, "Interstellar", 8.6f, 169);
        String expected = "Movie{movie_id=3, movieTitle='Interstellar', rating=8.6, duration=169}";
        assertEquals(expected, movie.toString());
    }
}

