package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import sample.clientClasses.*;

public class TeacherSubjectMainController {
    clientAccess ca=new clientAccess();
    static public int subjectId;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonshowexams;

    @FXML
    private Button buttonshowquestions;

    @FXML
    private Button buttonfinishedexams;

    @FXML
    private Button buttonshowcourses;

    @FXML
    private ImageView Background;

    @FXML
    private Button buttonback;

    @FXML
    private Text subjectMenu;

    @FXML
    private Text helloTeacher;


    @FXML
    void buttonbackclick(ActionEvent event) throws IOException {
        Stage stage = (Stage)buttonback.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Subject List.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void buttonfinishedexamsclick(ActionEvent event) throws IOException {
        TeacherSubjectFinishedExamStudentsListController.subjectId=this.subjectId;
        Stage stage = (Stage)buttonfinishedexams.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Subject Finished Exam Students List.fxml"));
            Scene scene = new Scene(newRoot);
            stage.setScene(scene);
    }
    @FXML
    void buttonshowexamsclick(ActionEvent event) throws IOException {
        TeacherSubjectExamsListController.subjectId=this.subjectId;
        Stage stage = (Stage)buttonshowexams.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Subject Exams List.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void buttonshowquestionsclick(ActionEvent event) throws IOException {
        TeacherQuestionListController.subjectId=this.subjectId;
        Stage stage = (Stage)buttonshowquestions.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Question List.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void buttonshowcoursesclick(ActionEvent event) throws IOException {
        TeacherCoursesListController.subjectId=this.subjectId;
        Stage stage = (Stage)buttonshowcourses.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Courses List.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void initialize() {
        assert Background != null : "fx:id=\"Background\" was not injected: check your FXML file 'Login Menu.fxml'.";
        assert buttonshowexams != null : "fx:id=\"buttonshowexams\" was not injected: check your FXML file 'Teacher Subject Main.fxml'.";
        assert buttonshowquestions != null : "fx:id=\"buttonshowquestions\" was not injected: check your FXML file 'Teacher Subject Main.fxml'.";
        assert buttonfinishedexams != null : "fx:id=\"buttonfinishedexams\" was not injected: check your FXML file 'Teacher Subject Main.fxml'.";
        assert buttonshowcourses != null : "fx:id=\"buttonshowcourses\" was not injected: check your FXML file 'Teacher Subject Main.fxml'.";
        assert buttonback != null : "fx:id=\"buttonback\" was not injected: check your FXML file 'Teacher Subject Main.fxml'.";

        helloTeacher.setText("Hello " + LoginMenuController.user.name + "!");
        subjectMenu.setText(SubjectListController.subj.Name + " menu!");

    }
}
