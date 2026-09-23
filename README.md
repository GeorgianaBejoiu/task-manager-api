# Task Manager API

A REST API for managing tasks, built with Spring Boot, PostgreSQL and JPA.

## Features

- Create a task
- Get all tasks
- Get a task by ID
- Update a task
- Delete a task
- Request validation
- Error handling for missing tasks
- Unit tests with JUnit and Mockito

## Tech Stack

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- JUnit
- Mockito

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/task` | Get all tasks |
| GET | `/task/{id}` | Get a task by ID |
| POST | `/task` | Create a new task |
| PUT | `/task/{id}` | Update an existing task |
| DELETE | `/task/{id}` | Delete a task |

## How to Run

### Prerequisites

- Java 21
- PostgreSQL
- Maven

### Configuration

Update `src/main/resources/application.properties` with your PostgreSQL connection details.

### Run the application

```bash
./mvnw spring-boot:run