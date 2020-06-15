package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TeacherSubjectDataController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonshowexams;

    @FXML
    private Button buttonshowquestions;

    @FXML
    private Button buttonfinishedexams;

    @FXML
    private Button buttonactiveexams;

    @FXML
    void buttonactiveexamsclick(ActionEvent event) {

    }

    @FXML
    void buttonfinishedexamsclick(ActionEvent event) {

    }

    @FXML
    void buttonshowexamsclick(ActionEvent event) {

    }

    @FXML
    void buttonshowquestionsclick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert buttonshowexams != null : "fx:id=\"buttonshowexams\" was not injected: check your FXML file 'Teacher Subject Data.fxml'.";
        assert buttonshowquestions != null : "fx:id=\"buttonshowquestions\" was not injected: check your FXML file 'Teacher Subject Data.fxml'.";
        assert buttonfinishedexams != null : "fx:id=\"buttonfinishedexams\" was not injected: check your FXML file 'Teacher Subject Data.fxml'.";
        assert buttonactiveexams != null : "fx:id=\"buttonactiveexams\" was not injected: check your FXML file 'Teacher Subject Data.fxml'.";

    }
}
