package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import com.google.gson.*;
import javafx.application.Platform;
import sample.AbstractClient;
import sample.clientClasses.*;

public class SimpleChatClient extends AbstractClient {
	public static Gson gson = new Gson();
	private static final Logger LOGGER =
			Logger.getLogger(SimpleChatClient.class.getName());
	private Client chatClientCLI;
	public SimpleChatClient(String host, int port) {
		super(host, port);
		this.chatClientCLI = new Client(this);
	}

	private StringFunction sf = new StringFunction() {
		@Override
		public void handle(String s) {
			System.out.println(s);
		}
	};

	public StringFunction timeAdded = new StringFunction() {
		@Override
		public void handle(String s) {

		}
	};

	@Override
	protected void connectionEstablished() {
		// TODO Auto-generated method stub
		super.connectionEstablished();
		try {
			chatClientCLI.loop();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void handleMessageFromServer(Object msg) {

		try{
			clientAccess ca = gson.fromJson(msg.toString(), clientAccess.class);

			if(ca != null && ca.op == Operation.newRequest){
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						timeAdded.handle(msg.toString());
					}
				});
				return;
			}

		} catch (JsonSyntaxException e){
		}





		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				sf.handle(msg.toString());
			}
		});
	}

	public void send(clientAccess ca, StringFunction handler) {
		sf = handler;
		try {
			sendToServer(gson.toJson(ca));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void connectionClosed() {
		// TODO Auto-generated method stub
		super.connectionClosed();
		chatClientCLI.closeConnection();
	}

}