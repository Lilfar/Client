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

public class TeacherSubjectListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> subjectslist;

    @FXML
    private TableColumn<?, ?> subjects;

    @FXML
    private Button buttonlogout;

    public void buttonlogoutclick(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage)buttonlogout.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Login Menu.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void initialize() {
        assert subjectslist != null : "fx:id=\"subjectslist\" was not injected: check your FXML file 'Teacher Subject List.fxml'.";
        assert subjects != null : "fx:id=\"subjects\" was not injected: check your FXML file 'Teacher Subject List.fxml'.";
        assert buttonlogout != null : "fx:id=\"buttonlogout\" was not injected: check your FXML file 'Teacher Subject List.fxml'.";


    }


}
