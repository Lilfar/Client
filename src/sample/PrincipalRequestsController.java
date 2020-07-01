
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
import sample.clientClasses.Operation;
import sample.clientClasses.clientAccess;
import sample.clientClasses.clientUser;

import javax.swing.text.html.ImageView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import sample.clientClasses.*;

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
    private TableView<clientRequest> RequestsTable;

    @FXML
    private TableColumn<clientRequest, String> teachername;

    @FXML
    private TableColumn<clientRequest, String> coursename;

    @FXML
    private TableColumn<clientRequest, String> extratime;

    @FXML
    private TableColumn<clientRequest, String> explanation;

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

        clientAccess ca= new clientAccess();
        ca.op= Operation.requestList;
        Main.client.send(ca, new StringFunction() {
            @Override
            public void handle(String s) {
                final clientRequest[] studentList = Main.g.fromJson(s, clientRequest[].class);
                final ObservableList<clientRequest> data = FXCollections.observableArrayList(studentList);
                teachername.setCellValueFactory(new PropertyValueFactory<clientRequest, String>("teacher"));
                coursename.setCellValueFactory(new PropertyValueFactory<clientRequest, String>("course"));
                extratime.setCellValueFactory(new PropertyValueFactory<clientRequest, String>("timeAdded"));
                explanation.setCellValueFactory(new PropertyValueFactory<clientRequest, String>("explanation"));
                RequestsTable.setItems(data);
            }
        });
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
                clientAccess ca=new clientAccess();
                ca.op=Operation.decideRequest;
                ca.accept=true;
                ca.requestID=RequestsTable.getSelectionModel().getSelectedItem().id;
                Main.client.send(ca, new StringFunction() {
                    @Override
                    public void handle(String s) {

                    }
                });
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
                clientAccess ca=new clientAccess();
                ca.op=Operation.decideRequest;
                ca.accept=false;
                ca.requestID=RequestsTable.getSelectionModel().getSelectedItem().id;
                Main.client.send(ca, new StringFunction() {
                    @Override
                    public void handle(String s) {

                    }
                });
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
