package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ManagerExamsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonsubject;

    @FXML
    private Button buttonteachers;

    @FXML
    void buttonsubjectclick(ActionEvent event) {

    }

    @FXML
    void buttonteachersclick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert buttonsubject != null : "fx:id=\"buttonsubject\" was not injected: check your FXML file 'Manager Exams.fxml'.";
        assert buttonteachers != null : "fx:id=\"buttonteachers\" was not injected: check your FXML file 'Manager Exams.fxml'.";

    }
}
