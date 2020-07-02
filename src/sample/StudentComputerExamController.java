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
import java.util.*;

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

    int[][] arr = new int[4][examsize];

    @FXML
    void buttonnextclick(ActionEvent event) throws IOException {

        if (questionnum<examsize-1)
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
                for(int i = 0 ; i<examsize ; i++){
                    clientAnswer a = answers.get(i);
                    a.answer = arr[a.answer-1][i];
                }
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
        radioSelected(1);
    }

    @FXML
    void radioa2click(ActionEvent event) throws IOException {
        radioSelected(2);
    }

    @FXML
    void radioa3click(ActionEvent event) throws IOException {
        radioSelected(3);
    }

    @FXML
    void radioa4click(ActionEvent event) throws IOException {
        radioSelected(4);
    }

    void reloadQuestion( int add){

        saveAnswer();

        questionnum += add;

        setText();

    }

    void saveAnswer(){
        if(radioa1.isSelected()) answers.get(questionnum).answer = 1;
        if(radioa2.isSelected()) answers.get(questionnum).answer = 2;
        if(radioa3.isSelected()) answers.get(questionnum).answer = 3;
        if(radioa4.isSelected()) answers.get(questionnum).answer = 4;
    }

    void radioSelected (int i){
        radioa1.setSelected(i == 1);
        radioa2.setSelected(i == 2);
        radioa3.setSelected(i == 3);
        radioa4.setSelected(i == 4);
    }

    String getText (clientQuestion a , int i){
        switch (i){
            case 1:
                return a.getRight();
            case 2:
                return a.getWrong1();
            case 3:
                return  a.getWrong2();
            case 4:
                return a.getWrong3();
            default:
                return "";
        }
    }

    void setText(){

        textquestion1.setText("Question " + (questionnum + 1) + " of " + examsize + ": ");

        clientQuestion question = exam.getQuestions().get(questionnum);
        textquestion.setText(question.getQuestion());
        radioa1.setText(getText(question,arr[0][questionnum]));
        radioa2.setText(getText(question,arr[1][questionnum]));
        radioa3.setText(getText(question,arr[2][questionnum]));
        radioa4.setText(getText(question,arr[3][questionnum]));

        radioSelected(answers.get(questionnum).answer);

        if (questionnum==0)
            buttonprev.setVisible(false);
        else
            buttonprev.setVisible(true);
        if (questionnum==examsize - 1)
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

       ArrayList<Integer> rans = new ArrayList<Integer>();
       rans.add(1);
       rans.add(2);
       rans.add(3);
       rans.add(4);

       for (int i=0 ; i< examsize;i++){
           Collections.shuffle(rans);
           arr[0][i] = rans.get(0);
           arr[1][i] = rans.get(1);
           arr[2][i] = rans.get(2);
           arr[3][i] = rans.get(3);
       }

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