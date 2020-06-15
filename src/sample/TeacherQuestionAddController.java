package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class TeacherQuestionAddController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField NewQuestion;

    @FXML
    private TextField RightAnswer;

    @FXML
    private TextField WrongAnswer1;

    @FXML
    private TextField WrongAnswer2;

    @FXML
    private TextField WrongAnswer3;

    @FXML
    private Button buttonadd;

    @FXML
    void buttonaddclick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert NewQuestion != null : "fx:id=\"NewQuestion\" was not injected: check your FXML file 'Teacher Question Add.fxml'.";
        assert RightAnswer != null : "fx:id=\"RightAnswer\" was not injected: check your FXML file 'Teacher Question Add.fxml'.";
        assert WrongAnswer1 != null : "fx:id=\"WrongAnswer1\" was not injected: check your FXML file 'Teacher Question Add.fxml'.";
        assert WrongAnswer2 != null : "fx:id=\"WrongAnswer2\" was not injected: check your FXML file 'Teacher Question Add.fxml'.";
        assert WrongAnswer3 != null : "fx:id=\"WrongAnswer3\" was not injected: check your FXML file 'Teacher Question Add.fxml'.";
        assert buttonadd != null : "fx:id=\"buttonadd\" was not injected: check your FXML file 'Teacher Question Add.fxml'.";

    }
}
