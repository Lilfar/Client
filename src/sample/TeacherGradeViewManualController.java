package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class TeacherGradeViewManualController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea Grade;

    @FXML
    private Button ChangeGrade;

    @FXML
    private Button buttonstudentssolution;

    @FXML
    private Button Apply;

    @FXML
    void apply(ActionEvent event) {

    }

    @FXML
    void buttonstudentssolutionclick(ActionEvent event) {

    }

    @FXML
    void changegrade(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert Grade != null : "fx:id=\"Grade\" was not injected: check your FXML file 'Teacher Grade View Manual.fxml'.";
        assert ChangeGrade != null : "fx:id=\"ChangeGrade\" was not injected: check your FXML file 'Teacher Grade View Manual.fxml'.";
        assert buttonstudentssolution != null : "fx:id=\"buttonstudentssolution\" was not injected: check your FXML file 'Teacher Grade View Manual.fxml'.";
        assert Apply != null : "fx:id=\"Apply\" was not injected: check your FXML file 'Teacher Grade View Manual.fxml'.";

    }
}
