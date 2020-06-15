package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class TeacherFinishedExamStudentsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonviewexam;

    @FXML
    private TableView<?> Students;

    @FXML
    void buttonviewexamclick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert buttonviewexam != null : "fx:id=\"buttonviewexam\" was not injected: check your FXML file 'Teacher Finished Exam Students.fxml'.";
        assert Students != null : "fx:id=\"Students\" was not injected: check your FXML file 'Teacher Finished Exam Students.fxml'.";

    }
}
