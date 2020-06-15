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

public class ManagerGradesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonteachers;

    @FXML
    private Button buttonsubjects;

    @FXML
    private Button buttonstudent;

    @FXML
    private Button buttonback;

    @FXML
    void buttonstudentclick(ActionEvent event) throws IOException {
        Stage stage = (Stage)buttonstudent.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Manager Grades Students.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void buttonsubjectsclick(ActionEvent event) throws IOException {
        Stage stage = (Stage)buttonsubjects.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Manager Grades Subjects.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void buttonteachersclick(ActionEvent event) throws IOException {
        Stage stage = (Stage)buttonteachers.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Manager Grades Teacher.fxml"));
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
    void initialize() {
        assert buttonteachers != null : "fx:id=\"buttonteachers\" was not injected: check your FXML file 'Manager Grades.fxml'.";
        assert buttonsubjects != null : "fx:id=\"buttonsubjects\" was not injected: check your FXML file 'Manager Grades.fxml'.";
        assert buttonstudent != null : "fx:id=\"buttonstudent\" was not injected: check your FXML file 'Manager Grades.fxml'.";

    }
}
