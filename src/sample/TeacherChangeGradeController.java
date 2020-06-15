package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class TeacherChangeGradeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonapply;

    @FXML
    private TextField Explanation;

    @FXML
    private TextField NewGrade;

    @FXML
    void buttonapplyclick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert buttonapply != null : "fx:id=\"buttonapply\" was not injected: check your FXML file 'Teacher Change Grade.fxml'.";
        assert Explanation != null : "fx:id=\"Explanation\" was not injected: check your FXML file 'Teacher Change Grade.fxml'.";
        assert NewGrade != null : "fx:id=\"NewGrade\" was not injected: check your FXML file 'Teacher Change Grade.fxml'.";

    }
}
