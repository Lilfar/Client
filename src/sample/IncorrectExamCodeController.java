package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class IncorrectExamCodeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonclose;

    @FXML
    void buttoncloseclick(ActionEvent event) {
        Stage popup = (Stage)buttonclose.getScene().getWindow();
        popup.close();
    }

    @FXML
    void initialize() {
        assert buttonclose != null : "fx:id=\"buttonclose\" was not injected: check your FXML file 'Incorrect Exam Code.fxml'.";

    }
}
