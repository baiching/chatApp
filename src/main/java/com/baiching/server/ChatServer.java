package com.baiching.server;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    private static List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server started on port 5000. Waiting for clients...");

        while (true) {
            Socket socketClient  = serverSocket.accept();
            System.out.println("Client connected. Waiting for message...");

            ClientHandler clientThread = new ClientHandler(socketClient, clients);
            clients.add(clientThread);
            new Thread(clientThread).start();

        }
    }
}
