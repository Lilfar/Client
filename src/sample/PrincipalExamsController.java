

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

import javax.swing.text.html.ImageView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import sample.clientClasses.*;

public class PrincipalExamsController implements Initializable {

    static int from=0;
    static public int subjectId;
    static public String teacherId;
    @FXML
    private ImageView Background;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<clientExam> examstable;

    @FXML
    private TableColumn<clientExam, String> exams;

    @FXML
    private TableColumn<clientExam, String> id;

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
                newRoot = FXMLLoader.load(getClass().getResource("Principal Main.fxml"));
                break;
        }
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void initialize() {
        assert Background != null : "fx:id=\"Background\" was not injected: check your FXML file 'Login Menu.fxml'.";
        assert examstable != null : "fx:id=\"examstable\" was not injected: check your FXML file 'Principal Exams.fxml'.";
        assert exams != null : "fx:id=\"exams\" was not injected: check your FXML file 'Principal Exams.fxml'.";
        assert id != null : "fx:id=\"id\" was not injected: check your FXML file 'Principal Exams.fxml'.";
        assert buttonback != null : "fx:id=\"buttonback\" was not injected: check your FXML file 'Principal Exams.fxml'.";


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clientAccess ca= new clientAccess();
        switch (from)
        {
            case 31:
                ca.subjectID=this.subjectId;
                ca.op= Operation.examList;
                exams.setText("Teacher");
                break;
            case 32:
                ca.teacherID=this.teacherId;
                ca.op=Operation.examByTeacher;
                exams.setText("Subject");
                break;
        }
        Main.client.send(ca, new StringFunction() {
            @Override
            public void handle(String s) {
                final clientExam[] questionList = Main.g.fromJson(s, clientExam[].class);
                final ObservableList<clientExam> data = FXCollections.observableArrayList(questionList);
                if (from==31)
                exams.setCellValueFactory(new PropertyValueFactory<clientExam, String>("teacher"));
                else
                    exams.setCellValueFactory(new PropertyValueFactory<clientExam, String>("subjectName"));
                id.setCellValueFactory(new PropertyValueFactory<clientExam, String>("id"));
                examstable.setItems(data);
            }
        });
    }
}

