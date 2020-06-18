package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrincipalExamsController {

    int from=0;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> ExamsTableTeacher;

    @FXML
    private TableColumn<?, ?> exams;

    @FXML
    private TableColumn<?, ?> Date;

    @FXML
    private Button buttonback;

    @FXML
    void buttonbackclick(ActionEvent event) throws IOException {

        Stage stage = (Stage)buttonback.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Teachers list.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void initialize() {
        assert ExamsTableTeacher != null : "fx:id=\"ExamsTableTeacher\" was not injected: check your FXML file 'Principal Exams.fxml'.";
        assert exams != null : "fx:id=\"exams\" was not injected: check your FXML file 'Principal Exams.fxml'.";
        assert Date != null : "fx:id=\"Date\" was not injected: check your FXML file 'Principal Exams.fxml'.";
        assert buttonback != null : "fx:id=\"buttonback\" was not injected: check your FXML file 'Principal Exams.fxml'.";

    }
}
