package io.vcti.networking;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket soc=new Socket("localhost", 9999);//client in order to connect with server creates socket obj and it needs server ka ip address and port no.
		
		String message="Hello from client";
		
		//to write data to server socket
		BufferedOutputStream bos=new BufferedOutputStream(soc.getOutputStream());
		PrintStream ps=new PrintStream(bos);
		ps.println(message);
		ps.flush();
		
		BufferedReader br=new BufferedReader(new InputStreamReader(soc.getInputStream()));
		String res=br.readLine();
		System.out.println("Message from client : "+res);
	}

}
