
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

public class PrincipalQuestionsController {
    static int from=0;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> questionstable;

    @FXML
    private TableColumn<?, ?> Question;

    @FXML
    private TableColumn<?, ?> RightAnswer;

    @FXML
    private TableColumn<?, ?> WrongAnswer1;

    @FXML
    private TableColumn<?, ?> WrongAnswer2;

    @FXML
    private TableColumn<?, ?> WrongAnswer3;

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
        assert questionstable != null : "fx:id=\"questionstable\" was not injected: check your FXML file 'Principal Questions.fxml'.";
        assert Question != null : "fx:id=\"Question\" was not injected: check your FXML file 'Principal Questions.fxml'.";
        assert RightAnswer != null : "fx:id=\"RightAnswer\" was not injected: check your FXML file 'Principal Questions.fxml'.";
        assert WrongAnswer1 != null : "fx:id=\"WrongAnswer1\" was not injected: check your FXML file 'Principal Questions.fxml'.";
        assert WrongAnswer2 != null : "fx:id=\"WrongAnswer2\" was not injected: check your FXML file 'Principal Questions.fxml'.";
        assert WrongAnswer3 != null : "fx:id=\"WrongAnswer3\" was not injected: check your FXML file 'Principal Questions.fxml'.";
        assert buttonback != null : "fx:id=\"buttonback\" was not injected: check your FXML file 'Principal Questions.fxml'.";

    }
}
