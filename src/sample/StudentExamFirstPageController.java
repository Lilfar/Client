package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentExamFirstPageController {

    static int examid;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView Background;


    @FXML
    private TextArea Note;

    @FXML
    private Button buttonstart;

    @FXML
    void buttonstartclick(ActionEvent event) throws IOException {
        if(StudentTakeExamController.downloaded) {
            Stage stage = (Stage) buttonstart.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(getClass().getResource("Student Computer Exam.fxml"));
            Scene scene = new Scene(newRoot);
            stage.setScene(scene);
        }
    }
    @FXML
    void initialize() {
        assert Background !=null : "fx:id=\"Background\" was not injected: check your FXML file 'Login Menu.fxml'.";
        assert buttonstart != null : "fx:id=\"buttonstart\" was not injected: check your FXML file 'Student Exam First Page.fxml'.";

        Note.setText(StudentComputerExamController.exam.note);
    }
}
