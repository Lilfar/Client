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
import sample.clientClasses.*;

public class TeacherQuestionListController implements Initializable{
    static public int subjectId;

    boolean itemselected = false;

    @FXML
    private ResourceBundle resources;

    @FXML
    private ImageView Background;

    @FXML
    private URL location;

    @FXML
    private TableView<clientQuestion> QuestionsTable;

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
    private Button buttonaddquestion;
    @FXML
    private Button buttonback;
    @FXML
    private Button buttonedit;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        QuestionsTable.setOnMousePressed(e -> {
            if (e.getClickCount() == 1 && e.isPrimaryButtonDown()) {
                itemselected = true;
            }
        });
        clientAccess ca=new clientAccess();
        ca.op=Operation.questionList;
        ca.subjectID=subjectId;
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
                QuestionsTable.setItems(data);
            }
        });
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
        assert Background !=null : "fx:id=\"Background\" was not injected: check your FXML file 'Login Menu.fxml'.";

        assert QuestionsTable != null : "fx:id=\"QuestionsTable\" was not injected: check your FXML file 'Teacher Question List.fxml'.";
        assert Question != null : "fx:id=\"Question\" was not injected: check your FXML file 'Teacher Question List.fxml'.";
        assert RightAnswer != null : "fx:id=\"RightAnswer\" was not injected: check your FXML file 'Teacher Question List.fxml'.";
        assert WrongAnswer1 != null : "fx:id=\"WrongAnswer1\" was not injected: check your FXML file 'Teacher Question List.fxml'.";
        assert WrongAnswer2 != null : "fx:id=\"WrongAnswer2\" was not injected: check your FXML file 'Teacher Question List.fxml'.";
        assert WrongAnswer3 != null : "fx:id=\"WrongAnswer3\" was not injected: check your FXML file 'Teacher Question List.fxml'.";
        assert buttonaddquestion != null : "fx:id=\"buttonaddquestion\" was not injected: check your FXML file 'Teacher Question List.fxml'.";
    }

}