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

import sample.clientClasses.*;

public class SubjectListController implements Initializable  {

    static int from = 0;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView Background;

    @FXML
    private TableView<clientSubject> subjectslist;

    @FXML
    private TableColumn<clientSubject, String> subjects;

    @FXML
    private Button buttonback;

    static public int subjectId;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clientAccess ca= new clientAccess();
        subjectslist.setOnMouseClicked( event -> {
            if( event.getClickCount() == 2 ) {
                try {
                    Stage stage = (Stage)buttonback.getScene().getWindow();
                    Parent newRoot;

                    switch (from)
                    {
                        case 31:
                            PrincipalQuestionsController.from=31;
                            PrincipalQuestionsController.subjectId=subjectslist.getSelectionModel().getSelectedItem().id;
                            newRoot = FXMLLoader.load(getClass().getResource("Principal Questions.fxml"));
                            break;
                        case 32:
                            PrincipalExamsController.from=31;
                            PrincipalExamsController.subjectId=subjectslist.getSelectionModel().getSelectedItem().id;
                            newRoot = FXMLLoader.load(getClass().getResource("Principal Exams.fxml"));
                            break;
                        case 33:
                            TeacherCoursesListController.from=33;
                            TeacherCoursesListController.subjectId=subjectslist.getSelectionModel().getSelectedItem().id;
                            newRoot = FXMLLoader.load(getClass().getResource("Teacher Courses List.fxml"));
                            break;
                        case 34:
                            PrincipalMakeReportController.from=31;
                            PrincipalMakeReportController.subjectId=subjectslist.getSelectionModel().getSelectedItem().id;
                            newRoot = FXMLLoader.load(getClass().getResource("Principal Make Report.fxml"));
                            break;
                        default:
                            TeacherSubjectMainController.subjectId=subjectslist.getSelectionModel().getSelectedItem().id;
                            newRoot = FXMLLoader.load(getClass().getResource("Teacher Subject Main.fxml"));
                            break;
                    }
                    Scene scene = new Scene(newRoot);
                    stage.setScene(scene);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }});
        ca.op= Operation.subjectList;
        Main.client.send(ca, new StringFunction() {
            @Override
            public void handle(String s) {
                final clientSubject[] subjectList = Main.g.fromJson(s, clientSubject[].class);
                final ObservableList<clientSubject> data = FXCollections.observableArrayList(subjectList);
                subjects.setCellValueFactory(new PropertyValueFactory<clientSubject, String>("name"));
                subjectslist.setItems(data);
            }
        });

        if (from==31 || from==32 || from==33 || from == 34 || from == 331)
        {
            buttonback.setText("Back");
        }

        else
        {
            buttonback.setText("Logout");
        }
    }

    public void buttonbackclick(ActionEvent actionEvent) throws IOException {
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

    @FXML
    void initialize() {
        assert Background !=null : "fx:id=\"Background\" was not injected: check your FXML file 'Login Menu.fxml'.";
        assert subjectslist != null : "fx:id=\"subjectslist\" was not injected: check your FXML file 'Subject List.fxml'.";
        assert subjects != null : "fx:id=\"subjects\" was not injected: check your FXML file 'Subject List.fxml'.";
        assert buttonback != null : "fx:id=\"buttonlogout\" was not injected: check your FXML file 'Subject List.fxml'.";
    }
}
