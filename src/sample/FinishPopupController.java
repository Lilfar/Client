package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FinishPopupController {

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

        TeacherCreateExamController.close=true;
        StudentComputerExamController.close=true;
        StudentManualExamController.close=true;
        TeacherActiveExamAddExtraTimeController.close=true;
        TeacherChangeGradeController.close=true;
        TeacherGradeViewOnlineController.confirmed=true;
        TeacherGradeViewManualController.confirmed=true;
        TeacherQuestionEditController.confirmed=true;
        StudentManualExamController.finish=true;

        Stage popup = (Stage)buttonyes.getScene().getWindow();
        popup.close();
    }

    @FXML
    void initialize() {
        assert buttonyes != null : "fx:id=\"buttonyes\" was not injected: check your FXML file 'Finish Popup.fxml'.";
        assert buttonno != null : "fx:id=\"buttonno\" was not injected: check your FXML file 'Finish Popup.fxml'.";

    }
}
