package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TeacherSubjectExamsListController {
    static public int subjectId;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private ImageView Background;
    @FXML
    private TableColumn<?, ?> ExamsTable;

    @FXML
    private Button buttoncreateexam;

    @FXML
    private Button buttonback;

    @FXML
    void buttonbackclick(ActionEvent event) throws IOException {

        Stage stage = (Stage)buttonback.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Subject Main.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void buttoncreateexamclick(ActionEvent event) throws IOException {


        Stage stage = (Stage)buttoncreateexam.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Create Exam.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);

    }

    @FXML
    void initialize() {
        assert Background !=null : "fx:id=\"Background\" was not injected: check your FXML file 'Login Menu.fxml'.";

        assert ExamsTable != null : "fx:id=\"ExamsTable\" was not injected: check your FXML file 'Teacher Subject Exams List.fxml'.";
        assert buttoncreateexam != null : "fx:id=\"buttoncreateexam\" was not injected: check your FXML file 'Teacher Subject Exams List.fxml'.";

    }
}
