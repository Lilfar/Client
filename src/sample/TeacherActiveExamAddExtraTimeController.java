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
import sample.clientClasses.*;

public class TeacherActiveExamAddExtraTimeController {

    static boolean close = false;
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
        boolean done;
        Stage popup = new Stage();
        Parent newRoot;
        if(!textexplanation.getText().isBlank() &&
                !textextratime.getText().isBlank())
        {
            clientAccess ca=new clientAccess();
            ca.op=Operation.newRequest;
            ca.addedTime=Integer.parseInt(textextratime.getText())*60;
            ca.exp=textexplanation.getText();
            ca.courseID=TeacherCoursesListController.courseId;
            Main.client.send(ca, new StringFunction() {
                @Override
                public void handle(String s) {

                }
            });
            FinishPopupController.from=4;
            newRoot = FXMLLoader.load(getClass().getResource("Finish Popup.fxml"));

        }
        else
        {

            newRoot = FXMLLoader.load(getClass().getResource("Teacher Add Question Error Popup.fxml"));


        }
        Scene scene = new Scene(newRoot);
        popup.setScene(scene);
        popup.showAndWait();
        if (close)
        {
            close=!close;
            Stage stage = (Stage)buttonrequest.getScene().getWindow();
            stage.close();
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
