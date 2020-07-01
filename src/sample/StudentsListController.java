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
import sample.clientClasses.clientUser;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import sample.clientClasses.*;

public class StudentsListController implements Initializable {

    static int from=0;
    static public int subjectId;
    static public String teacherId;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView Background;
    @FXML
    private TableView<clientUser> studentslist;

    @FXML
    private TableColumn<clientUser, String> students;

    @FXML
    private Button buttonback;


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
                            StudentGradesController.studentid=studentslist.getSelectionModel().getSelectedItem().id;
                            newRoot = FXMLLoader.load(getClass().getResource("Student Grades.fxml"));
                            break;
                        case 32:
                            StudentGradesController.from=32;
                            StudentGradesController.studentid=studentslist.getSelectionModel().getSelectedItem().id;
                            newRoot = FXMLLoader.load(getClass().getResource("Student Grades.fxml"));
                            break;
                        case 33:
                            StudentGradesController.from=33;
                            StudentGradesController.studentid=studentslist.getSelectionModel().getSelectedItem().id;
                            newRoot = FXMLLoader.load(getClass().getResource("Student Grades.fxml"));
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
        clientAccess ca= new clientAccess();
        ca.op= Operation.studentList;
        Main.client.send(ca, new StringFunction() {
            @Override
            public void handle(String s) {
                final clientUser[] studentList = Main.g.fromJson(s, clientUser[].class);
                final ObservableList<clientUser> data = FXCollections.observableArrayList(studentList);
                students.setCellValueFactory(new PropertyValueFactory<clientUser, String>("name"));
                studentslist.setItems(data);
            }
        });

    }

    @FXML
    void initialize() {
        assert Background !=null : "fx:id=\"Background\" was not injected: check your FXML file 'Login Menu.fxml'.";
        assert buttonback != null : "fx:id=\"buttonback\" was not injected: check your FXML file 'Students List.fxml'.";

    }


}