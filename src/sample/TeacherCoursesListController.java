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
import sample.clientClasses.clientRequest;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import sample.clientClasses.*;
public class TeacherCoursesListController implements Initializable {
    static public int courseId;
    static public int subjectId;
    static public int from;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonback;


    @FXML
    private TableView<clientCourse> courselist;

    @FXML
    private TableColumn<clientCourse, String> courses;

    @FXML
    private ImageView Background;

    @FXML
    void buttonbackclick(ActionEvent event) throws IOException {

        Stage stage = (Stage)buttonback.getScene().getWindow();
        Parent newRoot;
        switch (from)
        {
            case 33:
                newRoot = FXMLLoader.load(getClass().getResource("Subject List.fxml"));
                break;
            default:
                newRoot = FXMLLoader.load(getClass().getResource("Teacher Subject Main.fxml"));
                break;
        }
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        courselist.setOnMouseClicked( event -> {
            if( event.getClickCount() == 2 ) {
                courseId=courselist.getSelectionModel().getSelectedItem().id;
                Stage stage = (Stage)buttonback.getScene().getWindow();
                Parent newRoot;
                Scene scene;
                try {

                    switch(from)
                    {
                        case 33:
                            TeacherStudentsAndGradesListController.from=331;
                            TeacherStudentsAndGradesListController.courseId=courseId;
                            newRoot = FXMLLoader.load(getClass().getResource("Teacher Students And Grades List.fxml"));
                            scene = new Scene(newRoot);
                            stage.setScene(scene);
                            break;
                        default:
                            TeacherStudentsAndGradesListController.courseId=courseId;
                            newRoot = FXMLLoader.load(getClass().getResource("Teacher Course Main.fxml"));
                            scene = new Scene(newRoot);
                            stage.setScene(scene);
                            break;
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }});
        clientAccess ca= new clientAccess();

        switch (from)
        {
            case 33:
                ca.op= Operation.coursesOfSubject;
                break;
            default:
                ca.op= Operation.coursesFromSubjectAndTeacher;
                break;
        }
        ca.subjectID=subjectId;
        Main.client.send(ca, new StringFunction() {
            @Override
            public void handle(String s) {
                final clientCourse[] studentList = Main.g.fromJson(s, clientCourse[].class);
                final ObservableList<clientCourse> data = FXCollections.observableArrayList(studentList);
                courses.setCellValueFactory(new PropertyValueFactory<clientCourse, String>("name"));
                courselist.setItems(data);
            }
        });
    }
    @FXML
    void initialize() {
        assert Background !=null : "fx:id=\"Background\" was not injected: check your FXML file 'Login Menu.fxml'.";
        assert buttonback != null : "fx:id=\"buttonback\" was not injected: check your FXML file 'Teacher Courses List.fxml'.";
    }
}