package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TeacherQuestionEditController {
    static boolean confirmed = false;

    @FXML
    private ResourceBundle resources;
    @FXML
    private ImageView Background;
    @FXML
    private URL location;

    @FXML
    private TextField Question;

    @FXML
    private TextField RightAnswer;

    @FXML
    private TextField WrongAnswer1;

    @FXML
    private TextField WrongAnswer2;

    @FXML
    private TextField WrongAnswer3;

    @FXML
    private Button buttonapply;
    @FXML
    private Button buttoncancel;

    @FXML
    void buttoncancelclick(ActionEvent event) throws IOException {
        Stage stage = (Stage)buttoncancel.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Question List.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }


    @FXML
    void buttonapplyclick(ActionEvent event) throws IOException {

        Stage popup = new Stage();
        Parent newRoot;


        if(!Question.getText().isBlank() &&
                !RightAnswer.getText().isBlank() &&
                !WrongAnswer1.getText().isBlank() &&
                !WrongAnswer2.getText().isBlank() &&
                !WrongAnswer3.getText().isBlank())
        {
            FinishPopupController.from=8;
            newRoot = FXMLLoader.load(getClass().getResource("Finish Popup.fxml"));
            Scene scene = new Scene(newRoot);
            popup.setScene(scene);
            popup.showAndWait();

            if (confirmed)
            {
                confirmed=!confirmed;
                Stage stage = (Stage)buttonapply.getScene().getWindow();
                newRoot = FXMLLoader.load(getClass().getResource("Teacher Question List.fxml"));
                Scene scene2 = new Scene(newRoot);
                stage.setScene(scene2);
            }
        }
        else
        {
            newRoot = FXMLLoader.load(getClass().getResource("Teacher Add Question Error Popup.fxml"));
            Scene scene = new Scene(newRoot);
            popup.setScene(scene);
            popup.showAndWait();
        }
    }

    @FXML
    void initialize() {
        assert Background !=null : "fx:id=\"Background\" was not injected: check your FXML file 'Login Menu.fxml'.";
        assert Question != null : "fx:id=\"Question\" was not injected: check your FXML file 'Teacher Question Edit.fxml'.";
        assert RightAnswer != null : "fx:id=\"RightAnswer\" was not injected: check your FXML file 'Teacher Question Edit.fxml'.";
        assert WrongAnswer1 != null : "fx:id=\"WrongAnswer1\" was not injected: check your FXML file 'Teacher Question Edit.fxml'.";
        assert WrongAnswer2 != null : "fx:id=\"WrongAnswer2\" was not injected: check your FXML file 'Teacher Question Edit.fxml'.";
        assert WrongAnswer3 != null : "fx:id=\"WrongAnswer3\" was not injected: check your FXML file 'Teacher Question Edit.fxml'.";
        assert buttonapply != null : "fx:id=\"buttonapply\" was not injected: check your FXML file 'Teacher Question Edit.fxml'.";

    }
}