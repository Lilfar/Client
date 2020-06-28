package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentManualExamController {

    static boolean close = false;
    boolean uploaded=false;

    @FXML
    private ResourceBundle resources;

    @FXML
    private ImageView Background;

    @FXML
    private URL location;

    @FXML
    private Button buttondownloadexam;

    @FXML
    private Button buttonuploadexam;

    @FXML
    private Button buttondone;

    @FXML
    private Button buttonback;

    @FXML
    private TextField textexamupload;

    @FXML
    void buttonbackclick(ActionEvent event) throws IOException {
        Stage stage = (Stage)buttonback.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Student Take Exam.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void buttondoneclick(ActionEvent event) throws IOException {

        boolean done;

        Stage popup = new Stage();
        Parent newRoot;

        if (uploaded)
            done = true;
        else
            done = false;

        if (done)
        {

            FinishPopupController.from=2;
            newRoot = FXMLLoader.load(getClass().getResource("Finish Popup.fxml"));

            Scene scene = new Scene(newRoot);
            popup.setScene(scene);
            popup.showAndWait();

            if (close){
                close=!close;
                Stage stage = (Stage)buttondone.getScene().getWindow();
                newRoot = FXMLLoader.load(getClass().getResource("Student Main.fxml"));
                scene = new Scene(newRoot);
                stage.setScene(scene);
            }
        }
        else
        {
            newRoot = FXMLLoader.load(getClass().getResource("Upload Exam Popup.fxml"));
            Scene scene = new Scene(newRoot);
            popup.setScene(scene);
            popup.showAndWait();
        }

    }

    @FXML
    void buttondownloadexamclick(ActionEvent event) throws IOException {

        Stage popup = new Stage();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Item Downloaded Successfully.fxml"));
        Scene scene = new Scene(newRoot);
        popup.setScene(scene);
        popup.showAndWait();

    }

    @FXML
    void buttonuploadexamclick(ActionEvent event) throws IOException {

        if (!textexamupload.getText().isBlank())
        {
            uploaded=true;
            Stage popup = new Stage();
            Parent newRoot = FXMLLoader.load(getClass().getResource("Item Uploaded Successfully.fxml"));
            Scene scene = new Scene(newRoot);
            popup.setScene(scene);
            popup.showAndWait();
        }

    }

    @FXML
    void initialize() {
        assert Background !=null : "fx:id=\"Background\" was not injected: check your FXML file 'Login Menu.fxml'.";
        assert buttondownloadexam != null : "fx:id=\"buttondownloadexam\" was not injected: check your FXML file 'Student Manual Exam.fxml'.";
        assert buttonuploadexam != null : "fx:id=\"buttonuploadexam\" was not injected: check your FXML file 'Student Manual Exam.fxml'.";
        assert buttondone != null : "fx:id=\"buttondone\" was not injected: check your FXML file 'Student Manual Exam.fxml'.";

    }
}
