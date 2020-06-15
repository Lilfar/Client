package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class TeacherGradeViewOnlineController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea Grade;

    @FXML
    private Button buttonchangegrade;

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
    private Button buttonapply;

    @FXML
    void buttonapplyclick(ActionEvent event) {

    }

    @FXML
    void buttonchangegradeclick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert Grade != null : "fx:id=\"Grade\" was not injected: check your FXML file 'Teacher Grade View Online.fxml'.";
        assert buttonchangegrade != null : "fx:id=\"buttonchangegrade\" was not injected: check your FXML file 'Teacher Grade View Online.fxml'.";
        assert QuestionsTableSubject != null : "fx:id=\"QuestionsTableSubject\" was not injected: check your FXML file 'Teacher Grade View Online.fxml'.";
        assert Question != null : "fx:id=\"Question\" was not injected: check your FXML file 'Teacher Grade View Online.fxml'.";
        assert RightAnswer != null : "fx:id=\"RightAnswer\" was not injected: check your FXML file 'Teacher Grade View Online.fxml'.";
        assert WrongAnswer1 != null : "fx:id=\"WrongAnswer1\" was not injected: check your FXML file 'Teacher Grade View Online.fxml'.";
        assert WrongAnswer2 != null : "fx:id=\"WrongAnswer2\" was not injected: check your FXML file 'Teacher Grade View Online.fxml'.";
        assert WrongAnswer3 != null : "fx:id=\"WrongAnswer3\" was not injected: check your FXML file 'Teacher Grade View Online.fxml'.";
        assert buttonapply != null : "fx:id=\"buttonapply\" was not injected: check your FXML file 'Teacher Grade View Online.fxml'.";

    }
}
