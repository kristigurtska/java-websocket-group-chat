# Java WebSocket Group Chat

A simple real-time group chat application built with Java and the Jakarta WebSocket API.

## Features
- Connect to the chat using a username
- Send and receive messages in real time
- Broadcast messages to all connected users
- Display user join and leave notifications
- JSON message serialization and deserialization using Gson

## Technologies
- Java 8
- Jakarta WebSocket API
- Gson
- HTML
- JavaScript
- Maven
- Apache Tomcat 10.0

## How It Works
The application uses WebSocket connections to enable bidirectional communication between the server and multiple clients.

The Jakarta WebSocket endpoint manages client sessions and broadcasts messages. Gson-based encoders and decoders handle JSON conversion.

## Dependencies

The project uses Maven for dependency management. All required dependencies are defined in `pom.xml` and will be downloaded automatically when the Maven project is loaded.

Main dependencies:

- **Jakarta Servlet API 5.0.0** – Servlet support.
- **Jakarta WebSocket API 2.0.0** – WebSocket communication.
- **Gson 2.10.1** – JSON serialization and deserialization.
- **JUnit 5.13.2** – Unit testing.

## Running the Project
1. Clone the repository.
2. Open it in IntelliJ IDEA as a Maven project.
3. Configure Apache Tomcat 10.0.
4. Deploy the WAR application.
5. Open the chat in two browser windows and connect using different usernames.
