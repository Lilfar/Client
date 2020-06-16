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

public class StudentComputerExamController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonnext;

    @FXML
    private Button buttonprev;

    @FXML
    void buttonnextclick(ActionEvent event) throws IOException {
        Stage stage = (Stage)buttonnext.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Student Computer Exam.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void buttonprevclick(ActionEvent event) throws IOException {
        Stage stage = (Stage)buttonprev.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Student Computer Exam.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void initialize() {
        assert buttonnext != null : "fx:id=\"buttonnext\" was not injected: check your FXML file 'Student Computer Exam.fxml'.";
        assert buttonprev != null : "fx:id=\"buttonprev\" was not injected: check your FXML file 'Student Computer Exam.fxml'.";

    }
}
