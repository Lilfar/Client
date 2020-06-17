package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentComputerExamController {

    static boolean close = false;
    static int examsize=5;
    static int questionnum=1;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonnext;

    @FXML
    private Button buttonprev;

    @FXML
    private Text textquestion;

    @FXML
    private RadioButton radioa1;

    @FXML
    private RadioButton radioa2;

    @FXML
    private RadioButton radioa3;

    @FXML
    private RadioButton radioa4;



    @FXML
    void buttonnextclick(ActionEvent event) throws IOException {

        if (questionnum<examsize)
            questionnum++;



        if (questionnum==examsize)
        {
            Stage popup = new Stage();
            Parent newRoot2 = FXMLLoader.load(getClass().getResource("Student Manual Exam Popup1.fxml"));
            Scene scene2 = new Scene(newRoot2);
            popup.setScene(scene2);
            popup.showAndWait();

            if (close){

                close=false;
                Stage stage = (Stage)buttonnext.getScene().getWindow();
                Parent newRoot = FXMLLoader.load(getClass().getResource("Student Take Exam.fxml"));
                Scene scene = new Scene(newRoot);
                stage.setScene(scene);

            }


        }
        else
        {
            Stage stage = (Stage)buttonnext.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(getClass().getResource("Student Computer Exam.fxml"));
            Scene scene = new Scene(newRoot);
            stage.setScene(scene);
        }

    }

    @FXML
    void buttonprevclick(ActionEvent event) throws IOException {

        if (questionnum>1)
            questionnum--;
        Stage stage = (Stage)buttonprev.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Student Computer Exam.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void radioa1click(ActionEvent event) throws IOException {
        radioa1.setSelected(true);
        radioa2.setSelected(false);
        radioa3.setSelected(false);
        radioa4.setSelected(false);
    }

    @FXML
    void radioa2click(ActionEvent event) throws IOException {
        radioa1.setSelected(false);
        radioa2.setSelected(true);
        radioa3.setSelected(false);
        radioa4.setSelected(false);
    }

    @FXML
    void radioa3click(ActionEvent event) throws IOException {
        radioa1.setSelected(false);
        radioa2.setSelected(false);
        radioa3.setSelected(true);
        radioa4.setSelected(false);
    }

    @FXML
    void radioa4click(ActionEvent event) throws IOException {
        radioa1.setSelected(false);
        radioa2.setSelected(false);
        radioa3.setSelected(false);
        radioa4.setSelected(true);
    }

    @FXML
    void initialize() {
        assert buttonnext != null : "fx:id=\"buttonnext\" was not injected: check your FXML file 'Student Computer Exam.fxml'.";
        assert buttonprev != null : "fx:id=\"buttonprev\" was not injected: check your FXML file 'Student Computer Exam.fxml'.";

        if (questionnum==1)
            buttonprev.setVisible(false);

        if (questionnum==examsize)
            buttonnext.setText("Done");

    }


}
