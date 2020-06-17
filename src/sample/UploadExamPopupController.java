package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class UploadExamPopupController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonback;

    @FXML
    void buttonbackclick(ActionEvent event) {

        Stage popup = (Stage)buttonback.getScene().getWindow();
        popup.close();
    }

    @FXML
    void initialize() {
        assert buttonback != null : "fx:id=\"buttonback\" was not injected: check your FXML file 'Upload Exam Popup.fxml'.";

    }
}
