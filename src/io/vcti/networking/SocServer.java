package io.vcti.networking;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;


public class SocServer {

	public static void main(String[] args) throws IOException {
		ServerSocket ss=new ServerSocket(9999);//server deals with many clients so create ServerSocket obj
		
		Socket s=ss.accept();//waits and accepts connection from client
		
		//to read data from particular client socket
		BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
		String res=br.readLine();
		
		System.out.println("Message from client : "+res);
		
		
		//to send data from server to client
		BufferedOutputStream bos=new BufferedOutputStream(s.getOutputStream());
		PrintStream ps=new PrintStream(bos);
		ps.println("Hello from server");
		ps.flush();
		
	}

}
