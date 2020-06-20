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

public class StudentExamFirstPageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonstart;

    @FXML
    void buttonstartclick(ActionEvent event) throws IOException {
        Stage stage = (Stage)buttonstart.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Student Computer Exam.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);

    }

    @FXML
    void initialize() {
        assert buttonstart != null : "fx:id=\"buttonstart\" was not injected: check your FXML file 'Student Exam First Page.fxml'.";

    }
}
