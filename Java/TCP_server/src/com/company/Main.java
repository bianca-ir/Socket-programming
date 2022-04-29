package com.company;
import java.io.*;
import java.net.*;

public class Main {

    public static void main (String[] args) throws IOException {

        System.out.println("The server is ready");
        ServerSocket serverSocket = new ServerSocket (1234);
        Socket clientSocket = serverSocket.accept ();
        System.out.println("Address of the client is: " + clientSocket);

        BufferedReader in = new BufferedReader (new InputStreamReader (clientSocket.getInputStream ()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        String message, modifiedMessage;
        message = in.readLine ();
        System.out.print("The received message from client: " + message);
        modifiedMessage = message.toUpperCase();
        out.println(modifiedMessage);
        System.out.println ("\nModified message which is sent to client: " + modifiedMessage);

        in.close ();
        clientSocket.close ();
        serverSocket.close ();

    }

}
