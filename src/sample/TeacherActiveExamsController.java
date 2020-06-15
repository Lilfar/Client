package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TeacherActiveExamsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> ExamsTable;

    @FXML
    private TableColumn<?, ?> Exams;

    @FXML
    void initialize() {
        assert ExamsTable != null : "fx:id=\"ExamsTable\" was not injected: check your FXML file 'Teacher Active Exams.fxml'.";
        assert Exams != null : "fx:id=\"Exams\" was not injected: check your FXML file 'Teacher Active Exams.fxml'.";

    }
}
