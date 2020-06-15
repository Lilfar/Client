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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ManagerRequestViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField ExamsName;

    @FXML
    private TextField TeachersName;

    @FXML
    private TextField ExtraTime;

    @FXML
    private TextField Explanation;

    @FXML
    private Button buttonaccept;

    @FXML
    private Button buttondecline;

    @FXML
    private Button buttonback;

    @FXML
    void buttonbackclick(ActionEvent event) throws IOException {
        Stage stage = (Stage)buttonback.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Manager Requests.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }


    @FXML
    void buttonacceptclick(ActionEvent event) {

    }

    @FXML
    void buttondeclineclick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert ExamsName != null : "fx:id=\"ExamsName\" was not injected: check your FXML file 'Manager Request View.fxml'.";
        assert TeachersName != null : "fx:id=\"TeachersName\" was not injected: check your FXML file 'Manager Request View.fxml'.";
        assert ExtraTime != null : "fx:id=\"ExtraTime\" was not injected: check your FXML file 'Manager Request View.fxml'.";
        assert Explanation != null : "fx:id=\"Explanation\" was not injected: check your FXML file 'Manager Request View.fxml'.";
        assert buttonaccept != null : "fx:id=\"buttonaccept\" was not injected: check your FXML file 'Manager Request View.fxml'.";
        assert buttondecline != null : "fx:id=\"buttondecline\" was not injected: check your FXML file 'Manager Request View.fxml'.";

    }
}
