# Task Tracker API

## Description
The Task Tracker API is a simple RESTful application built using Spring Boot to manage tasks. It demonstrates CRUD operations, an in-memory database for data storage, and follows the Model-View-Controller (MVC) architecture. The API is documented using Swagger for easy testing and exploration.

---

## Features
- **Create, Read, Update, Delete (CRUD):** Manage tasks via HTTP methods.
- **In-Memory Database:** Simulates database interactions using a Java `List`.
- **Swagger Integration:** API documentation and testing.
- **MVC Architecture:** Follows the industry-standard design pattern.

---

## Technologies Used
- **Backend:** Java 17, Spring Boot
- **API Documentation:** Swagger (SpringDoc OpenAPI)
- **Build Tool:** Maven

---

## Endpoints

### Task Endpoints
- **GET /api/tasks**
  - Fetch all tasks.
- **GET /api/tasks/{id}**
  - Fetch a task by ID.
- **POST /api/tasks**
  - Create a new task.
- **PUT /api/tasks/{id}**
  - Update an existing task by ID.
- **DELETE /api/tasks/{id}**
  - Delete a task by ID.

---

## Installation and Setup

### Prerequisites
- Java 17 or higher
- Maven

### Steps to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/ajw7670/TaskTrackerCRUD.git
   cd task-tracker-api
   ```

2. Build the project:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

4. Access the API documentation:
   Open [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) in your browser.

---

## Project Structure
```
src/main/java
├── com/TaskTracker
│   ├── TaskTrackerApplication.java  // Main entry point
│   ├── controller
│   │   └── TaskController.java      // Handles API requests
│   ├── service
│   │   └── TaskService.java         // Business logic
│   ├── model
│   │   └── Task.java                // Represents task data
│   ├── exception
│   │   └── TaskNotFoundException.java // Custom exception
```

---

## Example Request

### Creating a Task
**POST** `/api/tasks`

#### Request Body:
```json
{
  "title": "Sample Task",
  "description": "This is a sample.",
  "completed": false
}
```

#### Response:
```json
{
  "id": 1,
  "title": "Sample Task",
  "description": "This is a sample.",
  "completed": false
}
```
