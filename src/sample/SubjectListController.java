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
    private TableColumn<Subject, String> buttons;

    @FXML
    private Button buttonlogout;
    public class Subject
    {
        public String subject;
        public Button select;

        Subject(String subject)
        {
            this.subject=subject;
            this.select=new Button("select");
        }

        public String getSubject(){
            return subject;
        }

        public void setSelect(){
            this.select=select;
        }

        public Button getSelect(){
            return select;
        }
    }

    Subject s1 = new Subject("Handasat ere");
    Subject s2 = new Subject("Malke sharmota");

    @Override
    public void initialize(URL location, ResourceBundle resources) {

            final ObservableList<Subject> data = FXCollections.observableArrayList(s1,s2);
            subjects.setCellValueFactory(new PropertyValueFactory<Subject, String>("subject"));
            buttons.setCellValueFactory(new PropertyValueFactory<Subject, String>("select"));
            subjectslist.setItems(data);

        if (from==31 || from==32 || from==33)
        {
            buttonlogout.setText("Back");
        }

        else
        {
            buttonlogout.setText("Logout");
        }
    }


    public void buttonlogoutclick(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage)buttonlogout.getScene().getWindow();
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
        assert buttonlogout != null : "fx:id=\"buttonlogout\" was not injected: check your FXML file 'Subject List.fxml'.";



    }
}