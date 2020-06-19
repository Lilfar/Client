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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TeacherQuestionListController implements Initializable{


    boolean itemselected = false;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Person> QuestionsTable;

    @FXML
    private TableColumn<Person, String> Question;

    @FXML
    private TableColumn<Person, String> RightAnswer;

    @FXML
    private TableColumn<Person, String> WrongAnswer1;

    @FXML
    private TableColumn<Person, String> WrongAnswer2;

    @FXML
    private TableColumn<Person, String> WrongAnswer3;

    @FXML
    private Button buttonaddquestion;
    @FXML
    private Button buttonback;
    @FXML
    private Button buttonedit;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        QuestionsTable.setOnMousePressed(e ->{
            if (e.getClickCount() == 1 && e.isPrimaryButtonDown() ){
                itemselected=true;
            }
        });

        final ObservableList<Person> data = FXCollections.observableArrayList(new Person("qq", "aa", "asda", "sfasd", "asdfsa"));

        Question.setCellValueFactory(new PropertyValueFactory<Person, String>("q"));
        RightAnswer.setCellValueFactory(new PropertyValueFactory<Person, String>("a1"));
        WrongAnswer1.setCellValueFactory(new PropertyValueFactory<Person, String>("a2"));
        WrongAnswer2.setCellValueFactory(new PropertyValueFactory<Person, String>("a3"));
        WrongAnswer3.setCellValueFactory(new PropertyValueFactory<Person, String>("a4"));

        QuestionsTable.setItems(data);

    }
    public class Person {

        public String q;
        public String a1;
        public String a2;
        public String a3;
        public String a4;


        Person(String q, String a1, String a2, String a3, String a4) {

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

    @FXML
    void buttonbackclick(ActionEvent event) throws IOException {

        Stage stage = (Stage)buttonback.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Subject Main.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);

    }
    @FXML
    void buttoneditclick(ActionEvent event) throws IOException {

        Parent newRoot;
        if (itemselected)
        {
            Stage stage = (Stage)buttonedit.getScene().getWindow();
            newRoot = FXMLLoader.load(getClass().getResource("Teacher Question Edit.fxml"));
            Scene scene = new Scene(newRoot);
            stage.setScene(scene);
        }
        else
        {

            Stage popup = new Stage();
            newRoot = FXMLLoader.load(getClass().getResource("Table View Select Item Popup.fxml"));
            Scene scene = new Scene(newRoot);
            popup.setScene(scene);
            popup.showAndWait();
        }


    }
    @FXML
    void buttonaddquestionclick(ActionEvent event) throws IOException {

        Stage stage = (Stage)buttonaddquestion.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Question Add.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);


    }


    @FXML
    void initialize() {
        assert QuestionsTable != null : "fx:id=\"QuestionsTable\" was not injected: check your FXML file 'Teacher Question List.fxml'.";
        assert Question != null : "fx:id=\"Question\" was not injected: check your FXML file 'Teacher Question List.fxml'.";
        assert RightAnswer != null : "fx:id=\"RightAnswer\" was not injected: check your FXML file 'Teacher Question List.fxml'.";
        assert WrongAnswer1 != null : "fx:id=\"WrongAnswer1\" was not injected: check your FXML file 'Teacher Question List.fxml'.";
        assert WrongAnswer2 != null : "fx:id=\"WrongAnswer2\" was not injected: check your FXML file 'Teacher Question List.fxml'.";
        assert WrongAnswer3 != null : "fx:id=\"WrongAnswer3\" was not injected: check your FXML file 'Teacher Question List.fxml'.";
        assert buttonaddquestion != null : "fx:id=\"buttonaddquestion\" was not injected: check your FXML file 'Teacher Question List.fxml'.";
    }

}