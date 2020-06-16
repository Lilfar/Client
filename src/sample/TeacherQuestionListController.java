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
    private TableColumn<Person, Integer> Edit;

    @FXML
    private TableColumn<Person, Integer> Delete;

    @FXML
    private Button buttonaddquestion;
    @FXML
    private Button buttonback;

    @FXML
    void buttonbackclick(ActionEvent event) throws IOException {

        Stage stage = (Stage)buttonback.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Subject Main.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);

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
        assert Edit != null : "fx:id=\"Edit\" was not injected: check your FXML file 'Teacher Question List.fxml'.";
        assert Delete != null : "fx:id=\"Delete\" was not injected: check your FXML file 'Teacher Question List.fxml'.";

    }
    public class Person {

        public String q;
        public String a1;
        public String a2;
        public String a3;
        public String a4;
        public Integer edit;
        public Integer delete;

        Person(String q, String a1, String a2, String a3, String a4, Integer edit, Integer delete) {

            this.q = q;
            this.a1 = a1;
            this.a2 = a2;
            this.a3 = a3;
            this.a4 = a4;
            this.edit = edit;
            this.delete = delete;
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

        public Integer getEdit() {
            return edit;
        }

        public Integer getDelete() {
            return delete;
        }

    }


        @Override
        public void initialize(URL location, ResourceBundle resources) {
            Question.setCellValueFactory(new PropertyValueFactory<Person, String>("q"));
            RightAnswer.setCellValueFactory(new PropertyValueFactory<Person, String>("a1"));
            WrongAnswer1.setCellValueFactory(new PropertyValueFactory<Person, String>("a2"));
            WrongAnswer2.setCellValueFactory(new PropertyValueFactory<Person, String>("a3"));
            WrongAnswer3.setCellValueFactory(new PropertyValueFactory<Person, String>("a4"));
            Edit.setCellValueFactory(new PropertyValueFactory<Person, Integer>("edit"));
            Delete.setCellValueFactory(new PropertyValueFactory<Person, Integer>("delete"));

            QuestionsTable.setItems(data);

        }

        private ObservableList<Person> data = FXCollections.observableArrayList(new Person("qq", "aa", "asda", "sfasd", "asdfsa", 69, 69));
}
