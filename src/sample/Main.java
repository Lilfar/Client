package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import com.google.gson.Gson;

public class Main extends Application {


    static public SimpleChatClient client;
    static public Gson g = new Gson();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Login Menu.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 531, 498));
        primaryStage.show();
    }

    public static void main(String[] args) throws IOException {
        client=new SimpleChatClient("192.168.1.14",1000);
        client.openConnection();
        launch(args);
    }
}