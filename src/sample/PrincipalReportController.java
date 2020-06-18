package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrincipalReportController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField textaverage;

    @FXML
    private TextField texmedian;

    @FXML
    private Button buttonclose;

    @FXML
    void buttoncloseclick(ActionEvent event) throws IOException {
        Stage stage = (Stage)buttonclose.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Principal Report Menu.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void initialize() {
        assert textaverage != null : "fx:id=\"textaverage\" was not injected: check your FXML file 'Principal Report.fxml'.";
        assert texmedian != null : "fx:id=\"texmedian\" was not injected: check your FXML file 'Principal Report.fxml'.";
        assert buttonclose != null : "fx:id=\"buttonclose\" was not injected: check your FXML file 'Principal Report.fxml'.";

    }
}
