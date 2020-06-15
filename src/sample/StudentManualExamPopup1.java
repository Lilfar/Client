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
import javafx.stage.Stage;

public class StudentManualExamPopup1 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonyes;

    @FXML
    private Button buttonno;

    @FXML
    void buttonnoclick(ActionEvent event) throws IOException {

        Stage popup = (Stage)buttonno.getScene().getWindow();
        popup.close();

    }

    @FXML
    void buttonyesclick(ActionEvent event) throws IOException {

        Stage popup = (Stage)buttonyes.getScene().getWindow();
        popup.close();
        StudentManualExam.close = true;
    }

    @FXML
    void initialize() {
        assert buttonyes != null : "fx:id=\"buttonyes\" was not injected: check your FXML file 'Student Manual Exam Popup1.fxml'.";
        assert buttonno != null : "fx:id=\"buttonno\" was not injected: check your FXML file 'Student Manual Exam Popup1.fxml'.";

    }
}
