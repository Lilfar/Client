

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

    static int from=0;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> examstable;

    @FXML
    private TableColumn<?, ?> exams;

    @FXML
    private TableColumn<?, ?> dates;

    @FXML
    private Button buttonback;

    @FXML
    void buttonbackclick(ActionEvent event) throws IOException {
        Stage stage = (Stage)buttonback.getScene().getWindow();
        Parent newRoot;
        switch (from)
        {
            case 31:
                newRoot = FXMLLoader.load(getClass().getResource("Subject List.fxml"));
                break;
            case 32:
                newRoot = FXMLLoader.load(getClass().getResource("Teachers List.fxml"));
                break;
            default:
                newRoot = FXMLLoader.load(getClass().getResource("Principal Main.fxml"));
                break;
        }
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void initialize() {
        assert examstable != null : "fx:id=\"examstable\" was not injected: check your FXML file 'Principal Exams.fxml'.";
        assert exams != null : "fx:id=\"exams\" was not injected: check your FXML file 'Principal Exams.fxml'.";
        assert dates != null : "fx:id=\"dates\" was not injected: check your FXML file 'Principal Exams.fxml'.";
        assert buttonback != null : "fx:id=\"buttonback\" was not injected: check your FXML file 'Principal Exams.fxml'.";

    }
}
