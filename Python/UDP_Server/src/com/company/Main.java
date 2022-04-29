package com.company;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Main {

    public static void main(String[] args) throws Exception {
        DatagramSocket clientSocket = new DatagramSocket(7);
        byte[] receiveBuffer = new byte[150];
        byte[] sendingBuffer = new byte[150];
        DatagramPacket sendPacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
        System.out.println("The server is ready.");

        while(true) {
            clientSocket.receive(sendPacket);
            System.out.println("The client name received is: " + sendPacket.getAddress() + " with port " + sendPacket.getPort());
            String received = new String(sendPacket.getData());
            System.out.println("The message received is " + received);
            sendingBuffer = received.toUpperCase().getBytes();

            DatagramPacket output = new DatagramPacket(sendingBuffer, sendingBuffer.length, sendPacket.getAddress(), sendPacket.getPort());
            String sent = new String(output.getData()); // convertim in String pentru ca serverul sa afiseze mesajul trimis catre client
            System.out.println("The message sent is: " + sent);
            clientSocket.send(output); // trimiterea efectiva a mesajului modificat catre client
        }
    }
}
