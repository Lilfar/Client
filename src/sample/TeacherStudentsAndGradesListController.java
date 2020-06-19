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

public class TeacherStudentsAndGradesListController implements Initializable {

    static int from=0;
    boolean itemselected = false;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Grade> Students;

    @FXML
    private TableColumn<Grade, String> studentname;

    @FXML
    private TableColumn<Grade, String> grade;

    @FXML
    private Button buttonback;


    @FXML
    private Button buttonchangegrade;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Students.setOnMousePressed(e ->{
            if (e.getClickCount() == 1 && e.isPrimaryButtonDown() ){
                itemselected=true;
            }
        });

        Grade g1 = new Grade("Janan","0");
        Grade g2 = new Grade("Sagi","Fail");
        Grade g3 = new Grade("wa7d l5me","absr");

        final ObservableList<Grade> data = FXCollections.observableArrayList(g1,g2,g3);

        studentname.setCellValueFactory(new PropertyValueFactory<Grade, String>("studentname"));
        grade.setCellValueFactory(new PropertyValueFactory<Grade, String>("grade"));

        Students.setItems(data);
    }

    public class Grade{
        public String studentname;
        public String grade;

        Grade (String studentname, String grade){
            this.studentname=studentname;
            this.grade=grade;
        }

        public String getStudentname(){
            return studentname;
        }

        public String getGrade(){
            return grade;
        }
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
        assert Students != null : "fx:id=\"ExamsTable\" was not injected: check your FXML file 'Teacher Subject Finished Exams List.fxml'.";

        }
    }
