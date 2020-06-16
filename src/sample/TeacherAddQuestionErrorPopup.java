package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TeacherAddQuestionErrorPopup {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonok;

    @FXML
    void buttonokclick(ActionEvent event) {
        Stage popup = (Stage)buttonok.getScene().getWindow();
        popup.close();

    }


    @FXML
    void initialize() {
        assert buttonok != null : "fx:id=\"buttonok\" was not injected: check your FXML file 'Teacher Add Question Error Popup.fxml'.";

    }
}