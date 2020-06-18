package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class PrincipalMakeReportController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonback;

    @FXML
    private Button buttonmakereport;

    @FXML
    void buttonbackclick(ActionEvent event) {

    }

    @FXML
    void buttonmakereportclick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert buttonback != null : "fx:id=\"buttonback\" was not injected: check your FXML file 'Make Report.fxml'.";
        assert buttonmakereport != null : "fx:id=\"buttonmakereport\" was not injected: check your FXML file 'Make Report.fxml'.";

    }
}
