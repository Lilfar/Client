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
    private Button buttonrequests;

    @FXML
    void buttonexamsclick(ActionEvent event) throws IOException {

        Stage stage = (Stage)buttonexams.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Manager Exams.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void buttongradesclick(ActionEvent event) throws IOException {

        Stage stage = (Stage)buttongrades.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Manager Grades.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void buttonquestionsclick(ActionEvent event) throws IOException {

        Stage stage = (Stage)buttonquestions.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Manager Questions.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void buttonrequestsclick(ActionEvent event) throws IOException {

        Stage stage = (Stage)buttonrequests.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Manager Requests.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void initialize() {
        assert buttonquestions != null : "fx:id=\"buttonquestions\" was not injected: check your FXML file 'Manager Main.fxml'.";
        assert buttonexams != null : "fx:id=\"buttonexams\" was not injected: check your FXML file 'Manager Main.fxml'.";
        assert buttongrades != null : "fx:id=\"buttongrades\" was not injected: check your FXML file 'Manager Main.fxml'.";
        assert buttonrequests != null : "fx:id=\"buttonrequests\" was not injected: check your FXML file 'Manager Main.fxml'.";

    }
}
