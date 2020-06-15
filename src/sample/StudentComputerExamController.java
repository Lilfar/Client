package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class StudentComputerExamController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonnext;

    @FXML
    private Button buttonprev;

    @FXML
    void buttonnextclick(ActionEvent event) {

    }

    @FXML
    void buttonprevclick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert buttonnext != null : "fx:id=\"buttonnext\" was not injected: check your FXML file 'Student Computer Exam.fxml'.";
        assert buttonprev != null : "fx:id=\"buttonprev\" was not injected: check your FXML file 'Student Computer Exam.fxml'.";

    }
}
