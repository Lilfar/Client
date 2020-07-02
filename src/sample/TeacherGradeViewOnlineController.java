package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.clientClasses.Operation;
import sample.clientClasses.clientAccess;
import sample.clientClasses.clientQuestion;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TeacherGradeViewOnlineController {


    static  boolean confirmed = false;
    static int from;
    static double grade;


    static int courseId;
    static String studentId;
    @FXML
    private ResourceBundle resources;

    @FXML
    private TableColumn<clientQuestion, String > studentsAnswer;

    @FXML
    private URL location;

    @FXML
    private ImageView Background;

    @FXML
    private TextArea Grade;

    @FXML
    private Button buttonchangegrade;

    @FXML
    private TableView<clientQuestion> QuestionsTableSubject;

    @FXML
    private TableColumn<clientQuestion, String> Question;

    @FXML
    private TableColumn<clientQuestion, String> RightAnswer;

    @FXML
    private TableColumn<clientQuestion, String> WrongAnswer1;

    @FXML
    private TableColumn<clientQuestion, String> WrongAnswer2;

    @FXML
    private TableColumn<clientQuestion, String> WrongAnswer3;

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
        clientAccess ca=new clientAccess();
        ca.op=Operation.confirmGrade;
        ca.studentID=studentId;
        ca.courseID=courseId;
        Main.client.send(ca, new StringFunction() {
            @Override
            public void handle(String s) {

            }
        });
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
        assert Background !=null : "fx:id=\"Background\" was not injected: check your FXML file 'Login Menu.fxml'.";

        assert Grade != null : "fx:id=\"Grade\" was not injected: check your FXML file 'Teacher Grade View Online.fxml'.";
        assert buttonchangegrade != null : "fx:id=\"buttonchangegrade\" was not injected: check your FXML file 'Teacher Grade View Online.fxml'.";
        assert QuestionsTableSubject != null : "fx:id=\"QuestionsTableSubject\" was not injected: check your FXML file 'Teacher Grade View Online.fxml'.";
        assert Question != null : "fx:id=\"Question\" was not injected: check your FXML file 'Teacher Grade View Online.fxml'.";
        assert RightAnswer != null : "fx:id=\"RightAnswer\" was not injected: check your FXML file 'Teacher Grade View Online.fxml'.";
        assert WrongAnswer1 != null : "fx:id=\"WrongAnswer1\" was not injected: check your FXML file 'Teacher Grade View Online.fxml'.";
        assert WrongAnswer2 != null : "fx:id=\"WrongAnswer2\" was not injected: check your FXML file 'Teacher Grade View Online.fxml'.";
        assert WrongAnswer3 != null : "fx:id=\"WrongAnswer3\" was not injected: check your FXML file 'Teacher Grade View Online.fxml'.";
        assert studentsAnswer != null : "fx:id=\"studentsAnswer\" was not injected: check your FXML file 'Teacher Grade View Online.fxml'.";
        assert buttonclose != null : "fx:id=\"buttonclose\" was not injected: check your FXML file 'Teacher Grade View Online.fxml'.";
        assert buttonconfirmgrade != null : "fx:id=\"buttonconfirmgrade\" was not injected: check your FXML file 'Teacher Grade View Online.fxml'.";
        Grade.setText(Double.toString(grade));
        courseId=TeacherCoursesListController.courseId;
        studentId=TeacherStudentsAndGradesListController.studentId;
        clientAccess ca=new clientAccess();
        ca.op= Operation.getStudentAnswers;
        ca.studentID = studentId;
        ca.courseID=courseId;
        Main.client.send(ca, new StringFunction() {
            @Override
            public void handle(String s) {
                final clientQuestion[] questionList = Main.g.fromJson(s, clientQuestion[].class);
                final ObservableList<clientQuestion> data = FXCollections.observableArrayList(questionList);
                Question.setCellValueFactory(new PropertyValueFactory<clientQuestion, String>("question"));
                RightAnswer.setCellValueFactory(new PropertyValueFactory<clientQuestion, String>("right"));
                WrongAnswer1.setCellValueFactory(new PropertyValueFactory<clientQuestion, String>("wrong1"));
                WrongAnswer2.setCellValueFactory(new PropertyValueFactory<clientQuestion, String>("wrong2"));
                WrongAnswer3.setCellValueFactory(new PropertyValueFactory<clientQuestion, String>("wrong3"));
                studentsAnswer.setCellValueFactory(new PropertyValueFactory<clientQuestion, String>("studentAnswer"));
                QuestionsTableSubject.setItems(data);
            }
        });
    }
}
