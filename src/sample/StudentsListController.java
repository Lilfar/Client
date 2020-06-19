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

public class StudentsListController implements Initializable {

    static int from=0;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    private TableView<Student> studentslist;

    @FXML
    private TableColumn<Student, String> students;

    @FXML
    private Button buttonback;

    public class Student{
        public String student;

        Student(String student){
            this.student=student;
        }
        public String getStudent(){
            return student;
        }
    }

    Student s1 = new Student("student1");
    Student s2 = new Student("student2");
    Student s3 = new Student("no name");
    Student s4 = new Student("liel fr");
    Student s5 = new Student("eml zoz");

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
            case 34:
                newRoot = FXMLLoader.load(getClass().getResource("Principal Report Menu.fxml"));
                break;
            default:
                newRoot = FXMLLoader.load(getClass().getResource("Principal Grades Menu.fxml"));
                break;
        }
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        studentslist.setOnMouseClicked( event -> {
            if( event.getClickCount() == 2 ) {
                try {
                    Stage stage = (Stage)buttonback.getScene().getWindow();
                    Parent newRoot;

                    switch (from)
                    {
                        case 31:
                            StudentGradesController.from=31;
                            newRoot = FXMLLoader.load(getClass().getResource("Student Grades.fxml"));
                            break;
                        case 32:
                            StudentGradesController.from=32;
                            newRoot = FXMLLoader.load(getClass().getResource("Student Grades.fxml"));
                            break;
                        case 33:
                            StudentGradesController.from=33;
                            newRoot = FXMLLoader.load(getClass().getResource("Student Grades.fxml"));
                            break;
                        case 34:
                            PrincipalMakeReportController.from=33;
                            newRoot = FXMLLoader.load(getClass().getResource("Principal Make Report.fxml"));
                            break;
                        default:
                            newRoot = FXMLLoader.load(getClass().getResource("Login Menu.fxml"));
                            break;
                    }
                    Scene scene = new Scene(newRoot);
                    stage.setScene(scene);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }});

        final ObservableList<Student> data = FXCollections.observableArrayList(s1,s2,s3,s4,s5);
        students.setCellValueFactory(new PropertyValueFactory<Student, String>("student"));
        studentslist.setItems(data);

    }

    @FXML
    void initialize() {
        assert buttonback != null : "fx:id=\"buttonback\" was not injected: check your FXML file 'Students List.fxml'.";

    }


}