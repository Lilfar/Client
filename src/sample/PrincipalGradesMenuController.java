package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrincipalGradesMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private ImageView Background;

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
        StudentsListController.from=33;
        Stage stage = (Stage)buttonstudent.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Students List.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void buttonsubjectsclick(ActionEvent event) throws IOException {
        SubjectListController.from=33;
        Stage stage = (Stage)buttonsubjects.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Subject List.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void buttonteachersclick(ActionEvent event) throws IOException {
        TeachersListController.from=33;
        Stage stage = (Stage)buttonteachers.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Teachers List.fxml"));
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
    void initialize() {
        assert Background != null : "fx:id=\"Background\" was not injected: check your FXML file 'Login Menu.fxml'.";
        assert buttonteachers != null : "fx:id=\"buttonteachers\" was not injected: check your FXML file 'Principal Grades Menu.fxml'.";
        assert buttonsubjects != null : "fx:id=\"buttonsubjects\" was not injected: check your FXML file 'Principal Grades Menu.fxml'.";
        assert buttonstudent != null : "fx:id=\"buttonstudent\" was not injected: check your FXML file 'Principal Grades Menu.fxml'.";

    }
}
