package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FinishPopupController {

    static int from=0;

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


        switch (from)
        {
            case 1:
                StudentComputerExamController.close=true;
                break;
            case 2:
                StudentManualExamController.close=true;
                break;
            case 3:
                TeacherCreateExamController.close=true;
                break;
            case 4:
                TeacherActiveExamAddExtraTimeController.close=true;
                break;
            case 5:
                TeacherChangeGradeController.close=true;
                break;
            case 6:
                TeacherGradeViewOnlineController.confirmed=true;
                break;
            case 7:
                TeacherGradeViewManualController.confirmed=true;
                break;
            case 8:
                TeacherQuestionEditController.confirmed=true;
                break;
            case 9:
                TeacherQuestionAddController.confirmed=true;
                break;
            case 10:
                PrincipalRequestsController.close=true;
                break;
            case 11:
                PrincipalMakeReportController.close=true;
                break;
            default:
                break;
        }

        Stage popup = (Stage)buttonyes.getScene().getWindow();
        popup.close();
    }

    @FXML
    void initialize() {
        assert buttonyes != null : "fx:id=\"buttonyes\" was not injected: check your FXML file 'Finish Popup.fxml'.";
        assert buttonno != null : "fx:id=\"buttonno\" was not injected: check your FXML file 'Finish Popup.fxml'.";

    }
}
