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

public class PrincipalExamsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonsubject;

    @FXML
    private Button buttonteachers;

    @FXML
    private Button buttonback;

    @FXML
    void buttonsubjectclick(ActionEvent event) throws IOException {
        Stage stage = (Stage)buttonsubject.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Principal Subject Questions.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void buttonbackclick(ActionEvent event) throws IOException {
        Stage stage = (Stage)buttonback.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Principal Main.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void buttonteachersclick(ActionEvent event) throws IOException {
        Stage stage = (Stage)buttonteachers.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Principal Teacher Questions.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void initialize() {
        assert buttonsubject != null : "fx:id=\"buttonsubject\" was not injected: check your FXML file 'Principal Exams.fxml'.";
        assert buttonteachers != null : "fx:id=\"buttonteachers\" was not injected: check your FXML file 'Principal Exams.fxml'.";

    }

}
