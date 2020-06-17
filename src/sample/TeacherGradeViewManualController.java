package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TeacherGradeViewManualController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea Grade;

    @FXML
    private Button buttonchangegrade;

    @FXML
    private Button buttonstudentssolution;

    @FXML
    private Button buttonclose;

    @FXML
    void buttoncloseclick(ActionEvent event) {
        Stage popup = (Stage)buttonclose.getScene().getWindow();
        popup.close();
    }

    @FXML
    void buttonstudentssolutionclick(ActionEvent event) {

    }

    @FXML
    void buttonchangegradeclick(ActionEvent event) throws IOException {
        Stage popup = new Stage();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Change Grade.fxml"));
        Scene scene = new Scene(newRoot);
        popup.setScene(scene);
        popup.showAndWait();
    }

    @FXML
    void initialize() {
        assert Grade != null : "fx:id=\"Grade\" was not injected: check your FXML file 'Teacher Grade View Manual.fxml'.";
        assert buttonchangegrade != null : "fx:id=\"buttonchangegrade\" was not injected: check your FXML file 'Teacher Grade View Manual.fxml'.";
        assert buttonstudentssolution != null : "fx:id=\"buttonstudentssolution\" was not injected: check your FXML file 'Teacher Grade View Manual.fxml'.";
        assert buttonclose != null : "fx:id=\"Apply\" was not injected: check your FXML file 'Teacher Grade View Manual.fxml'.";

    }
}
