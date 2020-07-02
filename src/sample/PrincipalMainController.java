package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrincipalMainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private ImageView Background;

    @FXML
    private URL location;

    @FXML
    private Button buttonquestions;

    @FXML
    private Button buttonexams;

    @FXML
    private Button buttongrades;

    @FXML
    private Button buttonrequests;

    @FXML
    private Button buttonlogout;


    @FXML
    private Text helloPrincliple;


    @FXML
    void buttonlogoutclick(ActionEvent event) throws IOException {
        Stage stage = (Stage)buttonlogout.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Login Menu.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);

    }

    @FXML
    void buttonexamsclick(ActionEvent event) throws IOException {

        Stage stage = (Stage)buttonexams.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Principal Exams Menu.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void buttongradesclick(ActionEvent event) throws IOException {

        Stage stage = (Stage)buttongrades.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Principal Grades Menu.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void buttonquestionsclick(ActionEvent event) throws IOException {

        Stage stage = (Stage)buttonquestions.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Principal Questions Menu.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void buttonrequestsclick(ActionEvent event) throws IOException {

        Stage stage = (Stage)buttonrequests.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Principal Requests.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void initialize() {
        assert Background != null : "fx:id=\"Background\" was not injected: check your FXML file 'Login Menu.fxml'.";
        assert buttonquestions != null : "fx:id=\"buttonquestions\" was not injected: check your FXML file 'Principal Main.fxml'.";
        assert buttonexams != null : "fx:id=\"buttonexams\" was not injected: check your FXML file 'Principal Main.fxml'.";
        assert buttongrades != null : "fx:id=\"buttongrades\" was not injected: check your FXML file 'Principal Main.fxml'.";
        assert buttonrequests != null : "fx:id=\"buttonrequests\" was not injected: check your FXML file 'Principal Main.fxml'.";

        helloPrincliple.setText("Hello " + LoginMenuController.user.name + "!");
    }
}
