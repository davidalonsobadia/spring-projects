# User & Address Management System
This project consists of two microservices: user-service and address-service. The user-service handles user registration, authentication, and token issuance, while the address-service provides CRUD operations for managing user addresses. Both services are secured via JWT-based authentication and can be built and run together using Maven.

## Technologies Used
- Java 17
- Spring Boot 3.1
- Spring Security
- Spring Data JPA
- Spring Web
- JWT (JSON Web Token)
- H2 Database (in-memory)
- Maven
- Postman for API testing

## Table of Contents
- Overview
- Architecture
- Project Setup
- API Endpoints
- Testing with Postman

## Overview
### user-service
The user-service handles user management and authentication. It provides the following functionalities:

1. User Registration
2. Login (returns JWT access token)
3. Logout
4. Fetch User Information (secured with JWT)

### address-service
The address-service allows users to manage their addresses. It provides the following functionalities:

1. Add Address
2. Update Address
3. Delete Address
4. List Addresses

All operations are secured via JWT authentication and linked to the authenticated user.

## Architecture
- **User-Service**: Manages users and authentication via JWT.
- **Address-Service**: Allows authenticated users to manage addresses.

The services communicate via tokens, and each service uses an in-memory H2 database for simplicity.

## Project Setup
### Prerequisites

- Java 17 installed
- Maven installed
- Postman or cURL for testing the APIs

### Building and Running the Project

Clone the repository:

```bash
git clone <repo-url>
cd user-address-system
```

Build the project:

```bash
mvn clean install
```

Run both services:

1. For user-service:

```bash
cd user-service
mvn spring-boot:run
```

2. For address-service:

```bash
cd address-service
mvn spring-boot:run
```

By default, the services run on:

- **user-service**: http://localhost:8080
- **address-service**: http://localhost:8081

## API Endpoints
### User-Service Endpoints

#### Register a User

```bash
POST /api/v1/auth/register
Content-Type: application/json
{
"username": "testuser",
"password": "password123"
}
```

#### Login

```bash
POST /api/v1/auth/login
Content-Type: application/json
{
"username": "testuser",
"password": "password123"
}
```

Response:

```json
{
"access_token": "<jwt_token>"
}
```

#### Get Current User Info

```bash
GET /api/v1/user/me
Authorization: Bearer <jwt_token>
```

### Address-Service Endpoints
#### Add Address

```bash
POST /api/v1/address
Authorization: Bearer <jwt_token>
Content-Type: application/json
{
"street": "123 Main St",
"city": "Some City",
"state": "CA",
"zipCode": "12345"
}
```

#### Update Address

```bash
PUT /api/v1/address/{id}
Authorization: Bearer <jwt_token>
Content-Type: application/json
{
"street": "456 New St",
"city": "Another City",
"state": "NY",
"zipCode": "67890"
}
```

#### Delete Address

```bash
DELETE /api/v1/address/{id}
Authorization: Bearer <jwt_token>
```

#### List All Addresses

```bash
GET /api/v1/address
Authorization: Bearer <jwt_token>
```

## Conclusion
This project demonstrates how to build a secure microservices architecture with Spring Boot, using JWT for authentication and separate services for user management and address management.

Feel free to modify and extend it to suit your specific requirements!