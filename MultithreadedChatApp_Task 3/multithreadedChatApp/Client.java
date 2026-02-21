// Client.java
import java.io.*;
import java.net.*;

public class Client {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT)) {
            System.out.println("✅ Connected to server!");

            BufferedReader serverIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter serverOut = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            // Thread to read messages from server
            Thread readThread = new Thread(() -> {
                try {
                    String msg;
                    while ((msg = serverIn.readLine()) != null) {
                        System.out.println(msg);
                    }
                } catch (IOException e) {
                    System.out.println("❌ Connection closed.");
                }
            });
            readThread.start();

            // Send messages to server
            String userMsg;
            while ((userMsg = userInput.readLine()) != null) {
                serverOut.println(userMsg);
                if (userMsg.equalsIgnoreCase("exit")) break;
            }

        } catch (IOException e) {
            System.out.println("❌ Client error: " + e.getMessage());
        }
    }
}