package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrincipalMakeReportController {

    static int from=0;
    static boolean close=false;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonback;

    @FXML
    private Button buttonmakereport;

    @FXML
    void buttonbackclick(ActionEvent event) throws IOException {
        Stage stage = (Stage)buttonback.getScene().getWindow();
        Parent newRoot;
        switch (from)
        {
            case 31:
                newRoot = FXMLLoader.load(getClass().getResource("Subject List.fxml"));
                break;
            case 32:
                newRoot = FXMLLoader.load(getClass().getResource("Teachers List.fxml"));
                break;
            case 33:
                newRoot = FXMLLoader.load(getClass().getResource("Students List.fxml"));
                break;
            default:
                newRoot = FXMLLoader.load(getClass().getResource("Principal Main.fxml"));
                break;
        }
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void buttonmakereportclick(ActionEvent event) throws IOException {

        Stage popup = new Stage();
        Parent newRoot;

        FinishPopupController.from=11;
        newRoot = FXMLLoader.load(getClass().getResource("Finish Popup.fxml"));

        Scene scene = new Scene(newRoot);
        popup.setScene(scene);
        popup.showAndWait();

        if (close){
            close=!close;
            Stage stage = (Stage)buttonmakereport.getScene().getWindow();
            newRoot = FXMLLoader.load(getClass().getResource("Principal Report.fxml"));
            scene = new Scene(newRoot);
            stage.setScene(scene);
        }


    }

    @FXML
    void initialize() {
        assert buttonback != null : "fx:id=\"buttonback\" was not injected: check your FXML file 'Make Report.fxml'.";
        assert buttonmakereport != null : "fx:id=\"buttonmakereport\" was not injected: check your FXML file 'Make Report.fxml'.";

    }
}
