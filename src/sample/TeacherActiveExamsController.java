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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class TeacherActiveExamsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> ExamsTable;

    @FXML
    private TableColumn<?, ?> Exams;

    @FXML
    private Button buttonback;

    @FXML
    void buttonbackclick(ActionEvent event) throws IOException {

        Stage stage = (Stage)buttonback.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Main.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);

    }
    @FXML
    void initialize() {
        assert ExamsTable != null : "fx:id=\"ExamsTable\" was not injected: check your FXML file 'Teacher Active Exams.fxml'.";
        assert Exams != null : "fx:id=\"Exams\" was not injected: check your FXML file 'Teacher Active Exams.fxml'.";

    }
}
