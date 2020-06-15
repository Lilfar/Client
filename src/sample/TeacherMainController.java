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

public class TeacherMainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonshowexams;

    @FXML
    private Button buttonshowquestions;

    @FXML
    private Button buttonfinishedexams;

    @FXML
    private Button buttonactiveexams;

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
    void buttonactiveexamsclick(ActionEvent event) throws IOException {
        Stage stage = (Stage)buttonactiveexams.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Active Exams.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);

    }

    @FXML
    void buttonfinishedexamsclick(ActionEvent event) throws IOException {
            Stage stage = (Stage)buttonfinishedexams.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Finished Exams List.fxml"));
            Scene scene = new Scene(newRoot);
            stage.setScene(scene);

    }

    @FXML
    void buttonshowexamsclick(ActionEvent event) throws IOException {
        Stage stage = (Stage)buttonshowexams.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Exams List.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void buttonshowquestionsclick(ActionEvent event) throws IOException {
        Stage stage = (Stage)buttonshowquestions.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Question List.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void initialize() {
        assert buttonshowexams != null : "fx:id=\"buttonshowexams\" was not injected: check your FXML file 'Teacher Main.fxml'.";
        assert buttonshowquestions != null : "fx:id=\"buttonshowquestions\" was not injected: check your FXML file 'Teacher Main.fxml'.";
        assert buttonfinishedexams != null : "fx:id=\"buttonfinishedexams\" was not injected: check your FXML file 'Teacher Main.fxml'.";
        assert buttonactiveexams != null : "fx:id=\"buttonactiveexams\" was not injected: check your FXML file 'Teacher Main.fxml'.";

    }
}
