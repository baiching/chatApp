# Baiching Chat Application

A simple Java chat application built with Maven.

## Features
- Basic Java application structure
- Maven build configuration
- Java 22 compatibility

## Requirements
- Java 22 JDK
- Maven 3.8+

## Project Structure
```
src/
└── main/
    └── java/
        └── com/
            └── baiching/
                ├── Main.java         # Main application entry point
                └── server/           # Chat server implementation
                    └── ChatServer.java
```

## Building and Running

1. Build the project:
```bash
mvn clean package
```

2. Run the application:
```bash
java -cp target/chatApp-1.0-SNAPSHOT.jar com.baiching.Main
```

## Development

The project uses Java 22 features as configured in pom.xml.

## License
[MIT](LICENSE)
