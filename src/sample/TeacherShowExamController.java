package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TeacherShowExamController {

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
    private Button buttondownloadexam;

    @FXML
    private Button buttonclose;

    @FXML
    void buttoncloseclick(ActionEvent event) {

    }

    @FXML
    void buttondownloadexamclick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert QuestionsTableSubject != null : "fx:id=\"QuestionsTableSubject\" was not injected: check your FXML file 'Teacher Show Exam.fxml'.";
        assert Question != null : "fx:id=\"Question\" was not injected: check your FXML file 'Teacher Show Exam.fxml'.";
        assert RightAnswer != null : "fx:id=\"RightAnswer\" was not injected: check your FXML file 'Teacher Show Exam.fxml'.";
        assert WrongAnswer1 != null : "fx:id=\"WrongAnswer1\" was not injected: check your FXML file 'Teacher Show Exam.fxml'.";
        assert WrongAnswer2 != null : "fx:id=\"WrongAnswer2\" was not injected: check your FXML file 'Teacher Show Exam.fxml'.";
        assert WrongAnswer3 != null : "fx:id=\"WrongAnswer3\" was not injected: check your FXML file 'Teacher Show Exam.fxml'.";
        assert buttondownloadexam != null : "fx:id=\"buttondownloadexam\" was not injected: check your FXML file 'Teacher Show Exam.fxml'.";
        assert buttonclose != null : "fx:id=\"buttonclose\" was not injected: check your FXML file 'Teacher Show Exam.fxml'.";

    }
}
