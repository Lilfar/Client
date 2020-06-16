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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TeacherActiveExamAddExtraTimeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttoncancel;

    @FXML
    private Button buttonrequest;

    @FXML
    private TextField textextratime;
    @FXML
    private TextField textexplanation;

    @FXML
    void buttoncancelclick(ActionEvent event) {

        Stage popup = (Stage)buttoncancel.getScene().getWindow();
        popup.close();
    }
    public void buttonrequestclick(ActionEvent actionEvent) throws IOException {


        if(!textexplanation.getText().isBlank() &&
                !textextratime.getText().isBlank())
        {



        }
        else
        {
            Stage popup = new Stage();
            Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Add Question Error Popup.fxml"));
            Scene scene = new Scene(newRoot);
            popup.setScene(scene);
            popup.showAndWait();

        }

    }

    @FXML
    void initialize() {

        assert textextratime != null : "fx:id=\"textextratime\" was not injected: check your FXML file 'Teacher Active Exam Add Extra Time.fxml'.";
        assert buttonrequest != null : "fx:id=\"buttonrequest\" was not injected: check your FXML file 'Teacher Active Exam Add Extra Time.fxml'.";
        assert buttoncancel != null : "fx:id=\"buttoncancel\" was not injected: check your FXML file 'Teacher Active Exam Add Extra Time.fxml'.";
        assert textexplanation != null : "fx:id=\"textexplanation\" was not injected: check your FXML file 'Teacher Active Exam Add Extra Time.fxml'.";
    }



}
