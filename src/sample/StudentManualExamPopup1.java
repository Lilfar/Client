package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

        StudentComputerExamController.close=true;
        StudentManualExam.close=true;
        Stage popup = (Stage)buttonyes.getScene().getWindow();
        popup.close();
    }

    @FXML
    void initialize() {
        assert buttonyes != null : "fx:id=\"buttonyes\" was not injected: check your FXML file 'Student Manual Exam Popup1.fxml'.";
        assert buttonno != null : "fx:id=\"buttonno\" was not injected: check your FXML file 'Student Manual Exam Popup1.fxml'.";

    }
}
