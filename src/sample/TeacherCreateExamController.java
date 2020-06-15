package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

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
    private Button buttoncancel;

    @FXML
    void buttoncreateclick(ActionEvent event) throws IOException {
        Stage stage = (Stage)buttoncreate.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Exams List.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }
    @FXML
    void buttoncancelclick(ActionEvent event) throws IOException {
        Stage stage = (Stage)buttoncancel.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Exams List.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
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
