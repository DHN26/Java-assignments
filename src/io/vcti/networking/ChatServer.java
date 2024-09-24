//Assignment: Simple Chat Application Using Sockets
//
//Create a simple chat application where multiple clients can connect to a server and exchange messages in real-time.
//
//Requirements:
//
//1.Create a ChatServer Class:
//
//Purpose: The server will listen for client connections, receive messages from clients, and broadcast those messages to all connected clients.
//Implementation Details:
//Use ServerSocket to listen for client connections on a specified port.
//Use a List<Socket> to keep track of connected clients.
//For each connected client, spawn a new thread to handle communication.
//Broadcast received messages to all connected clients.
//Handle client disconnection gracefully.
//
//2.Create a ChatClient Class:
//
//Purpose: The client connects to the server, sends messages, and receives broadcasted messages from the server.
//Implementation Details:
//Use Socket to connect to the server.
//Start two threads: one for sending messages to the server and another for listening to incoming messages from the server.
//Use BufferedReader and PrintWriter for reading and sending text messages.
//
//3.Implement a Simple Protocol:
//
//Message Structure: Define a simple message structure that includes the sender’s name and the message content.
//Commands: Implement basic commands like /exit for disconnecting from the chat and /list to list currently connected clients.
//
//4.Test the Application:
//
//Run the Server: Start the ChatServer on a specified port.
//Run Multiple Clients: Connect multiple instances of ChatClient to the server, simulate a chat conversation, and verify that messages are correctly broadcasted to all connected clients.
//
//5.Bonus Challenge:
//
//Private Messaging: Implement a feature that allows clients to send private messages to a specific user using a command like /pm <username> <message>.
//User Authentication: Add a simple authentication mechanism where users must log in with a username and password before joining the chat.
//Handle Edge Cases:
//
//Server Overload: Ensure the server handles many connections gracefully.
//Disconnection: Handle unexpected client disconnections without crashing the server or affecting other clients.


package io.vcti.networking;

import java.io.*;
import java.net.*;
import java.util.*;



public class ChatServer {
    private static final int PORT = 12345;
    private static List<Socket> clientSockets = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Chat server started...");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {//ServerSocket is used to create a server-side socket that listens for incoming connection requests from clients.
            while (true) {
                Socket clientSocket = serverSocket.accept();//When a new client attempts to connect, the ServerSocket accepts the connection and creates a Socket object representing the connection to the client.
                clientSockets.add(clientSocket);
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void broadcastMessage(String message, Socket excludeSocket) {
        for (Socket socket : clientSockets) {
            if (socket != excludeSocket) {
                try {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;
        private String clientName;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
            	BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                out.println("Enter your name:");//sends this line to client
                clientName = in.readLine();//reads name from client ka socket.
                String message;

                while ((message = in.readLine()) != null) {
                    if (message.equalsIgnoreCase("/exit")) {
                        break;
                    }
                    if (message.equalsIgnoreCase("/list")) {
                        out.println("Connected clients: " + clientSockets.size());
                    } else {
                        String formattedMessage = clientName + ": " + message;
                        System.out.println(formattedMessage);
                        broadcastMessage(formattedMessage, socket);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                    clientSockets.remove(socket);
                    broadcastMessage(clientName + " has left the chat.", socket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
