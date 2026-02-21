// ClientHandler.java
import java.io.*;
import java.net.*;
import java.util.List;

public class ClientHandler implements Runnable {
    private Socket socket;
    private List<ClientHandler> clients;
    private PrintWriter out;
    private BufferedReader in;
    private String clientName;

    public ClientHandler(Socket socket, List<ClientHandler> clients) {
        this.socket = socket;
        this.clients = clients;
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            // Ask for client name
            out.println("Enter your name: ");
            clientName = in.readLine();
            broadcast("🟢 " + clientName + " joined the chat!");

            String message;
            while ((message = in.readLine()) != null) {
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
                broadcast(clientName + ": " + message);
            }

        } catch (IOException e) {
            System.out.println("❌ Client disconnected unexpectedly.");
        } finally {
            closeConnections();
        }
    }

    private void broadcast(String message) {
        for (ClientHandler client : clients) {
            client.out.println(message);
        }
    }

    private void closeConnections() {
        try {
            clients.remove(this);
            broadcast("🔴 " + clientName + " left the chat.");
            socket.close();
        } catch (IOException e) {
            System.out.println("❌ Error closing socket");
        }
    }
}