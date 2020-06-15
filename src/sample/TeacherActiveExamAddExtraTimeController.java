package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TeacherActiveExamAddExtraTimeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonadd;

    @FXML
    private Button buttoncancel;

    @FXML
    void buttonaddclick(ActionEvent event) {

    }

    @FXML
    void buttoncancelclick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert buttonadd != null : "fx:id=\"buttonadd\" was not injected: check your FXML file 'Teacher Active Exam Add Extra Time.fxml'.";
        assert buttoncancel != null : "fx:id=\"buttoncancel\" was not injected: check your FXML file 'Teacher Active Exam Add Extra Time.fxml'.";

    }
}
