package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TeacherCreateExamController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> QuestionsTableSubject;

    @FXML
    private TableColumn<?, ?> Question;

    @FXML
    private TableColumn<?, ?> RightAnswer;

    @FXML
    private TableColumn<?, ?> WrongAnswer1;

    @FXML
    private TableColumn<?, ?> WrongAnswer2;

    @FXML
    private TableColumn<?, ?> WrongAnswer3;

    @FXML
    private Button buttoncreate;

    @FXML
    void buttoncreateclick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert QuestionsTableSubject != null : "fx:id=\"QuestionsTableSubject\" was not injected: check your FXML file 'Teacher Create Exam.fxml'.";
        assert Question != null : "fx:id=\"Question\" was not injected: check your FXML file 'Teacher Create Exam.fxml'.";
        assert RightAnswer != null : "fx:id=\"RightAnswer\" was not injected: check your FXML file 'Teacher Create Exam.fxml'.";
        assert WrongAnswer1 != null : "fx:id=\"WrongAnswer1\" was not injected: check your FXML file 'Teacher Create Exam.fxml'.";
        assert WrongAnswer2 != null : "fx:id=\"WrongAnswer2\" was not injected: check your FXML file 'Teacher Create Exam.fxml'.";
        assert WrongAnswer3 != null : "fx:id=\"WrongAnswer3\" was not injected: check your FXML file 'Teacher Create Exam.fxml'.";
        assert buttoncreate != null : "fx:id=\"buttoncreate\" was not injected: check your FXML file 'Teacher Create Exam.fxml'.";

    }
}
