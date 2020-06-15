package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ManagerMainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonquestions;

    @FXML
    private Button buttonexams;

    @FXML
    private Button buttongrades;

    @FXML
    private Button buttonrequestreview;

    @FXML
    void buttonexamsclick(ActionEvent event) {

    }

    @FXML
    void buttongradesclick(ActionEvent event) {

    }

    @FXML
    void buttonquestionsclick(ActionEvent event) {

    }

    @FXML
    void buttonrequestreviewclick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert buttonquestions != null : "fx:id=\"buttonquestions\" was not injected: check your FXML file 'Manager Main.fxml'.";
        assert buttonexams != null : "fx:id=\"buttonexams\" was not injected: check your FXML file 'Manager Main.fxml'.";
        assert buttongrades != null : "fx:id=\"buttongrades\" was not injected: check your FXML file 'Manager Main.fxml'.";
        assert buttonrequestreview != null : "fx:id=\"buttonrequestreview\" was not injected: check your FXML file 'Manager Main.fxml'.";

    }
}
