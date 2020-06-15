package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

public class TeacherExamsListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> ExamsTable;

    @FXML
    private Button buttoncreateexam;

    @FXML
    void buttoncreateexamclick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert ExamsTable != null : "fx:id=\"ExamsTable\" was not injected: check your FXML file 'Teacher Exams List.fxml'.";
        assert buttoncreateexam != null : "fx:id=\"buttoncreateexam\" was not injected: check your FXML file 'Teacher Exams List.fxml'.";

    }
}
