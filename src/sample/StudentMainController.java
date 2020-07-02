package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentMainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text texthellostudent;

    @FXML
    private Button buttonviewgrades;

    @FXML
    private Button buttontakeexam;

    @FXML
    private Button buttonlogout;

    @FXML
    void buttonlogoutclick(ActionEvent event) throws IOException {
        Stage stage = (Stage)buttonlogout.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Login Menu.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);

    }

    @FXML
    void buttontakeexamclick(ActionEvent event) throws IOException {

        Stage stage = (Stage)buttontakeexam.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Student Take Exam.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void buttonviewgradesclick(ActionEvent event) throws IOException {
        Stage stage = (Stage)buttonviewgrades.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Student Grades.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void initialize() {

        assert buttonviewgrades != null : "fx:id=\"buttonviewgrades\" was not injected: check your FXML file 'Student Main.fxml'.";
        assert buttontakeexam != null : "fx:id=\"buttontakeexam\" was not injected: check your FXML file 'Student Main.fxml'.";
        assert buttonlogout != null : "fx:id=\"buttonlogout\" was not injected: check your FXML file 'Student Main.fxml'.";

        texthellostudent.setText("Hello " + LoginMenuController.user.name + "!");
    }
}
