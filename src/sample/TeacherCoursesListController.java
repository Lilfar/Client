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

public class TeacherCoursesListController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonback;


    @FXML
    private TableView<Course> courselist;

    @FXML
    private TableColumn<Course, String> courses;

    @FXML
    private ImageView Background;


    public class Course{
        public String course;

        Course(String course){
            this.course=course;
        }

        public String getCourse(){
            return course;
        }
    }

    Course c1 = new Course("course1");
    Course c2 = new Course("stam kors2");

    @FXML
    void buttonbackclick(ActionEvent event) throws IOException {
            Stage stage = (Stage)buttonback.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Subject Main.fxml"));
            Scene scene = new Scene(newRoot);
            stage.setScene(scene);
        }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        courselist.setOnMouseClicked( event -> {
            if( event.getClickCount() == 2 ) {
                Stage stage = (Stage)buttonback.getScene().getWindow();
                try {

                    if (courselist.getSelectionModel().getSelectedItem().getCourse()=="course1"){
                        Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Course Main.fxml"));
                        System.out.println("Welcome to course1!");
                        Scene scene = new Scene(newRoot);
                        stage.setScene(scene);
                    }
                    else
                    {
                        Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Course Main.fxml"));
                        System.out.println("Welcome to stam kors2!");
                        Scene scene = new Scene(newRoot);
                        stage.setScene(scene);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }});

        final ObservableList<Course> data = FXCollections.observableArrayList(c1,c2);
        courses.setCellValueFactory(new PropertyValueFactory<Course, String>("course"));
        courselist.setItems(data);


    }
    @FXML
    void initialize() {
        assert Background !=null : "fx:id=\"Background\" was not injected: check your FXML file 'Login Menu.fxml'.";
        assert buttonback != null : "fx:id=\"buttonback\" was not injected: check your FXML file 'Teacher Courses List.fxml'.";

    }


}
