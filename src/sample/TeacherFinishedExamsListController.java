package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class TeacherFinishedExamsListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> ExamsTable;

    @FXML
    void initialize() {
        assert ExamsTable != null : "fx:id=\"ExamsTable\" was not injected: check your FXML file 'Teacher Finished Exams List.fxml'.";

    }
}
