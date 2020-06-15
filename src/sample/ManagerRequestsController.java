package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ManagerRequestsController {

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
    void initialize() {
        assert RequestsTable != null : "fx:id=\"RequestsTable\" was not injected: check your FXML file 'Manager Requests.fxml'.";
        assert Requests != null : "fx:id=\"Requests\" was not injected: check your FXML file 'Manager Requests.fxml'.";
        assert RequestButtons != null : "fx:id=\"RequestButtons\" was not injected: check your FXML file 'Manager Requests.fxml'.";

    }
}
