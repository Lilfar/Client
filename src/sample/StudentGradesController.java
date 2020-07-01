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

import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import sample.clientClasses.*;

public class StudentGradesController implements Initializable {

    boolean itemselected = false;
    static int from = 0;
    static public String studentid;
    SimpleChatClient client=null;
    @FXML
    private ResourceBundle resources;

    @FXML
    private ImageView Background;
    @FXML
    private URL location;

    @FXML
    private Button buttonback;

    @FXML
    private Button buttondownload;

    @FXML
    private TableView<clientGrade> studentgrades;

    @FXML
    private TableColumn<clientGrade, String> examname;

    @FXML
    private TableColumn<clientGrade, String> examgrade;



    @FXML
    void buttonbackclick(ActionEvent event) throws IOException {

        Stage stage = (Stage)buttonback.getScene().getWindow();
        Parent newRoot;
        switch (from)
        {

            case 31:
                newRoot = FXMLLoader.load(getClass().getResource("Students List.fxml"));
                break;
            case 32:
                newRoot = FXMLLoader.load(getClass().getResource("Students List.fxml"));
                break;
            case 33:
                newRoot = FXMLLoader.load(getClass().getResource("Students List.fxml"));
                break;
            default:
                newRoot = FXMLLoader.load(getClass().getResource("Student Main.fxml"));
                break;
        }
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);

    }

    @FXML void buttondownloadclick(ActionEvent event) throws IOException {

        Stage popup = new Stage();
        Parent newRoot;
            if (!itemselected){
                newRoot = FXMLLoader.load(getClass().getResource("Table View Select Item Popup.fxml"));
                Scene scene = new Scene(newRoot);
                popup.setScene(scene);
                popup.showAndWait();
            }
            else {
                int online = studentgrades.getSelectionModel().getSelectedItem().online;
                if (online == 0) {
                    clientAccess ca = new clientAccess();
                    ca.op = Operation.downloadManualExam;
                    ca.courseID = studentgrades.getSelectionModel().getSelectedItem().course.id;
                    Main.client.send(ca, new StringFunction() {
                        @Override
                        public void handle(String s) {
                            clientExam ce = Main.g.fromJson(s,clientExam.class);
                            JFrame parentFrame = new JFrame();
                            JFileChooser fileChooser = new JFileChooser();
                            fileChooser.setDialogTitle("Specify folder for download");
                            fileChooser.setSelectedFile(new File("exam file.docx"));

                            int userSelection = fileChooser.showSaveDialog(parentFrame);

                            if (userSelection == JFileChooser.APPROVE_OPTION) {

                                try {
                                    clientAccess.toFile(ce.file, fileChooser.getSelectedFile().getPath());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                                Stage popup = new Stage();
                                Parent newRoot = null;
                                try {
                                    newRoot = FXMLLoader.load(getClass().getResource("Item Downloaded Successfully.fxml"));
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                Scene scene = new Scene(newRoot);
                                popup.setScene(scene);
                                popup.showAndWait();
                            }
                        }
                    });
                }
            }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (from==33)
            buttondownload.setVisible(false);
        else
            buttondownload.setVisible(true);

        clientAccess ca= new clientAccess();
        studentgrades.setOnMousePressed(e ->{
            if (e.getClickCount() == 1 && e.isPrimaryButtonDown() ){
                itemselected=true;
            }
        });

        studentgrades.setOnMouseClicked( event -> {
            if( event.getClickCount() == 2 ) {

                try {
                    Stage stage = (Stage)buttonback.getScene().getWindow();
                    ViewExamController.from=1;
                    Parent newRoot = FXMLLoader.load(getClass().getResource("View Exam.fxml"));
                    Scene scene = new Scene(newRoot);
                    stage.setScene(scene);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }});

        ca.studentID=studentid;
        ca.op=Operation.gradesList;
        Main.client.send(ca, new StringFunction() {
            @Override
            public void handle(String s) {
                clientGrade[] gradesList;
                gradesList = Main.g.fromJson(s, clientGrade[].class);
                final ObservableList<clientGrade> data = FXCollections.observableArrayList(gradesList);
                examname.setCellValueFactory(new PropertyValueFactory<clientGrade, String>("courseName"));
                examgrade.setCellValueFactory(new PropertyValueFactory<clientGrade, String>("grade"));
                studentgrades.setItems(data);
            }
        });
    }
    @FXML
    void initialize() {
        assert Background !=null : "fx:id=\"Background\" was not injected: check your FXML file 'Login Menu.fxml'.";
        assert buttonback != null : "fx:id=\"buttonback\" was not injected: check your FXML file 'Student Grades.fxml'.";
    }
}
