# Baiching Chat Application

A multi-client chat server with Java networking capabilities.

## Features

- **Server**: Handles multiple client connections simultaneously
- **Client**: Connects to server and sends/receives messages
- **Broadcasting**: Server broadcasts messages to all connected clients
- **Threaded**: Each client connection runs in its own thread

## Architecture

```
ChatServer (Port 5000)
│
├── ClientHandler (Thread 1) ↔ Client 1
├── ClientHandler (Thread 2) ↔ Client 2
└── ... (Additional clients)
```

## Requirements

- Java 22 JDK
- Maven 3.8+
- Network connectivity (for client-server communication)

## Building

```bash
mvn clean package
```

## Running the Server

```bash
java -cp target/chatApp-1.0-SNAPSHOT.jar com.baiching.server.ChatServer
```

The server will:
1. Start on port 5000
2. Log client connections
3. Broadcast all received messages to connected clients

## Running a Client

```bash
java -cp target/chatApp-1.0-SNAPSHOT.jar com.baiching.client.ChatClient
```

(Note: Client implementation needs to be completed - see Development section)

## Implementation Details

### Server Components

1. **ChatServer**:
   - Creates ServerSocket on port 5000
   - Maintains list of connected clients
   - Spawns new ClientHandler thread for each connection

2. **ClientHandler** (per client):
   - Manages socket I/O streams
   - Reads incoming messages
   - Broadcasts messages to all clients
   - Handles connection cleanup

## Development Status

✅ Server implementation complete  
🔲 Client implementation needed  
🔲 Message protocol definition  
🔲 Error handling improvements  

## License
[MIT](LICENSE)
