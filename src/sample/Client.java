package sample;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public abstract class Client extends AbstractClient {
    /**
     * Constructs the client.
     *
     * @param host the server's host name.
     * @param port the port number.
     */
    public Client(String host, int port) {
        super(host, port);
    }
}
