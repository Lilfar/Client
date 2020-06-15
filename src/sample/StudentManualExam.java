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

public class StudentManualExam {

    static boolean close = false;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttondownloadexam;

    @FXML
    private Button buttonuploadexam;

    @FXML
    private Button buttondone;

    @FXML
    void buttondoneclick(ActionEvent event) throws IOException {

        Stage popup = new Stage();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Student Manual Exam Popup1.fxml"));
        Scene scene = new Scene(newRoot);
        popup.setScene(scene);
        popup.showAndWait();

        if (close)
        {
            close=!close;
            Stage stage = (Stage)buttondone.getScene().getWindow();
            Parent newRoot2 = FXMLLoader.load(getClass().getResource("Student Main.fxml"));
            Scene scene2 = new Scene(newRoot2);
            stage.setScene(scene2);
        }
    }

    @FXML
    void buttondownloadexamclick(ActionEvent event) {

    }

    @FXML
    void buttonuploadexamclick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert buttondownloadexam != null : "fx:id=\"buttondownloadexam\" was not injected: check your FXML file 'Student Manual Exam.fxml'.";
        assert buttonuploadexam != null : "fx:id=\"buttonuploadexam\" was not injected: check your FXML file 'Student Manual Exam.fxml'.";
        assert buttondone != null : "fx:id=\"buttondone\" was not injected: check your FXML file 'Student Manual Exam.fxml'.";

    }
}
