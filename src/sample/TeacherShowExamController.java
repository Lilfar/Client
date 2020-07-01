package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.clientClasses.Operation;
import sample.clientClasses.clientAccess;
import sample.clientClasses.clientQuestion;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import sample.clientClasses.*;

public class TeacherShowExamController implements Initializable {


    boolean itemselected = false;

    @FXML
    private ResourceBundle resources;
    @FXML
    private ImageView Background;
    @FXML
    private URL location;

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
    private Button buttondownloadexam;

    @FXML
    private TextField duration;

    @FXML
    private RadioButton onlineradio;

    @FXML
    private RadioButton manualradio;

    @FXML
    private Button buttonback;

    @FXML
    private TextField accessCode;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        QuestionsTableSubject.setOnMousePressed(e ->{
            if (e.getClickCount() == 1 && e.isPrimaryButtonDown() ){
                itemselected=true;
            }
        });

        clientAccess ca=new clientAccess();
        ca.op= Operation.courseExam;
        ca.courseID=TeacherCoursesListController.courseId;
        Main.client.send(ca, new StringFunction() {
            @Override
            public void handle(String s) {
                final clientExam exam= Main.g.fromJson(s, clientExam.class);
                ArrayList<clientQuestion> questionList=exam.questions;
                final ObservableList<clientQuestion> data = FXCollections.observableArrayList(questionList);
                Question.setCellValueFactory(new PropertyValueFactory<clientQuestion, String>("question"));
                RightAnswer.setCellValueFactory(new PropertyValueFactory<clientQuestion, String>("right"));
                WrongAnswer1.setCellValueFactory(new PropertyValueFactory<clientQuestion, String>("wrong1"));
                WrongAnswer2.setCellValueFactory(new PropertyValueFactory<clientQuestion, String>("wrong2"));
                WrongAnswer3.setCellValueFactory(new PropertyValueFactory<clientQuestion, String>("wrong3"));
                QuestionsTableSubject.setItems(data);
            }
        });
    }

    @FXML
    void onlineradioclick(ActionEvent event) throws IOException {
        onlineradio.setSelected(true);
        manualradio.setSelected(false);
    }

    @FXML
    void manualradioclick(ActionEvent event) throws IOException {
        onlineradio.setSelected(false);
        manualradio.setSelected(true);
    }

    @FXML
    void buttonbackclick(ActionEvent event) throws IOException {
        Stage stage = (Stage)buttonback.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Course Main.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void buttondownloadexamclick(ActionEvent event) throws IOException {

        // button is named download but it is actually a start button

        if (accessCode.getText().isBlank() || duration.getText().isBlank() ||
                (onlineradio.isSelected()==false && manualradio.isSelected()==false))
        {
            Stage popup = new Stage();
            Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Add Question Error Popup.fxml"));
            Scene scene = new Scene(newRoot);
            popup.setScene(scene);
            popup.showAndWait();
        }
        else {
            clientAccess ca = new clientAccess();
            ca.op = Operation.startExam;
            ca.duration = 60 * Integer.parseInt(duration.getText());
            ca.AccessCode = Integer.parseInt(accessCode.getText());
            ca.courseID = TeacherCoursesListController.courseId;
            if (onlineradio.isSelected()) {
                ca.online = 1;
            } else
                ca.online = 0;
            Main.client.send(ca, new StringFunction() {
                @Override
                public void handle(String s) {
                }
            });
        }
    }

    @FXML
    void initialize() {
        assert Background !=null : "fx:id=\"Background\" was not injected: check your FXML file 'Login Menu.fxml'.";
        assert QuestionsTableSubject != null : "fx:id=\"QuestionsTableSubject\" was not injected: check your FXML file 'Teacher Show Exam.fxml'.";
        assert Question != null : "fx:id=\"Question\" was not injected: check your FXML file 'Teacher Show Exam.fxml'.";
        assert RightAnswer != null : "fx:id=\"RightAnswer\" was not injected: check your FXML file 'Teacher Show Exam.fxml'.";
        assert WrongAnswer1 != null : "fx:id=\"WrongAnswer1\" was not injected: check your FXML file 'Teacher Show Exam.fxml'.";
        assert WrongAnswer2 != null : "fx:id=\"WrongAnswer2\" was not injected: check your FXML file 'Teacher Show Exam.fxml'.";
        assert WrongAnswer3 != null : "fx:id=\"WrongAnswer3\" was not injected: check your FXML file 'Teacher Show Exam.fxml'.";
        assert buttondownloadexam != null : "fx:id=\"buttondownloadexam\" was not injected: check your FXML file 'Teacher Show Exam.fxml'.";
        assert buttonback != null : "fx:id=\"buttonback\" was not injected: check your FXML file 'Teacher Show Exam.fxml'.";
        assert duration != null : "fx:id=\"duration\" was not injected: check your FXML file 'Teacher Show Exam.fxml'.";
        assert onlineradio != null : "fx:id=\"onlineradioclick\" was not injected: check your FXML file 'Teacher Show Exam.fxml'.";
        assert manualradio != null : "fx:id=\"manualradioclick\" was not injected: check your FXML file 'Teacher Show Exam.fxml'.";
        assert accessCode != null : "fx:id=\"accessCode\" was not injected: check your FXML file 'Teacher Show Exam.fxml'.";
    }
}
