package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class LoginMenuController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private ImageView Background;

    @FXML
    private URL location;

    @FXML
    private TextField textuser;

    @FXML
    private Button buttonlogin;

    @FXML
    private Text texttitle;

    @FXML
    private PasswordField textpass;


    @FXML
    void initialize() {
        assert Background != null : "fx:id=\"Background\" was not injected: check your FXML file 'Login Menu.fxml'.";
        assert textuser != null : "fx:id=\"textuser\" was not injected: check your FXML file 'Login Menu.fxml'.";
        assert buttonlogin != null : "fx:id=\"buttonlogin\" was not injected: check your FXML file 'Login Menu.fxml'.";
        assert texttitle != null : "fx:id=\"texttitle\" was not injected: check your FXML file 'Login Menu.fxml'.";
        assert textpass != null : "fx:id=\"textpass\" was not injected: check your FXML file 'Login Menu.fxml'.";

    }

    @FXML
    void buttonloginclick(ActionEvent event) throws IOException {

        String username, password;
        username = textuser.getText();
        password = textpass.getText();


        if (!username.isBlank() && !password.isBlank()) {

            if (username.equals("janan")||username.equals("Janan"))
            {
                System.out.println("Ana jennu lhabla hehee2");
                StudentMainController.username="Janan";
            }
            else if (username.equals("jacob"))
                System.out.println("ana homo");
            else
                System.out.println("Welcome habebe");


            String s;
            int type = 1;
            switch (type) {

                case 1:
                    s = "Student Main.fxml";
                    break;

                case 2:
                    s = "Subject List.fxml";
                    break;

                case 3:
                    s = "Principal Main.fxml";
                    break;

                default:
                    s = "Login Fail Popup.fxml";
                    break;
            }

            if (s == "Login Fail Popup.fxml") {
                Stage popup = new Stage();
                Parent newRoot2 = FXMLLoader.load(getClass().getResource(s));
                Scene scene2 = new Scene(newRoot2);
                popup.setScene(scene2);
                popup.showAndWait();
            } else {
                Stage stage = (Stage) buttonlogin.getScene().getWindow();
                Parent newRoot = FXMLLoader.load(getClass().getResource(s));
                Scene scene = new Scene(newRoot);
                stage.setScene(scene);
            }
        }

        else {
            Stage popup = new Stage();
            Parent newRoot = FXMLLoader.load(getClass().getResource("Teacher Add Question Error Popup.fxml"));
            Scene scene = new Scene(newRoot);
            popup.setScene(scene);
            popup.showAndWait();
        }
    }
}
