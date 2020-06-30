package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import sample.clientClasses.*;
public class TeacherQuestionAddController {

    static boolean confirmed = false;
    static int subjectid;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField NewQuestion;

    @FXML
    private TextField textrightanswer;

    @FXML
    private TextField textwronganswer1;

    @FXML
    private TextField textwronganswer2;

    @FXML
    private TextField textwronganswer3;

    @FXML
    private Button buttonadd;

    @FXML
    private ImageView Background;

    @FXML
    void buttonaddclick(ActionEvent event) throws IOException {

        Stage popup = new Stage();
        Parent newRoot;

        if(!NewQuestion.getText().isBlank() &&
           !textrightanswer.getText().isBlank() &&
           !textwronganswer1.getText().isBlank() &&
           !textwronganswer2.getText().isBlank() &&
           !textwronganswer3.getText().isBlank())
        {
            FinishPopupController.from=9;
            newRoot = FXMLLoader.load(getClass().getResource("Finish Popup.fxml"));
            Scene scene = new Scene(newRoot);
            popup.setScene(scene);
            popup.showAndWait();

            if (confirmed){
                confirmed=!confirmed;
                clientAccess ca=new clientAccess();
                ca.op=Operation.createQuestion;
                ca.subjectID=subjectid;
                clientQuestion cq=new clientQuestion(NewQuestion.getText(),textrightanswer.getText(),
                        textwronganswer1.getText(),textwronganswer2.getText(),textwronganswer3.getText());
                ca.q=cq;
                Main.client.send(ca, new StringFunction() {
                    @Override
                    public void handle(String s) {

                    }
                });

                Stage stage = (Stage)buttonadd.getScene().getWindow();
                newRoot = FXMLLoader.load(getClass().getResource("Teacher Question List.fxml"));
                Scene scene2 = new Scene(newRoot);
                stage.setScene(scene2);
            }
        }
        else
        {
            newRoot = FXMLLoader.load(getClass().getResource("Teacher Add Question Error Popup.fxml"));
            Scene scene = new Scene(newRoot);
            popup.setScene(scene);
            popup.showAndWait();

        }

    }
    @FXML
    private Button buttoncancel;

    @FXML
    void buttoncancelclick(ActionEvent event) throws IOException {
        Stage stage = (Stage)buttoncancel.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Question List.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);

    }



    @FXML
    void initialize() {
        assert Background !=null : "fx:id=\"Background\" was not injected: check your FXML file 'Login Menu.fxml'.";
        assert NewQuestion != null : "fx:id=\"NewQuestion\" was not injected: check your FXML file 'Teacher Question Add.fxml'.";
        assert textrightanswer != null : "fx:id=\"textrightanswer\" was not injected: check your FXML file 'Teacher Question Add.fxml'.";
        assert textwronganswer1 != null : "fx:id=\"textwronganswer1\" was not injected: check your FXML file 'Teacher Question Add.fxml'.";
        assert textwronganswer2 != null : "fx:id=\"textwronganswer2\" was not injected: check your FXML file 'Teacher Question Add.fxml'.";
        assert textwronganswer3 != null : "fx:id=\"textwronganswer3\" was not injected: check your FXML file 'Teacher Question Add.fxml'.";
        assert buttonadd != null : "fx:id=\"buttonadd\" was not injected: check your FXML file 'Teacher Question Add.fxml'.";

    }
}
