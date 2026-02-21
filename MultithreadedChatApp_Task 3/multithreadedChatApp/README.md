# 💬 Multithreaded Chat Application  
### CODTECH Internship – Task 3  

---

## 📌 Project Description  

This project is a **Client-Server Chat Application** developed using **Java Socket Programming and Multithreading**.

The application allows multiple clients to connect to a server and communicate in real-time. Each connected client is handled using a separate thread, ensuring smooth and concurrent communication.

---

## 🎯 Objective  

- Build a client-server chat system  
- Implement Java Socket Programming  
- Use Multithreading to handle multiple users  
- Enable real-time communication  

---

## 🛠️ Technologies Used  

- Java  
- Socket Programming (TCP)  
- Multithreading (Thread / Runnable)  
- ServerSocket & Socket Classes  

---

## 📂 Project Structure  

MultithreadedChatApp/
│
├── Server.java  
├── ClientHandler.java  
└── Client.java  

---

## ⚙️ How the Application Works  

### 🔹 Server  
- Creates a ServerSocket on a specific port  
- Waits for client connections  
- Assigns a new thread for each client  
- Broadcasts messages to all connected clients  

### 🔹 Client  
- Connects to the server  
- Sends messages to the server  
- Receives real-time messages from other clients  
- Can exit the chat using `exit` command  

---

## ▶️ How to Run the Project  

### Step 1: Compile the Files  

```bash
javac Server.java ClientHandler.java Client.java