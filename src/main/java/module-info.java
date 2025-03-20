module CA.MultiUser.ClientServer.Application {

    exports GUIApp to javafx.graphics;
    opens GUIApp to javafx.graphics;

    requires java.sql;
    requires transitive org.json;
    requires javafx.fxml;
    requires javafx.controls;
    requires mysql.connector.j;
}