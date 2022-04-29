package com.company;
import java.io.BufferedReader;
import java.io.*;
import java.net.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
	InetAddress IPAddress = InetAddress.getByName("localhost");
	DatagramSocket clientSocket = new DatagramSocket();

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter a lowercase sentence: ");
	String message = reader.readLine(); // functia de citire

	byte[] sendingBuffer = message.getBytes();
	byte[] receivingBuffer = new byte[150];
	DatagramPacket sendPacket = new DatagramPacket(sendingBuffer, sendingBuffer.length, IPAddress, 7);
	clientSocket.send(sendPacket); // trimiterea mesajului catre server pentru a fi modificat

	DatagramPacket receivePacket = new DatagramPacket(receivingBuffer, receivingBuffer.length, IPAddress, 7);
	clientSocket.receive(receivePacket); // clientul primeste inapoi mesajul modificat
	String received = new String(receivePacket.getData()); // String pentru a-l putea afisa
	System.out.println("The modified message is: " + received);

	clientSocket.close();

    }
}
