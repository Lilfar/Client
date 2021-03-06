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

public class LoginFailPopupController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonback;

    @FXML
    void buttonbackclick(ActionEvent event) throws IOException {
        Stage popup = (Stage)buttonback.getScene().getWindow();
        popup.close();
    }
    @FXML
    void initialize() {
        assert buttonback != null : "fx:id=\"buttonback\" was not injected: check your FXML file 'Login Fail Popup.fxml'.";

    }
}
