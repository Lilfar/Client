package sample;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.clientClasses.Operation;
import sample.clientClasses.clientAccess;
import sample.clientClasses.clientExam;
import sample.clientClasses.clientUser;

public class TeacherSubjectFinishedExamStudentsListController {

    static public int subjectId;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private ImageView Background;

    @FXML
    private TableView<clientExam> ExamTable;

    @FXML
    private TableColumn<clientExam, String> exam;


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
    void initialize() {
        assert Background !=null : "fx:id=\"Background\" was not injected: check your FXML file 'Login Menu.fxml'.";

        assert ExamTable != null : "fx:id=\"ExamTable\" was not injected: check your FXML file 'Teacher Subject Finished Exam Students List.fxml'.";
        assert exam != null : "fx:id=\"exam\" was not injected: check your FXML file 'Teacher Subject Finished Exam Students List.fxml'.";
        assert buttonback != null : "fx:id=\"buttonback\" was not injected: check your FXML file 'Teacher Subject Finished Exam Students List.fxml'.";

        clientAccess ca= new clientAccess();
        ca.op= Operation.examList;
        ca.subjectID=subjectId;
        Main.client.send(ca, new StringFunction() {
            @Override
            public void handle(String s) {
                clientExam[] examslist;
                examslist = Main.g.fromJson(s, clientExam[].class);
                final ObservableList<clientExam> data = FXCollections.observableArrayList(examslist);
                exam.setCellValueFactory(new PropertyValueFactory<clientExam, String>("id"));
                ExamTable.setItems(data);
            }
        });
    }
}
