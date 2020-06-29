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

public class PrincipalMakeReportController implements Initializable {

    static int from=0;
    static public int subjectId;
    static public String teacherId;
    static public String studentid;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Exam> tableexams;

    @FXML
    private TableColumn<Exam, String> subject;

    @FXML
    private TableColumn<Exam, String> course;

    @FXML
    private TableColumn<Exam, String> teacher;

    @FXML
    private TableColumn<Exam, String> exam;

    @FXML
    private TableColumn<Exam, String> date;

    @FXML
    private Button buttonback;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tableexams.setOnMouseClicked( event -> {
            if( event.getClickCount() == 2 ) {
                try {
                    Stage stage = (Stage)buttonback.getScene().getWindow();
                    Parent newRoot = FXMLLoader.load(getClass().getResource("Principal Report.fxml"));
                    Scene scene = new Scene(newRoot);
                    stage.setScene(scene);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }});

        final ObservableList<Exam> data = FXCollections.observableArrayList(e1,e2);
        subject.setCellValueFactory(new PropertyValueFactory<Exam, String>("subject"));
        course.setCellValueFactory(new PropertyValueFactory<Exam, String>("course"));
        teacher.setCellValueFactory(new PropertyValueFactory<Exam, String>("teacher"));
        exam.setCellValueFactory(new PropertyValueFactory<Exam, String>("exam"));
        date.setCellValueFactory(new PropertyValueFactory<Exam, String>("date"));
        tableexams.setItems(data);

    }

    public class Exam{
        public String subject;
        public String course;
        public String teacher;
        public String exam;
        public String date;

        Exam(String subject, String course, String teacher, String exam, String date){
            this.subject=subject;
            this.course=course;
            this.teacher=teacher;
            this.exam=exam;
            this.date=date;
        }

        public String getSubject() {
            return subject;
        }

        public String getCourse() {
            return course;
        }

        public String getTeacher() {
            return teacher;
        }

        public String getExam() {
            return exam;
        }

        public String getDate() {
            return date;
        }
    }

    Exam e1 = new Exam("computer science","modelem","noga","P-NP","28.6");
    Exam e2 = new Exam("computer science","haf3ala","ra7el","Memory","1.7");

    @FXML
    void buttonbackclick(ActionEvent event) throws IOException {
        Stage stage = (Stage)buttonback.getScene().getWindow();
        Parent newRoot;
        switch (from)
        {
            case 31:
                newRoot = FXMLLoader.load(getClass().getResource("Subject List.fxml"));
                break;
            case 32:
                newRoot = FXMLLoader.load(getClass().getResource("Teachers List.fxml"));
                break;
            case 33:
                newRoot = FXMLLoader.load(getClass().getResource("Students List.fxml"));
                break;
            default:
                newRoot = FXMLLoader.load(getClass().getResource("Principal Main.fxml"));
                break;
        }
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void initialize() {
        assert buttonback != null : "fx:id=\"buttonback\" was not injected: check your FXML file 'Make Report.fxml'.";
    }
}
