package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ManagerGradesTeacherController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> TeachersList;

    @FXML
    private TableColumn<?, ?> teachers;

    @FXML
    void initialize() {
        assert TeachersList != null : "fx:id=\"TeachersList\" was not injected: check your FXML file 'Manager Grades Teacher.fxml'.";
        assert teachers != null : "fx:id=\"teachers\" was not injected: check your FXML file 'Manager Grades Teacher.fxml'.";

    }
}
