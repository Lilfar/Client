package sample;

import javafx.application.Platform;
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
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import sample.clientClasses.*;

public class StudentComputerExamController {

    static boolean close = false;
    int questionnum=1;
    static int courseid;
    ArrayList<clientAnswer> answers=new ArrayList<clientAnswer>();
    static clientExam exam=new clientExam();
    static int examsize;
    int timeRemaining = exam.duration - ((int)(System.currentTimeMillis() / 1000) - exam.startTime);
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
    private Text texttimeremaining;

    @FXML
    private Text textquestion1;

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
        {
            reloadQuestion(1);
        }else {
            saveAnswer();
            FinishPopupController.from=1;
            Stage popup = new Stage();
            Parent newRoot2 = FXMLLoader.load(getClass().getResource("Finish Popup.fxml"));
            Scene scene2 = new Scene(newRoot2);
            popup.setScene(scene2);
            popup.showAndWait();
            if (close){
                close=!close;
                clientAccess ca=new clientAccess();
                ca.arr=answers;
                ca.courseID=courseid;
                ca.op=Operation.submitOnlineExam;
                Main.client.send(ca, new StringFunction() {
                            @Override
                            public void handle(String s) {
                                clientCompletion cc = Main.g.fromJson(s,clientCompletion.class);
                                try {
                                    if (cc.success) {
                                        Main.client.timeAdded = new StringFunction() {
                                            @Override
                                            public void handle(String s) {
                                            }
                                        };
                                        Stage stage = (Stage) buttonnext.getScene().getWindow();
                                        Parent newRoot = FXMLLoader.load(getClass().getResource("Student Take Exam.fxml"));
                                        Scene scene = new Scene(newRoot);
                                        stage.setScene(scene);
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
        }

    }

    @FXML
    void buttonprevclick(ActionEvent event) throws IOException {
        reloadQuestion(-1);
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

    void reloadQuestion( int add){

        saveAnswer();

        questionnum += add;

        setText();

    }

    void saveAnswer(){
        if(radioa1.isSelected()) answers.get(questionnum - 1).answer = 1;
        if(radioa2.isSelected()) answers.get(questionnum - 1).answer = 2;
        if(radioa3.isSelected()) answers.get(questionnum - 1).answer = 3;
        if(radioa4.isSelected()) answers.get(questionnum - 1).answer = 4;
    }

    void setText(){

        textquestion1.setText("Question " + questionnum + " of " + examsize + ": ");

        clientQuestion question = exam.getQuestions().get(questionnum - 1);
        textquestion.setText(question.getQuestion());
        radioa1.setText(question.getRight());
        radioa2.setText(question.getWrong1());
        radioa3.setText(question.getWrong2());
        radioa4.setText(question.getWrong3());

        radioa1.setSelected(answers.get(questionnum-1).answer == 1);
        radioa2.setSelected(answers.get(questionnum-1).answer == 2);
        radioa3.setSelected(answers.get(questionnum-1).answer == 3);
        radioa4.setSelected(answers.get(questionnum-1).answer == 4);

        if (questionnum==1)
            buttonprev.setVisible(false);
        else
            buttonprev.setVisible(true);
        if (questionnum==examsize)
            buttonnext.setText("Done");
        else
            buttonnext.setText("Next");
    }

    void setTimer(){
        int minutes = timeRemaining / 60;
        int seconds = timeRemaining % 60;

        texttimeremaining.setText("Time remaining: " + minutes + ":" + seconds);
    }

    @FXML
    void initialize() {
        assert buttonnext != null : "fx:id=\"buttonnext\" was not injected: check your FXML file 'Student Computer Exam.fxml'.";
        assert buttonprev != null : "fx:id=\"buttonprev\" was not injected: check your FXML file 'Student Computer Exam.fxml'.";

        Timer timer = new Timer();

        Main.client.timeAdded = new StringFunction() {
            @Override
            public void handle(String s) {
                clientAccess ca = Main.g.fromJson(s,clientAccess.class);
                if(ca.courseID == exam.courseID){
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
                if(timeRemaining == 0){
                    Stage stage = (Stage) buttonnext.getScene().getWindow();

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            Parent newRoot = null;
                            try {
                                newRoot = FXMLLoader.load(getClass().getResource("Student Take Exam.fxml"));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            Scene scene = new Scene(newRoot);
                            stage.setScene(scene);
                        }
                    });
                }

            }

        };

        timer.scheduleAtFixedRate(task,0,1000l);


        for (int i = 0 ; i < examsize ; i++){
            answers.add(new clientAnswer(0,exam.questions.get(i).getId(),exam.getCourseID()));
        }

        setText();

    }
}