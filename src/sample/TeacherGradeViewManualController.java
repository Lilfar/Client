package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TeacherGradeViewManualController {

    static boolean confirmed=false;
    static boolean addgrade=false;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea Grade;

    @FXML
    private Button buttonchangegrade;

    @FXML
    private Button buttonstudentssolution;

    @FXML
    private Button buttonclose;

    @FXML
    private Button buttonaddgrade;

    @FXML
    private ImageView Background;

    @FXML
    void buttoncloseclick(ActionEvent event) {
        Stage popup = (Stage)buttonclose.getScene().getWindow();
        popup.close();
    }

    @FXML
    void buttonaddgradeclick(ActionEvent event) throws IOException {
        FinishPopupController.from=7;
        Stage popup = new Stage();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Finish Popup.fxml"));
        Scene scene = new Scene(newRoot);
        popup.setScene(scene);
        popup.showAndWait();

        if (addgrade)
        {
            addgrade=!addgrade;
            Stage stage = (Stage)buttonaddgrade.getScene().getWindow();
            newRoot = FXMLLoader.load(getClass().getResource("Teacher Students And Grades List.fxml"));
            scene = new Scene(newRoot);
            stage.setScene(scene);
        }
    }

    @FXML
    void buttonstudentssolutionclick(ActionEvent event) {


    }

    @FXML
    void buttonchangegradeclick(ActionEvent event) throws IOException {
        Stage popup = new Stage();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Change Grade.fxml"));
        Scene scene = new Scene(newRoot);
        popup.setScene(scene);
        popup.showAndWait();

        if (confirmed)
        {
            confirmed=!confirmed;
            Stage stage = (Stage)buttonchangegrade.getScene().getWindow();
            newRoot = FXMLLoader.load(getClass().getResource("Teacher Students And Grades List.fxml"));
            scene = new Scene(newRoot);
            stage.setScene(scene);
        }
    }

    @FXML
    void initialize() {
        assert Background !=null : "fx:id=\"Background\" was not injected: check your FXML file 'Login Menu.fxml'.";
        assert Grade != null : "fx:id=\"Grade\" was not injected: check your FXML file 'Teacher Grade View Manual.fxml'.";
        assert buttonchangegrade != null : "fx:id=\"buttonchangegrade\" was not injected: check your FXML file 'Teacher Grade View Manual.fxml'.";
        assert buttonstudentssolution != null : "fx:id=\"buttonstudentssolution\" was not injected: check your FXML file 'Teacher Grade View Manual.fxml'.";
        assert buttonclose != null : "fx:id=\"Apply\" was not injected: check your FXML file 'Teacher Grade View Manual.fxml'.";

        //int temp= ((Integer.parseInt(Grade.getText()))>=0 && (Integer.parseInt(Grade.getText()))<=100);
        boolean number=false;

        try
        {
            int grade = Integer.parseInt(Grade.getText());
            number=true;
        }
        catch (NumberFormatException NFE){
            number=false;
        }
        if (!number)
            buttonaddgrade.setVisible(true);
        else
            buttonaddgrade.setVisible(false);
    }
}
