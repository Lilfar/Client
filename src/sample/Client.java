package sample;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String message;
                System.out.println("Type show if u want to see the questions,Exit for exit");
                while (client.isConnected()) {
                    try {
                        message = reader.readLine();
                        if (message.isBlank())
                            continue;
                        if (message.equalsIgnoreCase("Exit")) {
                            System.out.println("Closing connection.");
                            client.closeConnection();
                        } else {
                            client.sendToServer(message);
                        }
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
            }
        });
        loopThread.start();
        this.isRunning = true;
    }
}
