package GUIApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ShowAllMoviesGUIApp extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/moviedaogui/movie-view.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Movie GUI Application");
        stage.show();
    }
}



