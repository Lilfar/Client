package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class SimpleChatClient extends AbstractClient {
	private static final Logger LOGGER =
			Logger.getLogger(SimpleChatClient.class.getName());
	
	private Client chatClientCLI;
	public SimpleChatClient(String host, int port) {
		super(host, port);
		this.chatClientCLI = new Client(this);
	}
	@Override
	protected void connectionEstablished() {
		// TODO Auto-generated method stub
		super.connectionEstablished();
		LOGGER.info("Connected to server.");
		
		try {
			chatClientCLI.loop();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void handleMessageFromServer(Object msg) {
		chatClientCLI.displayMessage(msg);
	}
	
	@Override
	protected void connectionClosed() {
		// TODO Auto-generated method stub
		super.connectionClosed();
		chatClientCLI.closeConnection();
	}
	
	public static void main(String[] args) throws IOException {
		if (args.length != 2) {
			System.out.println("Required arguments: <host> <port>");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String host=reader.readLine();
			String port=reader.readLine();
			SimpleChatClient chatClient = new SimpleChatClient(host, Integer.parseInt(port));
			chatClient.openConnection();
		} else {
			String host = args[0];
			int port = Integer.parseInt(args[1]);

			SimpleChatClient chatClient = new SimpleChatClient(host, port);
			chatClient.openConnection();
		}
	}
}
