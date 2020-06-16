package sample;

import java.io.*;
import java.net.Socket;

public class Client {
    private SimpleChatClient client;
    private boolean isRunning;
    private Thread loopThread;
    public Client(SimpleChatClient client) {
        this.client = client;
        this.isRunning = false;
    }
    public void loop() throws IOException {
        loopThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (client.isConnected()) {

                }
            }
        });
        loopThread.start();
        this.isRunning = true;
    }

    public void displayMessage(Object msg) {
    }

    public void closeConnection() {
    }
}
