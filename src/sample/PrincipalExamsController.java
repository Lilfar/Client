

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
    static int courseId;
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
            case 2:
                newRoot = FXMLLoader.load(getClass().getResource("Teacher Show Exam.fxml"));
                break;
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
            case 2:
                ca.subjectID=subjectId;
                ca.op=Operation.examList;
                exams.setText("Teacher");
                break;
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

        examstable.setOnMouseClicked( event -> {

            if (event.getClickCount() == 2) {
                if (from!=2) {
                    ViewExamController.examId = examstable.getSelectionModel().getSelectedItem().id;
                    ViewExamController.from = 300 + from;
                    Stage stage = (Stage) buttonback.getScene().getWindow();
                    Parent newRoot = null;
                    try {
                        newRoot = FXMLLoader.load(getClass().getResource("View Exam.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Scene scene = new Scene(newRoot);
                    stage.setScene(scene);
                }
                else
                {
                    clientAccess ca2 = new clientAccess();
                    ca2.op=Operation.selectExamForCourse;
                    ca2.courseID=courseId;
                    ca2.examID=examstable.getSelectionModel().getSelectedItem().id;
                    Main.client.send(ca2, new StringFunction() {
                        @Override
                        public void handle(String s) {
                            Stage stage = (Stage) buttonback.getScene().getWindow();
                            Parent newRoot = null;
                            try {
                                newRoot = FXMLLoader.load(getClass().getResource("Teacher Course Main.fxml"));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            Scene scene = new Scene(newRoot);
                            stage.setScene(scene);
                        }
                    });

                }
            }
        });
    }
}

