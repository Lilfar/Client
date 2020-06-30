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


    @FXML
    private Button buttonchangegrade;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        clientAccess ca= new clientAccess();
        ca.op= Operation.getGradesOfCourse;
        ca.courseID=courseId;
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

        if (from==331)
            buttonchangegrade.setVisible(false);
        else
            buttonchangegrade.setVisible(true);

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
            default:
                newRoot = FXMLLoader.load(getClass().getResource("Course List And Avg.fxml"));
                break;
        }
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void buttonchangegradeclick(ActionEvent event) throws IOException {
        Stage popup=new Stage();
        Parent newRoot;
        if (itemselected)
            newRoot = FXMLLoader.load(getClass().getResource("Teacher Change Grade.fxml"));
        else
            newRoot = FXMLLoader.load(getClass().getResource("Table View Select Item Popup.fxml"));
        Scene scene = new Scene(newRoot);
        popup.setScene(scene);
        popup.showAndWait();
    }

    @FXML
    void initialize() {
        assert Background !=null : "fx:id=\"Background\" was not injected: check your FXML file 'Login Menu.fxml'.";
        assert Students != null : "fx:id=\"ExamsTable\" was not injected: check your FXML file 'Teacher Subject Finished Exams List.fxml'.";
        }
    }
