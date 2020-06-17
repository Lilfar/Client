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

public class StudentTakeExamController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttongo;

    @FXML
    private Button buttonback;
    @FXML
    private TextField textcode;

    @FXML
    void buttonbackclick(ActionEvent event) throws IOException {

        Stage stage = (Stage)buttonback.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Student Main.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void buttongoclick(ActionEvent event) throws IOException {

        boolean type = false;


        if (!textcode.getText().isBlank())
        {
            Stage stage = (Stage)buttongo.getScene().getWindow();
            Parent newRoot;

            if (type)
            {
                newRoot = FXMLLoader.load(getClass().getResource("Student Manual Exam.fxml"));
            }
            else
            {
                newRoot = FXMLLoader.load(getClass().getResource("Student Computer Exam.fxml"));
            }
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
    void initialize() {
        assert buttongo != null : "fx:id=\"buttongo\" was not injected: check your FXML file 'Student Take Exam.fxml'.";
        assert buttonback != null : "fx:id=\"buttonback\" was not injected: check your FXML file 'Student Take Exam.fxml'.";

    }
}
