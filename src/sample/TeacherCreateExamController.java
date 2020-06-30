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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TeacherCreateExamController implements Initializable {
    static boolean close = false;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView Background;
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
    private TableColumn<Question, String> radioinclude;

    @FXML
    private Button buttoncreate;

    @FXML
    private Button buttoncancel;
    Question qqqq = new Question("qq", "aa", "asda", "sfasd", "asdfsa");
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        final ObservableList<Question> data = FXCollections.observableArrayList(qqqq);
        Question.setCellValueFactory(new PropertyValueFactory<Question, String>("q"));
        RightAnswer.setCellValueFactory(new PropertyValueFactory<Question, String>("a1"));
        WrongAnswer1.setCellValueFactory(new PropertyValueFactory<Question, String>("a2"));
        WrongAnswer2.setCellValueFactory(new PropertyValueFactory<Question, String>("a3"));
        WrongAnswer3.setCellValueFactory(new PropertyValueFactory<Question, String>("a4"));
        radioinclude.setCellValueFactory(new PropertyValueFactory<Question, String>("rb"));

        QuestionsTableSubject.setItems(data);

    }

    public class Question{

        public String q;
        public String a1;
        public String a2;
        public String a3;
        public String a4;
        public RadioButton rb;

        Question(String q, String a1, String a2, String a3, String a4) {

            this.q = q;
            this.a1 = a1;
            this.a2 = a2;
            this.a3 = a3;
            this.a4 = a4;
            this.rb=new RadioButton("select");
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

        public RadioButton getRb()
        {
            return rb;
        }

        public void setRadioButton(RadioButton rb){
            this.rb=rb;
        }
    }


    @FXML
    void buttoncreateclick(ActionEvent event) throws IOException {


        boolean done;

        Stage popup = new Stage();
        Parent newRoot;

        if (qqqq.rb.isSelected())
            done = true;
        else
            done = false;

        if (done)
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
