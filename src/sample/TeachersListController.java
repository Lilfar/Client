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

public class TeachersListController implements Initializable {

    static int from=0;
    @FXML
    private ResourceBundle resources;
    @FXML
    private ImageView Background;
    @FXML
    private URL location;

    @FXML
    private TableView<Teacher> teacherslist;

    @FXML
    private TableColumn<Teacher, String> teachers;

    @FXML
    private Button buttonback;

    public class Teacher{
        public String teacher;

        Teacher(String teacher){
            this.teacher=teacher;
        }
        public String getTeacher(){
            return teacher;
        }
    }

    Teacher t1 = new Teacher("ldod loay");
    Teacher t2 = new Teacher("Noga l7ywane");
    Teacher t3 = new Teacher("Hagit l5tyara");
    Teacher t4 = new Teacher("eeris l...");
    Teacher t5 = new Teacher("tsveka");

    @FXML
    void buttonbackclick(ActionEvent event) throws IOException {
        Stage stage = (Stage)buttonback.getScene().getWindow();
        Parent newRoot;
        switch (from)
        {
            case 31:
                newRoot = FXMLLoader.load(getClass().getResource("Principal Questions Menu.fxml"));
                break;
            case 32:
                newRoot = FXMLLoader.load(getClass().getResource("Principal Exams Menu.fxml"));
                break;
            case 33:
                newRoot = FXMLLoader.load(getClass().getResource("Principal Grades Menu.fxml"));
                break;
            case 34:
                newRoot = FXMLLoader.load(getClass().getResource("Principal Report Menu.fxml"));
                break;
            default:
                newRoot = FXMLLoader.load(getClass().getResource("Login Menu.fxml"));
                break;
        }
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        teacherslist.setOnMouseClicked( event -> {
            if( event.getClickCount() == 2 ) {
                try {
                    Stage stage = (Stage)buttonback.getScene().getWindow();
                    Parent newRoot;

                    switch (from)
                    {
                        case 31:
                            PrincipalQuestionsController.from=32;
                            newRoot = FXMLLoader.load(getClass().getResource("Principal Questions.fxml"));
                            break;
                        case 32:
                            PrincipalExamsController.from=32;
                            newRoot = FXMLLoader.load(getClass().getResource("Principal Exams.fxml"));
                            break;
                        case 33:
                            StudentsListController.from=32;
                            newRoot = FXMLLoader.load(getClass().getResource("Students List.fxml"));
                            break;
                        case 34:
                            PrincipalMakeReportController.from=32;
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

        final ObservableList<Teacher> data = FXCollections.observableArrayList(t1,t2,t3,t4,t5);
        teachers.setCellValueFactory(new PropertyValueFactory<Teacher, String>("teacher"));
        teacherslist.setItems(data);
    }

    @FXML
    void initialize() {
        assert Background !=null : "fx:id=\"Background\" was not injected: check your FXML file 'Login Menu.fxml'.";
        assert buttonback != null : "fx:id=\"buttonback\" was not injected: check your FXML file 'Teachers List.fxml'.";
    }


}
