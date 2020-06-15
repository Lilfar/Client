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

public class TeacherQuestionListController {

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
    private Button buttonback;

    @FXML
    void buttonbackclick(ActionEvent event) throws IOException {

        Stage stage = (Stage)buttonback.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Main.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);

    }
    @FXML
    void buttonaddquestionclick(ActionEvent event) throws IOException {

            Stage stage = (Stage)buttonaddquestion.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Question Add.fxml"));
            Scene scene = new Scene(newRoot);
            stage.setScene(scene);


    }

    @FXML
    void initialize() {
        assert QuestionsTable != null : "fx:id=\"QuestionsTable\" was not injected: check your FXML file 'Teacher Question List.fxml'.";
        assert Question != null : "fx:id=\"Question\" was not injected: check your FXML file 'Teacher Question List.fxml'.";
        assert RightAnswer != null : "fx:id=\"RightAnswer\" was not injected: check your FXML file 'Teacher Question List.fxml'.";
        assert WrongAnswer1 != null : "fx:id=\"WrongAnswer1\" was not injected: check your FXML file 'Teacher Question List.fxml'.";
        assert WrongAnswer2 != null : "fx:id=\"WrongAnswer2\" was not injected: check your FXML file 'Teacher Question List.fxml'.";
        assert WrongAnswer3 != null : "fx:id=\"WrongAnswer3\" was not injected: check your FXML file 'Teacher Question List.fxml'.";
        assert buttonaddquestion != null : "fx:id=\"buttonaddquestion\" was not injected: check your FXML file 'Teacher Question List.fxml'.";

    }
}
