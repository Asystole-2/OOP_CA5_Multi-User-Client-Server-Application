package DAOs;

import DTOs.Movie;
import java.util.List;

public interface MovieDaoInterface {
    List<Movie> getAllMovies();
    List <Movie> displayByKey(int tickets_purchased);
    Movie deleteByKey(int id);
}

