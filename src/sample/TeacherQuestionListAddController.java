package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TeacherQuestionListAddController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> QuestionsTable;

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
    private Button buttonaddquestion;

    @FXML
    void buttonaddquestionclick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert QuestionsTable != null : "fx:id=\"QuestionsTable\" was not injected: check your FXML file 'Teacher Question List Add.fxml'.";
        assert Question != null : "fx:id=\"Question\" was not injected: check your FXML file 'Teacher Question List Add.fxml'.";
        assert RightAnswer != null : "fx:id=\"RightAnswer\" was not injected: check your FXML file 'Teacher Question List Add.fxml'.";
        assert WrongAnswer1 != null : "fx:id=\"WrongAnswer1\" was not injected: check your FXML file 'Teacher Question List Add.fxml'.";
        assert WrongAnswer2 != null : "fx:id=\"WrongAnswer2\" was not injected: check your FXML file 'Teacher Question List Add.fxml'.";
        assert WrongAnswer3 != null : "fx:id=\"WrongAnswer3\" was not injected: check your FXML file 'Teacher Question List Add.fxml'.";
        assert buttonaddquestion != null : "fx:id=\"buttonaddquestion\" was not injected: check your FXML file 'Teacher Question List Add.fxml'.";

    }
}
