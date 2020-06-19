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

public class StudentGradesController implements Initializable {

    boolean itemselected = false;
    static int from = 0;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonback;

    @FXML
    private Button buttondownload;


    @FXML
    private TableView<Grade> studentgrades;

    @FXML
    private TableColumn<Grade, String> examname;

    @FXML
    private TableColumn<Grade, String> examgrade;



    public class Grade{

        public String examname;
        public String examgrade;

        Grade(String examname, String examgrade)
        {
            this.examname=examname;
            this.examgrade=examgrade;
        }

        public String getExamname(){
            return examname;
        }

        public String getExamgrade(){
            return examgrade;
        }

    }


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
            else
            {

                newRoot = FXMLLoader.load(getClass().getResource("Item Downloaded Successfully.fxml"));
                Scene scene = new Scene(newRoot);
                popup.setScene(scene);
                popup.showAndWait();

                Stage stage = (Stage)buttondownload.getScene().getWindow();
                newRoot = FXMLLoader.load(getClass().getResource("Student Grades.fxml"));
                Scene scene2 = new Scene(newRoot);
                stage.setScene(scene2);

            }


    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        studentgrades.setOnMousePressed(e ->{
            if (e.getClickCount() == 1 && e.isPrimaryButtonDown() ){
                itemselected=true;
            }
        });


        Grade g1 = new Grade("mavoe","0");
        Grade g2 = new Grade("stam kors","51");
        Grade g3 = new Grade("ana 7mar","X");

        studentgrades.setOnMouseClicked( event -> {
            if( event.getClickCount() == 2 ) {
                System.out.println(studentgrades.getSelectionModel().getSelectedItem().getExamname() +" "+
                        studentgrades.getSelectionModel().getSelectedItem().getExamgrade());
            }});


        final ObservableList<Grade> data = FXCollections.observableArrayList(g1,g2,g3);

        examname.setCellValueFactory(new PropertyValueFactory<Grade,String>("examname"));
        examgrade.setCellValueFactory(new PropertyValueFactory<Grade,String>("examgrade"));

        studentgrades.setItems(data);


    }
    @FXML
    void initialize() {
        assert buttonback != null : "fx:id=\"buttonback\" was not injected: check your FXML file 'Student Grades.fxml'.";

    }


}
