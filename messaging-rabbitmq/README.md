# Spring Messaging with RabbitMQ
This project demonstrates how messaging works using Spring Boot and RabbitMQ. It is structured into three main parts:

- **messaging-rabbitmq-workspace**: The workspace containing the Docker Compose file to orchestrate the setup.
- **messaging-receiver**: A service that listens for and receives messages from RabbitMQ.
- **messaging-sender**: A service that sends messages to RabbitMQ and includes an endpoint for testing message transmission.

## Project Structure
- **messaging-rabbitmq-workspace**: Main workspace with Docker Compose configuration.
- **messaging-receiver**: The receiver application, which consumes messages.
- **messaging-sender**: The sender application, which produces messages.

## Purpose
The primary purpose of this project is to demonstrate how messaging works in a distributed setup using RabbitMQ as the message broker. The messaging-sender service can be tested via a REST API to send a message, which is then received by the messaging-receiver service.

## Getting Started
### Prerequisites
Java 17 or later
Docker and Docker Compose
Maven
### Building the Project
Clone the repository and navigate to the root directory.

Run the following Maven command (inside **messaging-receiver** and **messaging-sender** folders) to build the projects:

```bash
mvn clean install
```
This will compile and package both the messaging-receiver and messaging-sender applications.

### Running with Docker Compose
Navigate to the messaging-rabbitmq-workspace directory:

```bash
cd messaging-rabbitmq-workspace
```
Start the services with Docker Compose:

```bash
docker-compose up
```

This will start up the RabbitMQ instance, along with the messaging-receiver and messaging-sender services, all configured to communicate via RabbitMQ.

## Testing the Messaging System
Once the services are up and running, you can test message sending using the endpoint provided by messaging-sender.

### Sending a Message
Run the following curl command to send a test message to the messaging-sender service:

```bash
curl --location 'http://localhost:8080/api/v1/send' \
--header 'Content-Type: application/json' \
--data '{
    "message": "hello world!"
}'
```

This will send a JSON payload with the message to the messaging-sender, which in turn sends it to RabbitMQ, where the messaging-receiver will consume it.

## Additional Information

- **mvnw**: Both messaging-receiver and messaging-sender directories contain a mvnw wrapper, allowing Maven commands to be run without needing Maven installed locally.
- **RabbitMQ**: RabbitMQ is automatically started with Docker Compose and can be accessed on localhost at the default RabbitMQ management port.
Troubleshooting
- **Port Conflicts**: Ensure that the required ports (e.g., 8080, RabbitMQ port 5672) are not in use by other applications.
- **Docker**: Ensure Docker and Docker Compose are running without issues.