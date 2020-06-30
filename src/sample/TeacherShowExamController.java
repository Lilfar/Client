package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.clientClasses.Operation;
import sample.clientClasses.clientAccess;
import sample.clientClasses.clientQuestion;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
    private Button buttonback;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        QuestionsTableSubject.setOnMousePressed(e ->{
            if (e.getClickCount() == 1 && e.isPrimaryButtonDown() ){
                itemselected=true;
            }
        });

        clientAccess ca=new clientAccess();
        ca.op= Operation.questionList;
        ca.courseID=TeacherCoursesListController.courseId;
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
    void buttonbackclick(ActionEvent event) throws IOException {
        Stage stage = (Stage)buttonback.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Course Main.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void buttondownloadexamclick(ActionEvent event) throws IOException {

        Stage popup = new Stage();
        Parent newRoot;

        if (!itemselected)
            newRoot = FXMLLoader.load(getClass().getResource("Table View Select Item Popup.fxml"));
        else
            newRoot = FXMLLoader.load(getClass().getResource("Item Downloaded Successfully.fxml"));

        Scene scene = new Scene(newRoot);
        popup.setScene(scene);
        popup.showAndWait();
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

    }
}
