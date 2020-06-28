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
    private TableView<Question> QuestionsTableSubject;

    @FXML
    private TableColumn<Question, String> Question;

    @FXML
    private TableColumn<Question, String> RightAnswer;

    @FXML
    private TableColumn<Question, String> WrongAnswer1;

    @FXML
    private TableColumn<Question, String> WrongAnswer2;

    @FXML
    private TableColumn<Question, String> WrongAnswer3;

    @FXML
    private Button buttondownloadexam;

    @FXML
    private Button buttonback;
    public class Question {

        public String q;
        public String a1;
        public String a2;
        public String a3;
        public String a4;


        Question(String q, String a1, String a2, String a3, String a4) {

            this.q = q;
            this.a1 = a1;
            this.a2 = a2;
            this.a3 = a3;
            this.a4 = a4;
        }

        public String getQ() {
            return q;
        }

        public String getA1() {
            return a1;
        }

        public String getA2() {
            return a2;
        }

        public String getA3() {
            return a3;
        }

        public String getA4() {
            return a4;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        QuestionsTableSubject.setOnMousePressed(e ->{
            if (e.getClickCount() == 1 && e.isPrimaryButtonDown() ){
                itemselected=true;
            }
        });


        Question q1 = new Question("shu lwd3?","walla hyana wnte?","mnyke","7el 3ne","bsedr");
        Question q2 = new Question("tl3b west?","yzlme ma ana ra5e","yla lesh l2","7el 3ne","AAA YLA WOW");
        Question q3 = new Question("hedva 2 question","wrong answer","kman wrong answer","lshu 3m tjrb asln ma ente sa2et","yla kors 5ozer shbab");
        final ObservableList<Question> data = FXCollections.observableArrayList(q1,q2,q3);

        Question.setCellValueFactory(new PropertyValueFactory<Question, String>("q"));
        RightAnswer.setCellValueFactory(new PropertyValueFactory<Question, String>("a1"));
        WrongAnswer1.setCellValueFactory(new PropertyValueFactory<Question, String>("a2"));
        WrongAnswer2.setCellValueFactory(new PropertyValueFactory<Question, String>("a3"));
        WrongAnswer3.setCellValueFactory(new PropertyValueFactory<Question, String>("a4"));

        QuestionsTableSubject.setItems(data);
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
