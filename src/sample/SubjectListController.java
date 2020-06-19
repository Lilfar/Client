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

public class SubjectListController implements Initializable  {

    static int from = 0;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Subject> subjectslist;

    @FXML
    private TableColumn<Subject, String> subjects;

    @FXML
    private Button buttonback;

    public class Subject
    {
        public String subject;

        Subject(String subject)
        {
            this.subject=subject;
        }

        public String getSubject(){
            return subject;
        }

    }

    Subject s1 = new Subject("Handasat ere");
    Subject s2 = new Subject("Malke sharmota");

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        subjectslist.setOnMouseClicked( event -> {
            if( event.getClickCount() == 2 ) {
                try {
                    Stage stage = (Stage)buttonback.getScene().getWindow();
                    Parent newRoot;

                    switch (from)
                    {
                        case 31:
                            PrincipalQuestionsController.from=31;
                            newRoot = FXMLLoader.load(getClass().getResource("Principal Questions.fxml"));
                            break;
                        case 32:
                            PrincipalExamsController.from=31;
                            newRoot = FXMLLoader.load(getClass().getResource("Principal Exams.fxml"));
                            break;
                        case 33:
                            StudentsListController.from=31;
                            newRoot = FXMLLoader.load(getClass().getResource("Students List.fxml"));
                            break;
                        case 34:
                            PrincipalMakeReportController.from=31;
                            newRoot = FXMLLoader.load(getClass().getResource("Principal Make Report.fxml"));
                            break;
                        default:
                            if (subjectslist.getSelectionModel().getSelectedItem().getSubject()=="Handasat ere"){
                                newRoot = FXMLLoader.load(getClass().getResource("Teacher Subject Main.fxml"));
                                System.out.println("Welcome to kos em Malke");
                            }
                            else
                            {
                                newRoot = FXMLLoader.load(getClass().getResource("Teacher Subject Main.fxml"));
                                System.out.println("Malke btntak");
                            }
                            break;
                    }

                    Scene scene = new Scene(newRoot);
                    stage.setScene(scene);



                } catch (IOException e) {
                    e.printStackTrace();
                }
            }});

            final ObservableList<Subject> data = FXCollections.observableArrayList(s1,s2);
            subjects.setCellValueFactory(new PropertyValueFactory<Subject, String>("subject"));
            subjectslist.setItems(data);

        if (from==31 || from==32 || from==33 || from == 34)
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
        assert subjectslist != null : "fx:id=\"subjectslist\" was not injected: check your FXML file 'Subject List.fxml'.";
        assert subjects != null : "fx:id=\"subjects\" was not injected: check your FXML file 'Subject List.fxml'.";
        assert buttonback != null : "fx:id=\"buttonlogout\" was not injected: check your FXML file 'Subject List.fxml'.";
    }
}
