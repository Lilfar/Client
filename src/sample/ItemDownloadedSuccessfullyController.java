package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ItemDownloadedSuccessfullyController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttondone;

    @FXML
    void buttondoneclick(ActionEvent event) {

        Stage popup = (Stage)buttondone.getScene().getWindow();
        popup.close();
    }

    @FXML
    void initialize() {
        assert buttondone != null : "fx:id=\"buttondone\" was not injected: check your FXML file 'Item Downloaded Successfully.fxml'.";

    }
}
