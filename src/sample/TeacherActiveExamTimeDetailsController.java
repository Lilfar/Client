package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class TeacherActiveExamTimeDetailsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea ExamName;

    @FXML
    private Button buttonaddtime;

    @FXML
    private TextArea ExamName1;

    @FXML
    private TextArea ExamName11;

    @FXML
    private Button buttonclose;

    @FXML
    void buttonaddtimeclick(ActionEvent event) {

    }

    @FXML
    void buttoncloseclick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert ExamName != null : "fx:id=\"ExamName\" was not injected: check your FXML file 'Teacher Active Exam Time Details.fxml'.";
        assert buttonaddtime != null : "fx:id=\"buttonaddtime\" was not injected: check your FXML file 'Teacher Active Exam Time Details.fxml'.";
        assert ExamName1 != null : "fx:id=\"ExamName1\" was not injected: check your FXML file 'Teacher Active Exam Time Details.fxml'.";
        assert ExamName11 != null : "fx:id=\"ExamName11\" was not injected: check your FXML file 'Teacher Active Exam Time Details.fxml'.";
        assert buttonclose != null : "fx:id=\"buttonclose\" was not injected: check your FXML file 'Teacher Active Exam Time Details.fxml'.";

    }
}
