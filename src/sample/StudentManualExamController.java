package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import sample.clientClasses.*;

public class StudentManualExamController {

    static boolean close = false;
    boolean uploaded=false;

    int timeRemaining = StudentComputerExamController.exam.duration - ((int)(System.currentTimeMillis() / 1000) - StudentComputerExamController.exam.startTime);

    @FXML
    private Text texttimeremaining;

    @FXML
    private ResourceBundle resources;

    @FXML
    private ImageView Background;

    @FXML
    private URL location;

    @FXML
    private Button buttondownloadexam;

    @FXML
    private Button buttonuploadexam;

    @FXML
    private Button buttondone;

    @FXML
    private Button buttonback;

    @FXML
    private TextField textexamupload;

    @FXML
    void buttonbackclick(ActionEvent event) throws IOException {
        Stage stage = (Stage)buttonback.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("Student Take Exam.fxml"));
        Scene scene = new Scene(newRoot);
        stage.setScene(scene);
    }

    @FXML
    void buttondoneclick(ActionEvent event) throws IOException {

        boolean done;

        Stage popup = new Stage();
        Parent newRoot;

        if (uploaded)
            done = true;
        else
            done = false;

        if (done)
        {

            FinishPopupController.from=2;
            newRoot = FXMLLoader.load(getClass().getResource("Finish Popup.fxml"));

            Scene scene = new Scene(newRoot);
            popup.setScene(scene);
            popup.showAndWait();

            if (close){
                Main.client.timeAdded = new StringFunction() {
                    @Override
                    public void handle(String s) {
                    }
                };
                close=!close;
                Stage stage = (Stage)buttondone.getScene().getWindow();
                newRoot = FXMLLoader.load(getClass().getResource("Student Main.fxml"));
                scene = new Scene(newRoot);
                stage.setScene(scene);
            }
        }
        else
        {
            newRoot = FXMLLoader.load(getClass().getResource("Upload Exam Popup.fxml"));
            Scene scene = new Scene(newRoot);
            popup.setScene(scene);
            popup.showAndWait();
        }
    }

    @FXML
    void buttondownloadexamclick(ActionEvent event) throws IOException {
        JFrame parentFrame = new JFrame();

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify folder for download");
        fileChooser.setSelectedFile(new File("exam file.docx"));

        int userSelection = fileChooser.showSaveDialog(parentFrame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {

            clientAccess.toFile(StudentComputerExamController.exam.file, fileChooser.getSelectedFile().getPath());

            Stage popup = new Stage();
            Parent newRoot = FXMLLoader.load(getClass().getResource("Item Downloaded Successfully.fxml"));
            Scene scene = new Scene(newRoot);
            popup.setScene(scene);
            popup.showAndWait();
        }



    }

    @FXML
    void buttonuploadexamclick(ActionEvent event) throws IOException {

        JFrame parentFrame = new JFrame();

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to upload");

        int userSelection = fileChooser.showSaveDialog(parentFrame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {

            clientAccess ca = new clientAccess();
            ca.courseID = StudentComputerExamController.exam.courseID;
            ca.file = clientAccess.toBytes(fileChooser.getSelectedFile().getPath());
            ca.op=Operation.submitManualExam;
            Main.client.send(ca, new StringFunction() {
                @Override
                public void handle(String s) {
                    clientCompletion cc = Main.g.fromJson(s,clientCompletion.class);
                    try {
                        if (cc.success) {
                            Stage popup = new Stage();
                            Parent newRoot = null;

                            newRoot = FXMLLoader.load(getClass().getResource("Item Uploaded Successfully.fxml"));
                            Scene scene = new Scene(newRoot);
                            popup.setScene(scene);
                            popup.showAndWait();
                        } else {
                            ItemUploadedSuccessfullyController.note = "Failed to upload!";
                            Stage popup = new Stage();
                            Parent newRoot = FXMLLoader.load(getClass().getResource("Item Uploaded Successfully.fxml"));
                            Scene scene = new Scene(newRoot);
                            popup.setScene(scene);
                            popup.showAndWait();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });


        }
        uploaded=true;


    }

    void setTimer(){
        int minutes = timeRemaining / 60;
        int seconds = timeRemaining % 60;

        texttimeremaining.setText("Time remaining: " + minutes + ":" + seconds);
    }

    @FXML
    void initialize() {
        assert Background !=null : "fx:id=\"Background\" was not injected: check your FXML file 'Login Menu.fxml'.";
        assert buttondownloadexam != null : "fx:id=\"buttondownloadexam\" was not injected: check your FXML file 'Student Manual Exam.fxml'.";
        assert buttonuploadexam != null : "fx:id=\"buttonuploadexam\" was not injected: check your FXML file 'Student Manual Exam.fxml'.";
        assert buttondone!= null : "fx:id=\"buttondone\" was not injected: check your FXML file 'Student Manual Exam.fxml'.";

        java.util.Timer timer = new Timer();

        Main.client.timeAdded = new StringFunction() {
            @Override
            public void handle(String s) {
                clientAccess ca = Main.g.fromJson(s,clientAccess.class);
                if(ca.courseID == StudentComputerExamController.exam.courseID){
                    timeRemaining += ca.addedTime;
                    setTimer();
                }
            }
        };

        TimerTask task = new TimerTask()
        {
            public void run()
            {
                timeRemaining -= 1;
                setTimer();
            }

        };

        timer.scheduleAtFixedRate(task,0,1000l);

    }
}
