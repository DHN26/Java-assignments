package io.vcti.networking;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try {
        	Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));            
            System.out.println("Connected to chat server");

            //to write messaages sent by other clients through server 
            Thread readThread = new Thread(() -> {
                try {
                    String message;
                    while ((message = in.readLine()) != null) {
                        System.out.println(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            readThread.start();

            //to send message sent by this particular client to server
            String userInput;
            while ((userInput = consoleReader.readLine()) != null) {
                out.println(userInput);//The message is sent to the server using out.println(userInput). out is a PrintWriter connected to the server's socket.
                if (userInput.equalsIgnoreCase("/exit")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

