
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

public class PrincipalRequestsController implements Initializable {

    static boolean close=false;
    boolean itemselected = false;

    @FXML
    private ResourceBundle resources;

    @FXML
    private ImageView Background;

    @FXML
    private URL location;

    @FXML
    private TableView<Request> RequestsTable;

    @FXML
    private TableColumn<Request, String> teachername;

    @FXML
    private TableColumn<Request, String> coursename;

    @FXML
    private TableColumn<Request, String> extratime;

    @FXML
    private TableColumn<Request, String> explanation;

    @FXML
    private Button buttonback;

    @FXML
    private Button buttonaccept;

    @FXML
    private Button buttondecline;

    @Override
    public void initialize(URL locarion, ResourceBundle resources) {

        RequestsTable.setOnMousePressed(e ->{
            if (e.getClickCount() == 1 && e.isPrimaryButtonDown() ){
                itemselected=true;
            }
        });

        Request r1 = new Request("Noga","Modelem","15","hek");
        Request r2 = new Request("ldod elias","Mehadrem","15","3shan lshbab");
        final ObservableList<Request> data = FXCollections.observableArrayList(r1,r2);

        teachername.setCellValueFactory(new PropertyValueFactory<Request, String>("teachername"));
        coursename.setCellValueFactory(new PropertyValueFactory<Request, String>("coursename"));
        extratime.setCellValueFactory(new PropertyValueFactory<Request, String>("extratime"));
        explanation.setCellValueFactory(new PropertyValueFactory<Request, String>("explanation"));

        RequestsTable.setItems(data);
    }

    public class Request{
        public String teachername;
        public String coursename;
        public String extratime;
        public String explanation;

        Request(String teachername, String coursename, String extratime, String explanation){
            this.teachername=teachername;
            this.coursename=coursename;
            this.extratime=extratime;
            this.explanation=explanation;
        }

        public String getTeachername() {
            return teachername;
        }

        public String getCoursename(){
            return coursename;
        }
        public String getExtratime(){
            return extratime;
        }
        public String getExplanation(){
            return explanation;
        }

    }

    @FXML
    void buttonacceptclick(ActionEvent event) throws IOException {

        Parent newRoot;
        if (itemselected)
        {
            FinishPopupController.from=10;
            newRoot = FXMLLoader.load(getClass().getResource("Finish Popup.fxml"));
            Stage popup = new Stage();
            Scene scene = new Scene(newRoot);
            popup.setScene(scene);
            popup.showAndWait();

            if (close){
                close=!close;
                Stage stage = (Stage)buttonaccept.getScene().getWindow();
                newRoot = FXMLLoader.load(getClass().getResource("Principal Main.fxml"));
                Scene scene2 = new Scene(newRoot);
                stage.setScene(scene2);
            }
        }
        else
        {
            Stage popup = new Stage();
            newRoot = FXMLLoader.load(getClass().getResource("Table View Select Item Popup.fxml"));
            Scene scene = new Scene(newRoot);
            popup.setScene(scene);
            popup.showAndWait();
        }
    }

    @FXML
    void buttonbackclick(ActionEvent event) throws IOException {
        Stage stage = (Stage)buttonback.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Principal Main.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void buttondeclineclick(ActionEvent event) throws IOException {
        Parent newRoot;
        if (itemselected)
        {
            FinishPopupController.from=10;
            newRoot = FXMLLoader.load(getClass().getResource("Finish Popup.fxml"));
            Stage popup = new Stage();
            Scene scene = new Scene(newRoot);
            popup.setScene(scene);
            popup.showAndWait();

            if (close){
                close=false;
                Stage stage = (Stage)buttonaccept.getScene().getWindow();
                newRoot = FXMLLoader.load(getClass().getResource("Principal Main.fxml"));
                Scene scene2 = new Scene(newRoot);
                stage.setScene(scene2);
            }
        }
        else
        {
            Stage popup = new Stage();
            newRoot = FXMLLoader.load(getClass().getResource("Table View Select Item Popup.fxml"));
            Scene scene = new Scene(newRoot);
            popup.setScene(scene);
            popup.showAndWait();
        }
    }

    @FXML
    void initialize() {
        assert Background !=null : "fx:id=\"Background\" was not injected: check your FXML file 'Login Menu.fxml'.";
        assert RequestsTable != null : "fx:id=\"RequestsTable\" was not injected: check your FXML file 'Principal Requests.fxml'.";
        assert teachername != null : "fx:id=\"teachername\" was not injected: check your FXML file 'Principal Requests.fxml'.";
        assert coursename != null : "fx:id=\"coursename\" was not injected: check your FXML file 'Principal Requests.fxml'.";
        assert extratime != null : "fx:id=\"extratime\" was not injected: check your FXML file 'Principal Requests.fxml'.";
        assert explanation != null : "fx:id=\"explanation\" was not injected: check your FXML file 'Principal Requests.fxml'.";
        assert buttonback != null : "fx:id=\"buttonback\" was not injected: check your FXML file 'Principal Requests.fxml'.";
        assert buttonaccept != null : "fx:id=\"buttonaccept\" was not injected: check your FXML file 'Principal Requests.fxml'.";
        assert buttondecline != null : "fx:id=\"buttondecline\" was not injected: check your FXML file 'Principal Requests.fxml'.";

    }
}
