package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TeacherQuestionAddController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField NewQuestion;

    @FXML
    private TextField textrightanswer;

    @FXML
    private TextField textwronganswer1;

    @FXML
    private TextField textwronganswer2;

    @FXML
    private TextField textwronganswer3;

    @FXML
    private Button buttonadd;

    @FXML
    void buttonaddclick(ActionEvent event) throws IOException {


        if(!NewQuestion.getText().isBlank() &&
           !textrightanswer.getText().isBlank() &&
           !textwronganswer1.getText().isBlank() &&
           !textwronganswer2.getText().isBlank() &&
           !textwronganswer3.getText().isBlank())
        {

            Stage stage = (Stage)buttonadd.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Question List.fxml"));
            Scene scene = new Scene(newRoot);
            stage.setScene(scene);
        }
        else
        {
            Stage popup = new Stage();
            Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Add Question Error Popup.fxml"));
            Scene scene = new Scene(newRoot);
            popup.setScene(scene);
            popup.showAndWait();

        }

    }
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
    void initialize() {
        assert NewQuestion != null : "fx:id=\"NewQuestion\" was not injected: check your FXML file 'Teacher Question Add.fxml'.";
        assert textrightanswer != null : "fx:id=\"textrightanswer\" was not injected: check your FXML file 'Teacher Question Add.fxml'.";
        assert textwronganswer1 != null : "fx:id=\"textwronganswer1\" was not injected: check your FXML file 'Teacher Question Add.fxml'.";
        assert textwronganswer2 != null : "fx:id=\"textwronganswer2\" was not injected: check your FXML file 'Teacher Question Add.fxml'.";
        assert textwronganswer3 != null : "fx:id=\"textwronganswer3\" was not injected: check your FXML file 'Teacher Question Add.fxml'.";
        assert buttonadd != null : "fx:id=\"buttonadd\" was not injected: check your FXML file 'Teacher Question Add.fxml'.";

    }
}
