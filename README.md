Flight Management System

Overview
This project is a Flight Management System that includes a RESTful API server built with Spring Boot, connecting to a MySQL database, and a client application that communicates with the API using HTTP requests. The application allows you to manage and query flight data, including airports, aircraft, cities, and passengers.

Setup Instructions

Prerequisites
- Java 17 or newer
- Maven (for building the project)
- MySQL (for database setup)
- Postman or similar tool (optional, for API testing)

Database Setup

1. Open MySQL Workbench or a command-line interface to connect to your MySQL server.

2. Create a new database and user
   
3. Update your MySQL settings in the API Server's application.properties file.

API Server Setup

1. Clone the repository
   
2. Navigate to the API Server
   
3. Configure Database Connection in application.properties
   
4. Build and run the server.

Client Setup

1. Navigate to the Client Directory

2. Build the client

3. Run the client

Usage

Running the API Server
- Start server using mvn spring-boot:run in the API server directory
- Use Postman to test endpoints manually

Running the Client
- Start the client using the Java command shown above. This will open a CLI interface that prompts you to select operations for different entities

Command Line Interface

The client's CLI provides commands for managing and querying data:
- "View Airports in Cities": Lists all airports in specific cities
  
- "List Aircraft for Passengers": Shows all aircraft a passenger has traveled on.
  
- "View Airports for Aircraft Operations": Lists airports an aircraft can take off from or land at.
  
- "Check Airports Used by Passengers:: Lists airports that passengers have used.
  
The client provides options for creating, updating, retrieving, and deleting data from the server.

Testing

Testing with Postman
1. Import the API endpoints into Postman using the base URL http://localhost:8080
2. Test CRUD operations for each entity (Aircraft, Passenger, City, Airport).

Unit Testing
- Server Tests: Run unit tests for the API server using Maven: mvn test
- Client Tests: For the client application, mock HTTP responses and enable GitHub Actions to run tests automatically.

Mock HTTP Responses for Client Testing

To fully test the client, use mocked HTTP responses in JUnit tests to simulate API server responses. This ensures the client logic works independently of the actual server.
