package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TeacherCoursesListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonback;

    @FXML
    private TableColumn<?, ?> courses;

    @FXML
    private TableColumn<?, ?> buttons;

    @FXML
    void buttonbackclick(ActionEvent event) throws IOException {
            Stage stage = (Stage)buttonback.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Subject Main.fxml"));
            Scene scene = new Scene(newRoot);
            stage.setScene(scene);
        }

    @FXML
    void initialize() {
        assert buttonback != null : "fx:id=\"buttonback\" was not injected: check your FXML file 'Teacher Courses List.fxml'.";

    }
}
