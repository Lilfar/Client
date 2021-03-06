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

public class TeacherChangeGradeController {

    static  boolean close = false;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonapply;

    @FXML
    private TextField Explanation;

    @FXML
    private TextField NewGrade;
    @FXML
    private Button buttoncancel;

    @FXML
    void buttonapplyclick(ActionEvent event) throws IOException {
       if (!Explanation.getText().isBlank() && !NewGrade.getText().isBlank())
        {

            FinishPopupController.from=5;
            Stage popup = new Stage();
            Parent  newRoot = FXMLLoader.load(getClass().getResource("Finish Popup.fxml"));
            Scene scene = new Scene(newRoot);
            popup.setScene(scene);
            popup.showAndWait();

            if (close)
            {
                clientAccess ca=new clientAccess();
                ca.op=Operation.changeAndConfirmGrade;
                ca.newGrade=Integer.parseInt(NewGrade.getText());
                ca.reason=Explanation.getText();
                ca.courseID=TeacherGradeViewOnlineController.courseId;
                ca.studentID=TeacherGradeViewOnlineController.studentId;
                Main.client.send(ca, new StringFunction() {
                    @Override
                    public void handle(String s) {

                    }
                });
                close=!close;
                popup = (Stage) buttoncancel.getScene().getWindow();
                popup.close();
            }

        }
       else
       {
           Stage popup = new Stage();
           Parent  newRoot = FXMLLoader.load(getClass().getResource("Teacher Add Question Error Popup.fxml"));
           Scene scene = new Scene(newRoot);
           popup.setScene(scene);
           popup.showAndWait();
       }
    }
    @FXML
    void buttoncancelclick(ActionEvent event) {
        Stage popup = (Stage)buttoncancel.getScene().getWindow();
        popup.close();
    }

    @FXML
    void initialize() {
        assert buttonapply != null : "fx:id=\"buttonapply\" was not injected: check your FXML file 'Teacher Change Grade.fxml'.";
        assert Explanation != null : "fx:id=\"Explanation\" was not injected: check your FXML file 'Teacher Change Grade.fxml'.";
        assert NewGrade != null : "fx:id=\"NewGrade\" was not injected: check your FXML file 'Teacher Change Grade.fxml'.";
        assert buttoncancel != null : "fx:id=\"buttoncancel\" was not injected: check your FXML file 'Teacher Change Grade.fxml'.";

    }
}
