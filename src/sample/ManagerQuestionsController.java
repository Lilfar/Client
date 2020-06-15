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

public class ManagerQuestionsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonsubjects;

    @FXML
    private Button buttonteachers;

    @FXML
    private Button buttonback;

    @FXML
    void buttonsubjectsclick(ActionEvent event) throws IOException {
        Stage stage = (Stage)buttonsubjects.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Manager Subject Questions.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void buttonbackclick(ActionEvent event) throws IOException {
        Stage stage = (Stage)buttonback.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Manager Main.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }


    @FXML
    void buttonteachersclick(ActionEvent event) throws IOException {
         Stage stage = (Stage)buttonteachers.getScene().getWindow();
         Parent newRoot = FXMLLoader.load(getClass().getResource("Manager Teacher Questions.fxml"));
         Scene scene = new Scene(newRoot);
         stage.setScene(scene);
    }

    @FXML
    void initialize() {
        assert buttonsubjects != null : "fx:id=\"buttonsubjects\" was not injected: check your FXML file 'Manager Questions.fxml'.";
        assert buttonteachers != null : "fx:id=\"buttonteachers\" was not injected: check your FXML file 'Manager Questions.fxml'.";

    }
}
