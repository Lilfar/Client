package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ManagerGradesSubjectsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> subjectslist;

    @FXML
    private TableColumn<?, ?> subjects;

    @FXML
    void initialize() {
        assert subjectslist != null : "fx:id=\"subjectslist\" was not injected: check your FXML file 'Manager Grades Subjects.fxml'.";
        assert subjects != null : "fx:id=\"subjects\" was not injected: check your FXML file 'Manager Grades Subjects.fxml'.";

    }
}
