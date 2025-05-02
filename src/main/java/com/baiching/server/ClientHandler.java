package com.baiching.server;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;


public class ClientHandler implements Runnable {

    private  Socket clientSocket;
    private List<ClientHandler> clients;
    private PrintWriter out;
    private BufferedReader in;
    private String username;

    public ClientHandler(Socket socket, List<ClientHandler> clients) throws IOException {
        this.clientSocket = socket;
        this.clients = clients;
        this.out = new PrintWriter(clientSocket.getOutputStream(), true);
        this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        this.username = in.readLine();
        broadcast("Server: " + username + " joined the chat");
    }

    @Override
    public void run() {
        try {
            String message;
            while ((message = in.readLine()) != null) {

                if (message.startsWith("/private")) {
                    handlePrivateMessage(message);
                }
                else {
                    broadcast(username + ": " + message);
                }
            }
        }
        catch (IOException e) {
            System.out.println("An error occurred." + e.getMessage() );
        }

        finally {
            try {
                in.close();
                out.close();
                clientSocket.close();
                clients.remove(this);
                broadcast("Server: " + username + " left the chat");

            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handlePrivateMessage(String message) {
        String[] parts = message.split(" ", 3);
        if (parts.length != 3) {
            out.println("Server: Invalid command. Use /private <username> <message>");
            return;
        }
        String recipient = parts[1];
        String privateMsg = parts[2];

        for (ClientHandler client: clients) {
            if (client.username.equals(recipient)) {
                client.out.println("[Private from " + username + "]: " + privateMsg);
                this.out.println("[Private to " + recipient + "]: " + privateMsg);
                return;
            }
        }
        out.println("Server: User '" + recipient + "' not found.");
    }

    private void broadcast(String message) {
        for (ClientHandler client : clients) {
            client.out.println(message);
        }
    }
}
