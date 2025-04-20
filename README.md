# Java Chat Desktop Application

A simple peer-to-peer chat desktop application built using Java Swing for the UI and Java Sockets for networking. This application allows users to send and receive text messages over a local network or the internet (with appropriate port forwarding).

---

## 📦 Features

- Real-time messaging between server and client
- User-friendly GUI using Java Swing
- Built with Java 22
- Lightweight and easy to run
- Separate server and client components
- Supports multiple client connections (multi-threaded server)

---

## 🚀 Technologies Used

- Java 22
- Java Swing (for GUI)
- Java Sockets (for networking)
- Multi-threading (for handling multiple clients)
- Maven

---

## 📁 Project Structure

```
chatApp/
├── src/baiching
│   ├── client/
│   │   └── ChatClient.java
│   ├── server/
│   │   └── ChatServer.java
│   ├── ui/
│   │   └── ChatWindow.java
│   └── common/
│       └── Message.java
├── README.md
└── LICENSE
```

---

## 🛠️ How to Run

### Requirements

- Java 22 installed (can be downloaded from [Oracle](https://www.oracle.com/java/technologies/javase/jdk22-archive-downloads.html) or [Adoptium](https://adoptium.net/))

### Run Server

```bash
cd src/server
javac ChatServer.java
java ChatServer
```

By default, it listens on port `12345`.

### Run Client

```bash
cd src/client
javac ChatClient.java
java ChatClient
```

Enter the server's IP address and port when prompted.

---

## 🧪 Sample Usage

1. Start the `ChatServer`.
2. Launch one or more instances of the `ChatClient`.
3. Clients can send messages that are broadcast to all connected clients.

---

## 📸 Screenshots

> *(Add screenshots of your application in a `screenshots/` folder and reference them here)*

- ![Chat UI](screenshots/chat-ui.png)
- ![Server Console](screenshots/server-console.png)

---

## 🧩 Future Improvements

- Encrypt messages using SSL
- Add support for emojis and attachments
- Display message timestamps
- Improved UI with JavaFX or other modern frameworks

---

## 📄 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

> Built with ❤️ in Java 22
