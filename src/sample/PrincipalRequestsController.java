package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class PrincipalRequestsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> RequestsTable;

    @FXML
    private TableColumn<?, ?> Requests;

    @FXML
    private TableColumn<?, ?> RequestButtons;

    @FXML
    private Button buttonback;

    @FXML
    void buttonbackclick(ActionEvent event) throws IOException {
        Stage stage = (Stage)buttonback.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Principal Main.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void initialize() {
        assert RequestsTable != null : "fx:id=\"RequestsTable\" was not injected: check your FXML file 'Principal Requests.fxml'.";
        assert Requests != null : "fx:id=\"Requests\" was not injected: check your FXML file 'Principal Requests.fxml'.";
        assert RequestButtons != null : "fx:id=\"RequestButtons\" was not injected: check your FXML file 'Principal Requests.fxml'.";

    }
}
