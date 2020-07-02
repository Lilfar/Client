package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.clientClasses.Operation;
import sample.clientClasses.clientAccess;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TeacherCourseMainController {

    static int subjectid;
    static int courseid;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonshowexam;

    @FXML
    private Button buttonaddtime;

    @FXML
    private Button buttonstudentsgrades;

    @FXML
    private Button buttonback;

    @FXML
    private Text courseMenu;

    @FXML
    void buttonaddtimeclick(ActionEvent event) throws IOException {
        Stage popup = new Stage();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Active Exam Add Extra Time.fxml"));
        Scene scene = new Scene(newRoot);
        popup.setScene(scene);
        popup.showAndWait();
    }

    @FXML
    void buttonbackclick(ActionEvent event) throws IOException {
        Stage stage = (Stage)buttonback.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Courses List.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);

    }

    @FXML
    void buttonshowexamclick(ActionEvent event) throws IOException {
        TeacherShowExamController.subjectid=subjectid;
        TeacherShowExamController.courseid=courseid;
        Stage stage = (Stage)buttonshowexam.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Show exam.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void buttonstudentsgradesclick(ActionEvent event) throws IOException {
        TeacherStudentsAndGradesListController.from=1;
        Stage stage = (Stage)buttonstudentsgrades.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Students And Grades List.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);

    }

    @FXML
    void initialize() {
        assert buttonshowexam != null : "fx:id=\"buttonshowexam\" was not injected: check your FXML file 'Teacher Course Main.fxml'.";
        assert buttonaddtime != null : "fx:id=\"buttonaddtime\" was not injected: check your FXML file 'Teacher Course Main.fxml'.";
        assert buttonstudentsgrades != null : "fx:id=\"buttonstudentsgrades\" was not injected: check your FXML file 'Teacher Course Main.fxml'.";
        assert buttonback != null : "fx:id=\"buttonback\" was not injected: check your FXML file 'Teacher Course Main.fxml'.";

        //TeacherCoursesListController.courseId
        buttonaddtime.setVisible(false);

        clientAccess ca = new clientAccess();
        ca.op = Operation.isCourseActive;
        ca.courseID = TeacherCoursesListController.courseId;
        Main.client.send(ca, new StringFunction() {
            @Override
            public void handle(String s) {
                Boolean a = Main.g.fromJson(s,Boolean.class);
                buttonaddtime.setVisible(a);
            }
        });

        courseMenu.setText(TeacherCoursesListController.course.name + " menu");
    }
}
