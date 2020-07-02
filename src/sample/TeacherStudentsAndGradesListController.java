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
import sample.clientClasses.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TeacherStudentsAndGradesListController implements Initializable {

    static int from=0;
    boolean itemselected = false;
    static int courseId;
    static double Grade;
    static String teacherId;
    static String studentId;

    @FXML
    private ResourceBundle resources;
    @FXML
    private ImageView Background;
    @FXML
    private URL location;

    @FXML
    private TableView<clientGrade> Students;

    @FXML
    private TableColumn<clientGrade, String> studentname;

    @FXML
    private TableColumn<clientGrade, String> grade;

    @FXML
    private Button buttonback;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (from==1)
        {
            Students.setOnMouseClicked( event -> {
                if( event.getClickCount() == 2 ) {
                    studentId=Students.getSelectionModel().getSelectedItem().student.id;
                    Grade=Students.getSelectionModel().getSelectedItem().grade;
                    clientAccess ca=new clientAccess();
                    ca.op= Operation.courseExam;
                    ca.courseID=TeacherCoursesListController.courseId;
                    TeacherGradeViewOnlineController.grade=Grade;
                    TeacherGradeViewManualController.grade=Grade;
                    Main.client.send(ca, new StringFunction() {
                        @Override
                        public void handle(String s) {
                            final clientExam exam = Main.g.fromJson(s, clientExam.class);
                            Stage popup = new Stage();
                            Parent newRoot = null;
                            try {
                                if(exam.online==1) {
                                    TeacherGradeViewOnlineController.from=2;
                                    newRoot = FXMLLoader.load(getClass().getResource("Teacher Grade View Online.fxml"));
                                }
                                else {
                                    TeacherGradeViewManualController.from=2;
                                    newRoot = FXMLLoader.load(getClass().getResource("Teacher Grade View Manual.fxml"));
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            Scene scene = new Scene(newRoot);
                            popup.setScene(scene);
                            popup.showAndWait();
                        }
                    });
                }
            });
        }

        clientAccess ca= new clientAccess();
        if(from == 1){
            ca.op = Operation.getGradesOfCourse;
            ca.courseID = TeacherCoursesListController.courseId;
        }else if (from==332)
        {
            ca.teacherID=teacherId;
            ca.op=Operation.getGradesOfTeacher;
        }
        else
        {
            ca.op= Operation.getGradesOfCourse;
            ca.courseID=courseId;
        }
        Main.client.send(ca, new StringFunction() {
            @Override
            public void handle(String s) {

                clientGrade[] StudentsList;
                StudentsList = Main.g.fromJson(s, clientGrade[].class);
                final ObservableList<clientGrade> data = FXCollections.observableArrayList(StudentsList);
                studentname.setCellValueFactory(new PropertyValueFactory<clientGrade, String>("studentname"));
                grade.setCellValueFactory(new PropertyValueFactory<clientGrade, String>("grade"));
                Students.setItems(data);
            }
        });

        Students.setOnMousePressed(e ->{
            if (e.getClickCount() == 1 && e.isPrimaryButtonDown() ){
                itemselected=true;
            }
        });
    }

    @FXML
    void buttonbackclick(ActionEvent event) throws IOException {

        Stage stage = (Stage)buttonback.getScene().getWindow();
        Parent newRoot;
        switch (from)
        {
            case 1:
                newRoot = FXMLLoader.load(getClass().getResource("Teacher Course Main.fxml"));
                break;
            case 4:
                newRoot = FXMLLoader.load(getClass().getResource("Teacher Subject Finished Exam Students List.fxml"));
                break;
            case 31:
                newRoot = FXMLLoader.load(getClass().getResource("Subject List.fxml"));
                break;
            case 32:
                newRoot = FXMLLoader.load(getClass().getResource("Teachers List.fxml"));
                break;
            case 33:
                newRoot = FXMLLoader.load(getClass().getResource("Students List.fxml"));
                break;
            case 331:
                newRoot = FXMLLoader.load(getClass().getResource("Teacher Courses List.fxml"));
                break;
            case 332:
                newRoot = FXMLLoader.load(getClass().getResource("Teacher Courses List.fxml"));
                break;
            default:
                newRoot = FXMLLoader.load(getClass().getResource("Course List And Avg.fxml"));
                break;
        }
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }


    @FXML
    void initialize() {
        assert Background !=null : "fx:id=\"Background\" was not injected: check your FXML file 'Login Menu.fxml'.";
        assert Students != null : "fx:id=\"ExamsTable\" was not injected: check your FXML file 'Teacher Subject Finished Exams List.fxml'.";
        }
    }
