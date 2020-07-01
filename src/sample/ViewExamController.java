package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.clientClasses.Operation;
import sample.clientClasses.clientAccess;
import sample.clientClasses.clientExam;
import sample.clientClasses.clientQuestion;

public class ViewExamController {

    static int from;
    static int examId;

    static int courseID;
    static String studentID;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<clientQuestion> QuestionsTable;

    @FXML
    private TableColumn<clientQuestion, Integer> questionId;

    @FXML
    private TableColumn<clientQuestion, String> Question;

    @FXML
    private TableColumn<clientQuestion, String> RightAnswer;

    @FXML
    private TableColumn<clientQuestion, Integer> studentAnswer;

    @FXML
    private TableColumn<clientQuestion, String> WrongAnswer1;

    @FXML
    private TableColumn<clientQuestion, String> WrongAnswer2;

    @FXML
    private TableColumn<clientQuestion, String> WrongAnswer3;

    @FXML
    private Button buttonback;

    @FXML
    private TextArea studentnote;

    @FXML
    private TextArea teachernote;

    @FXML
    private Text studentlabel;

    @FXML
    private Text teacherlabel;

    @FXML
    void buttonbackclick(ActionEvent event) throws IOException {

        Stage stage = (Stage)buttonback.getScene().getWindow();
        Parent newRoot;
        switch (from)
        {
            //Principal exams subject/teacher doubleclick - exambysubject exambyteacher
            //student show grades double click 1
            //teacher subject show exams double click

            case 1:
                newRoot = FXMLLoader.load(getClass().getResource("Student Grades.fxml"));
                break;
            case 2:
                newRoot = FXMLLoader.load(getClass().getResource("Teacher Subject Exams List.fxml"));
                break;
            case 331:
                newRoot = FXMLLoader.load(getClass().getResource("Principal Exams.fxml"));
                break;
            case 332:
                newRoot = FXMLLoader.load(getClass().getResource("Principal Exams.fxml"));
                break;
            default:
                newRoot = FXMLLoader.load(getClass().getResource("Student Grades.fxml"));
                break;
        }
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void initialize() {
        assert QuestionsTable != null : "fx:id=\"QuestionsTable\" was not injected: check your FXML file 'View Exam.fxml'.";
        assert questionId != null : "fx:id=\"questionId\" was not injected: check your FXML file 'View Exam.fxml'.";
        assert Question != null : "fx:id=\"Question\" was not injected: check your FXML file 'View Exam.fxml'.";
        assert RightAnswer != null : "fx:id=\"RightAnswer\" was not injected: check your FXML file 'View Exam.fxml'.";
        assert WrongAnswer1 != null : "fx:id=\"WrongAnswer1\" was not injected: check your FXML file 'View Exam.fxml'.";
        assert WrongAnswer2 != null : "fx:id=\"WrongAnswer2\" was not injected: check your FXML file 'View Exam.fxml'.";
        assert WrongAnswer3 != null : "fx:id=\"WrongAnswer3\" was not injected: check your FXML file 'View Exam.fxml'.";
        assert buttonback != null : "fx:id=\"buttonback\" was not injected: check your FXML file 'View Exam.fxml'.";
        assert studentnote != null : "fx:id=\"studentnote\" was not injected: check your FXML file 'View Exam.fxml'.";
        assert teachernote != null : "fx:id=\"teachernote\" was not injected: check your FXML file 'View Exam.fxml'.";



        if(from == 1){
            clientAccess ca = new clientAccess();
            ca.op = Operation.getStudentAnswers;
            ca.studentID = studentID;
            ca.courseID = courseID;
            Main.client.send(ca, new StringFunction() {
                @Override
                public void handle(String s) {
                    final clientQuestion[] questionList = Main.g.fromJson(s, clientQuestion[].class);
                    studentnote.setVisible(false);
                    teachernote.setVisible(false);
                    studentlabel.setVisible(false);
                    teacherlabel.setVisible(false);
                    final ObservableList<clientQuestion> data = FXCollections.observableArrayList(questionList);
                    Question.setCellValueFactory(new PropertyValueFactory<clientQuestion, String>("question"));
                    RightAnswer.setCellValueFactory(new PropertyValueFactory<clientQuestion, String>("right"));
                    WrongAnswer1.setCellValueFactory(new PropertyValueFactory<clientQuestion, String>("wrong1"));
                    WrongAnswer2.setCellValueFactory(new PropertyValueFactory<clientQuestion, String>("wrong2"));
                    WrongAnswer3.setCellValueFactory(new PropertyValueFactory<clientQuestion, String>("wrong3"));
                    questionId.setCellValueFactory(new PropertyValueFactory<clientQuestion, Integer>("id"));
                    studentAnswer.setCellValueFactory(new PropertyValueFactory<clientQuestion, Integer>("studentAnswer"));
                    QuestionsTable.setItems(data);
                }
            });
        }else {
            clientAccess ca = new clientAccess();
            ca.op = Operation.getExam;
            ca.examID = examId;
            Main.client.send(ca, new StringFunction() {
                @Override
                public void handle(String s) {
                    final clientExam e = Main.g.fromJson(s, clientExam.class);
                    ArrayList<clientQuestion> questionList = e.questions;
                    studentnote.setText(e.note);
                    teachernote.setText(e.teacherNote);
                    final ObservableList<clientQuestion> data = FXCollections.observableArrayList(questionList);
                    Question.setCellValueFactory(new PropertyValueFactory<clientQuestion, String>("question"));
                    RightAnswer.setCellValueFactory(new PropertyValueFactory<clientQuestion, String>("right"));
                    WrongAnswer1.setCellValueFactory(new PropertyValueFactory<clientQuestion, String>("wrong1"));
                    WrongAnswer2.setCellValueFactory(new PropertyValueFactory<clientQuestion, String>("wrong2"));
                    WrongAnswer3.setCellValueFactory(new PropertyValueFactory<clientQuestion, String>("wrong3"));
                    questionId.setCellValueFactory(new PropertyValueFactory<clientQuestion, Integer>("id"));
                    studentAnswer.setVisible(false);
                    QuestionsTable.setItems(data);
                }
            });
        }


    }
}
