package com.company;
import java.io.*;
import java.net.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 1234);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        System.out.println("Enter a lowercase sentence: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       BufferedReader in = new BufferedReader((new InputStreamReader(socket.getInputStream())));

        String messageSent = reader.readLine();
        System.out.println("The message sent is: " + messageSent);
        out.println(messageSent);


        String messageReceived = in.readLine();
        System.out.println("The modified message is: " + messageReceived);

        out.close();
        socket.close();

    }
}