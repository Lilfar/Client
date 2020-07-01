package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ItemUploadedSuccessfullyController {

    static public String note=null;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonclose;

    @FXML
    private Text text;

    @FXML
    void buttoncloseclick(ActionEvent event) {
        Stage popup = (Stage)buttonclose.getScene().getWindow();
        popup.close();
    }

    @FXML
    void initialize() {
        assert buttonclose != null : "fx:id=\"buttonclose\" was not injected: check your FXML file 'Item Uploaded Successfully.fxml'.";

        if(note != null){
            text.setText(note);
            note = null;
        }
    }
}
