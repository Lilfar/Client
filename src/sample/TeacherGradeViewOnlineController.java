package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TeacherGradeViewOnlineController {


    static  boolean confirmed = false;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea Grade;

    @FXML
    private Button buttonchangegrade;

    @FXML
    private TableView<?> QuestionsTableSubject;

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
    private Button buttonclose;

    @FXML
    private Button buttonconfirmgrade;

    @FXML
    void buttoncloseclick(ActionEvent event) {
        Stage popup = (Stage)buttonclose.getScene().getWindow();
        popup.close();
    }

    @FXML
    void buttonchangegradeclick(ActionEvent event) throws IOException {
        Stage popup = new Stage();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Change Grade.fxml"));
        Scene scene = new Scene(newRoot);
        popup.setScene(scene);
        popup.showAndWait();
    }
    @FXML
    void buttonconfirmgradeclick(ActionEvent event) throws IOException {
        FinishPopupController.from=6;
        Stage popup = new Stage();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Finish Popup.fxml"));
        Scene scene = new Scene(newRoot);
        popup.setScene(scene);
        popup.showAndWait();
        if (confirmed){
            confirmed=!confirmed;
            buttonconfirmgrade.setVisible(false);
        }
    }

    @FXML
    void initialize() {
        assert Grade != null : "fx:id=\"Grade\" was not injected: check your FXML file 'Teacher Grade View Online.fxml'.";
        assert buttonchangegrade != null : "fx:id=\"buttonchangegrade\" was not injected: check your FXML file 'Teacher Grade View Online.fxml'.";
        assert QuestionsTableSubject != null : "fx:id=\"QuestionsTableSubject\" was not injected: check your FXML file 'Teacher Grade View Online.fxml'.";
        assert Question != null : "fx:id=\"Question\" was not injected: check your FXML file 'Teacher Grade View Online.fxml'.";
        assert RightAnswer != null : "fx:id=\"RightAnswer\" was not injected: check your FXML file 'Teacher Grade View Online.fxml'.";
        assert WrongAnswer1 != null : "fx:id=\"WrongAnswer1\" was not injected: check your FXML file 'Teacher Grade View Online.fxml'.";
        assert WrongAnswer2 != null : "fx:id=\"WrongAnswer2\" was not injected: check your FXML file 'Teacher Grade View Online.fxml'.";
        assert WrongAnswer3 != null : "fx:id=\"WrongAnswer3\" was not injected: check your FXML file 'Teacher Grade View Online.fxml'.";
        assert buttonclose != null : "fx:id=\"buttonclose\" was not injected: check your FXML file 'Teacher Grade View Online.fxml'.";
        assert buttonconfirmgrade != null : "fx:id=\"buttonconfirmgrade\" was not injected: check your FXML file 'Teacher Grade View Online.fxml'.";

    }
}
