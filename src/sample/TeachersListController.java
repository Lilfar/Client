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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import sample.clientClasses.*;

public class TeachersListController implements Initializable {

    static int from=0;
    @FXML
    private ResourceBundle resources;
    @FXML
    private ImageView Background;
    @FXML
    private URL location;

    @FXML
    private TableView<clientUser> teacherslist;

    @FXML
    private TableColumn<clientUser, String> teachers;

    @FXML
    private Button buttonback;

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
                            PrincipalQuestionsController.teacherId=teacherslist.getSelectionModel().getSelectedItem().id;
                            newRoot = FXMLLoader.load(getClass().getResource("Principal Questions.fxml"));
                            break;
                        case 32:
                            PrincipalExamsController.from=32;
                            PrincipalExamsController.teacherId=teacherslist.getSelectionModel().getSelectedItem().id;
                            newRoot = FXMLLoader.load(getClass().getResource("Principal Exams.fxml"));
                            break;
                        case 33:
                            SubjectListController.from=332;
                            SubjectListController.teacherId=teacherslist.getSelectionModel().getSelectedItem().id;
                            newRoot = FXMLLoader.load(getClass().getResource("Subject List.fxml"));
                            break;
                        case 34:
                            PrincipalMakeReportController.from=32;
                            PrincipalMakeReportController.teacherId=teacherslist.getSelectionModel().getSelectedItem().id;
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
        clientAccess ca= new clientAccess();
        ca.op=Operation.teacherList;
        Main.client.send(ca, new StringFunction() {
            @Override
            public void handle(String s) {
                clientUser[] teacherList;
                teacherList = Main.g.fromJson(s, clientUser[].class);
                final ObservableList<clientUser> data = FXCollections.observableArrayList(teacherList);
                teachers.setCellValueFactory(new PropertyValueFactory<clientUser, String>("name"));
                teacherslist.setItems(data);
            }
        });

    }

    @FXML
    void initialize() {
        assert Background !=null : "fx:id=\"Background\" was not injected: check your FXML file 'Login Menu.fxml'.";
        assert buttonback != null : "fx:id=\"buttonback\" was not injected: check your FXML file 'Teachers List.fxml'.";
    }


}
