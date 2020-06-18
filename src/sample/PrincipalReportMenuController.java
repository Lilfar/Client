package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrincipalReportMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonteacherexam;

    @FXML
    private Button buttonsubjectexam;

    @FXML
    private Button buttonstudentexam;

    @FXML
    private Button buttonback;

    @FXML
    void buttonbackclick(ActionEvent event) throws IOException {
        Stage stage = (Stage)buttonback.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Principal Main.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void buttonstudentexamclick(ActionEvent event) {

    }

    @FXML
    void buttonsubjectexamclick(ActionEvent event) {

    }

    @FXML
    void buttonteacherexamclick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert buttonteacherexam != null : "fx:id=\"buttonteacherexam\" was not injected: check your FXML file 'Principal Report Menu.fxml'.";
        assert buttonsubjectexam != null : "fx:id=\"buttonsubjectexam\" was not injected: check your FXML file 'Principal Report Menu.fxml'.";
        assert buttonstudentexam != null : "fx:id=\"buttonstudentexam\" was not injected: check your FXML file 'Principal Report Menu.fxml'.";
        assert buttonback != null : "fx:id=\"buttonback\" was not injected: check your FXML file 'Principal Report Menu.fxml'.";

    }
}
