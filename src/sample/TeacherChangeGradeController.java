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
            Stage popup = new Stage();
            Parent  newRoot = FXMLLoader.load(getClass().getResource("Finish Popup.fxml"));
            Scene scene = new Scene(newRoot);
            popup.setScene(scene);
            popup.showAndWait();

            if (close)
            {

                close = false;
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
