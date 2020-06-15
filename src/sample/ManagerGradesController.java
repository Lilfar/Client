package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ManagerGradesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonteachers;

    @FXML
    private Button buttonsubjects;

    @FXML
    private Button buttonstudent;

    @FXML
    void buttonstudentclick(ActionEvent event) {

    }

    @FXML
    void buttonsubjectsclick(ActionEvent event) {

    }

    @FXML
    void buttonteachersclick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert buttonteachers != null : "fx:id=\"buttonteachers\" was not injected: check your FXML file 'Manager Grades.fxml'.";
        assert buttonsubjects != null : "fx:id=\"buttonsubjects\" was not injected: check your FXML file 'Manager Grades.fxml'.";
        assert buttonstudent != null : "fx:id=\"buttonstudent\" was not injected: check your FXML file 'Manager Grades.fxml'.";

    }
}
