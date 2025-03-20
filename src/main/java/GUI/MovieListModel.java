package GUI;

import DAOs.MovieDAO;
import DAOs.MovieDaoInterface;
import DTOs.Movie;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Comparator;
import java.util.List;

public class MovieListModel {

    ObservableList<Movie> observableMovieData;

    public MovieListModel() {
        this.observableMovieData = FXCollections.observableArrayList();
    }

    private void populateMovieDataUsingDao() {
        MovieDaoInterface IMovieDAO = new MovieDAO();

        try {
            List<Movie> movieData = IMovieDAO.getAllMovies();

            if (movieData != null) {

                this.observableMovieData = FXCollections.observableArrayList();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void reloadMovieData() {
        this.observableMovieData.clear();
        populateMovieDataUsingDao();
    }

    public void sortMovieData(Comparator<Movie> comparator) {
        this.observableMovieData.sort(comparator);
    }

    public ObservableList<Movie> getObservableMovieData() {
        return observableMovieData;
    }

}
