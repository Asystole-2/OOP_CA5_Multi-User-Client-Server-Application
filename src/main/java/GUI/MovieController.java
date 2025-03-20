package GUI;

import DAOs.MovieDAO;
import DTOs.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Comparator;


public class MovieController {

    private final MovieListModel movieListModel;

    @FXML
    public Label titleText;
    @FXML
    public Button showUsersButton;
    @FXML
    public Button clearAllButton;
    @FXML
    private ListView<Movie> movieListView;
    @FXML
    private Label messageLabel;

    public MovieController() {
        this.movieListModel = new MovieListModel();
    }

    private void initialize() {
        System.out.println("Initialize MovieController");
    }

    @FXML
    protected void onShowMoviesButtonClicked() {
        messageLabel.setText("onShowMoviesButtonClicked() ws called.");
        movieListModel.reloadMovieData();

        movieListModel.sortMovieData(Comparator.comparing(Movie::getTitle));
        movieListView.setItems(movieListModel.observableMovieData);

        movieListView.setCellFactory(param -> {
            return new ListCell<Movie>() {
                @Override
                protected void updateItem(Movie movie, boolean empty) {
                    super.updateItem(movie, empty);

                    if (empty || movie == null) {
                        setText(null);
                    } else {
                        setText(movie.getId() + " " + movie.getTitle());
                    }
                }
            };
        });
    }

    @FXML
    protected void onClearAllButtonClicked() {
        movieListView.getItems().clear();
        messageLabel.setText("ListView has been cleared.");
    }
}

//
//public class MovieController {
//    @FXML
//    private TableView<Movie> movieTable;
//    @FXML
//    private TableColumn<Movie, Integer> idColumn;
//    @FXML
//    private TableColumn<Movie, String> titleColumn;
//    @FXML
//    private TableColumn<Movie, Float> ratingColumn;
//    @FXML
//    private TableColumn<Movie, Integer> durationColumn;
//
//    private MovieDAO movieDao;
//    private ObservableList<Movie> movieData = FXCollections.observableArrayList();
//
//    public void setMovieDao(MovieDAO movieDao) {
//        this.movieDao = movieDao;
//        initializeTable();
//        loadMovies();
//    }
//
//    private void initializeTable() {
//        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
//        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
//        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));
//        durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));
//    }
//
//    private void loadMovies() {
//        movieData.setAll(movieDao.getAllMovies());
//        movieTable.setItems(movieData);
//    }
//
//    @FXML
//    private void handleAddMovie() {
//        // Implementation for showing add movie dialog
//        // Use movieDao.insertMovie()
//        // Then call loadMovies() to refresh
//    }
//
//    @FXML
//    private void handleUpdateMovie() {
//        Movie selected = movieTable.getSelectionModel().getSelectedItem();
//        if(selected != null) {
//            // Show update dialog with selected movie
//            // Use movieDao.updateMovieById()
//            // Then call loadMovies()
//        }
//    }
//
//    @FXML
//    private void handleDeleteMovie() {
//        Movie selected = movieTable.getSelectionModel().getSelectedItem();
//        if(selected != null) {
//            movieDao.deleteByKey(selected.getId());
//            loadMovies();
//        }
//    }
//}
