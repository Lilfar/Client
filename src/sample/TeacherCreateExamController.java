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
import sample.clientClasses.clientExam;
import sample.clientClasses.clientQuestion;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TeacherCreateExamController implements Initializable {
    static boolean close = false;
    ArrayList<clientQuestion> cqarr = new ArrayList<clientQuestion>();
    static int subjectId;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView Background;
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
    private TextField teachernote;

    @FXML
    private TextField studentnote;

    @FXML
    private TextField textselectedquestions;

    @FXML
    private Button buttoncreate;

    @FXML
    private Button buttoncancel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        clientAccess ca=new clientAccess();
        ca.subjectID=subjectId;

        QuestionsTableSubject.setOnMouseClicked( event -> {
            if( event.getClickCount() == 2 ) {
                int Qid = QuestionsTableSubject.getSelectionModel().getSelectedItem().getId();

            clientQuestion cq = new clientQuestion(
                    QuestionsTableSubject.getSelectionModel().getSelectedItem().question,
                    QuestionsTableSubject.getSelectionModel().getSelectedItem().right,
                    QuestionsTableSubject.getSelectionModel().getSelectedItem().wrong1,
                    QuestionsTableSubject.getSelectionModel().getSelectedItem().wrong2,
                    QuestionsTableSubject.getSelectionModel().getSelectedItem().wrong3);

                    cqarr.add(Qid,cq);
                    textselectedquestions.setText(textselectedquestions.getText() + " " + Qid + " ");
            }});

        ca.op= Operation.questionList;
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
                QuestionsTableSubject.setItems(data);
            }
        });

    }

    @FXML
    void buttoncreateclick(ActionEvent event) throws IOException {

        boolean done;

        Stage popup = new Stage();
        Parent newRoot;

        if (true)
        {
            FinishPopupController.from=3;
            done=false;
            newRoot = FXMLLoader.load(getClass().getResource("Finish Popup.fxml"));
        }
        else
        {
            newRoot = FXMLLoader.load(getClass().getResource("Please Select Fields Popup.fxml"));
        }

        Scene scene = new Scene(newRoot);
        popup.setScene(scene);
        popup.showAndWait();
        if (close)
        {
            clientAccess ca=new clientAccess();
            ca.op= Operation.createExam;
            ca.subjectID=subjectId;
            ca.note=studentnote.getText();
            ca.teacherNote=teachernote.getText();
            Main.client.send(ca, new StringFunction() {
                @Override
                public void handle(String s) {

                }
            });

            close=!close;
            Stage stage = (Stage)buttoncreate.getScene().getWindow();
            newRoot = FXMLLoader.load(getClass().getResource("Teacher Subject Exams List.fxml"));
            Scene scene2 = new Scene(newRoot);
            stage.setScene(scene2);
        }


    }
    @FXML
    void buttoncancelclick(ActionEvent event) throws IOException {
        Stage stage = (Stage)buttoncancel.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Subject Exams List.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }


    @FXML
    void initialize() {
        assert Background !=null : "fx:id=\"Background\" was not injected: check your FXML file 'Login Menu.fxml'.";
        assert QuestionsTableSubject != null : "fx:id=\"QuestionsTableSubject\" was not injected: check your FXML file 'Teacher Create Exam.fxml'.";
        assert Question != null : "fx:id=\"Question\" was not injected: check your FXML file 'Teacher Create Exam.fxml'.";
        assert RightAnswer != null : "fx:id=\"RightAnswer\" was not injected: check your FXML file 'Teacher Create Exam.fxml'.";
        assert WrongAnswer1 != null : "fx:id=\"WrongAnswer1\" was not injected: check your FXML file 'Teacher Create Exam.fxml'.";
        assert WrongAnswer2 != null : "fx:id=\"WrongAnswer2\" was not injected: check your FXML file 'Teacher Create Exam.fxml'.";
        assert WrongAnswer3 != null : "fx:id=\"WrongAnswer3\" was not injected: check your FXML file 'Teacher Create Exam.fxml'.";
        assert buttoncreate != null : "fx:id=\"buttoncreate\" was not injected: check your FXML file 'Teacher Create Exam.fxml'.";
    }
}
