package io.vcti.networking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MultiServer {

	private ServerSocket serverSocket;
	private static List<Socket> clientSockets = new ArrayList<>();
	private PrintWriter pw;

	public MultiServer(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

	public void startServer() {
		try {
			Socket soc = serverSocket.accept();
			MultiClientHandler ch = new MultiClientHandler(soc);
			new Thread(ch).start();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void closeSocket() {

		try {
			if (serverSocket != null)
				serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws IOException {

		ServerSocket ss=new ServerSocket(9999);
		MultiServer server=new MultiServer(ss);
		server.startServer();
	}
	
	public class MultiClientHandler implements Runnable{
		
		private Socket socket;
		private BufferedReader br;
		private BufferedWriter bw;
		private String userName;		

		public MultiClientHandler(Socket socket) throws IOException {
			super();
			try {
				this.socket = socket;
				this.br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				this.bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				this.userName=br.readLine();
				clientSockets.add(socket);
				broadcastMessage("Server : "+userName+" has entered the chat!", socket);
			}
			catch(IOException e)
			{
				closeEverything(socket, br, bw);
			}
			
		}

		@Override //this keeps on listening to other clients and reads from other client ka socket
		public void run() {
			String messageFromClient;
			
			while(socket.isConnected())
			{
				try {
					messageFromClient=br.readLine();
					broadcastMessage(messageFromClient, socket);
				}
				catch(IOException e)
				{
					closeEverything(socket, br, bw);
				}
			}
			
		}
		
		public void closeEverything(Socket socket2, BufferedReader br2, BufferedWriter bw2) {
			
			
		}

		public void broadcastMessage(String messageToBeSent, Socket socket)
		{
			for(Socket currSocket: clientSockets)
			{
				if(!currSocket.equals(socket))
				{
					pw.println(socket);
				}
			}
		}
		
	}

}
