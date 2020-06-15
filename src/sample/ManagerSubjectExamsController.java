package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ManagerSubjectExamsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> ExamsTableSubject;

    @FXML
    private TableColumn<?, ?> exams;

    @FXML
    private TableColumn<?, ?> Date;

    @FXML
    void initialize() {
        assert ExamsTableSubject != null : "fx:id=\"ExamsTableSubject\" was not injected: check your FXML file 'Manager Subject Exams.fxml'.";
        assert exams != null : "fx:id=\"exams\" was not injected: check your FXML file 'Manager Subject Exams.fxml'.";
        assert Date != null : "fx:id=\"Date\" was not injected: check your FXML file 'Manager Subject Exams.fxml'.";

    }
}
