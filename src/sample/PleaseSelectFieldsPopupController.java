package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PleaseSelectFieldsPopupController {

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
        assert buttonok != null : "fx:id=\"buttonok\" was not injected: check your FXML file 'Please Select Fields Popup.fxml'.";

    }
}
