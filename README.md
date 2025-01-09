# Library Management

## Table of Contents

- [Overview](#overview)
  - [Purpose of the Application](#purpose-of-the-application)
  - [Key Features](#key-features)
- [Technical Explanations and Design Choices](#technical-explanations-and-design-choices)
  - [Technologies Used](#technologies-used)
  - [Architecture](#architecture)
  - [Database Schema](#database-schema)
  - [Database Creation Script](#database-creation-script)
- [Installation Guide](#installation-guide)
  - [Pre-requisites](#pre-requisites)
  - [Installation Steps](#installation-steps)
- [Usage Guide](#usage-guide)
  - [Books Management Endpoints ](#books-management-endpoints)
  - [Authors Management Endpoints ](#authors-management-endpoints)

---

## Overview

### Purpose of the Application
Java Spring Boot microservice for managing a small library. The aim is to design a complete application while respecting a multi-layer architecture and good development practices.

### Key Features
- Add, modify or delete a book
- List all books
- Get book details
- Add an author
- List all authors
- Obtain detailed information on an author, including a list of his books

---

## Technical Explanations

### Technologies Used
- **Backend:** Spring Boot
- **Database:** MySQL

### Architecture
The application follows a layered architecture:
- **Controller:** Manages HTTP requests.
- **Service:** Contains business logic.
- **Repository:** Handles database interactions.
- **Entity:** Represents database tables.

### Database Schema

#### Book
| Field          | Type        | Description                 |
|----------------|-------------|-----------------------------|
| `id`           | Long        | Book ID                     |
| `titre`        | String      | Book title                  |
| `genre`        | String      | Type of book                |
| `id_author`    | Long        | id of the author            |

#### Author
| Field          | Type        | Description                 |
|----------------|-------------|-----------------------------|
| `id`           | Long        | Author ID                   |
| `nom`          | String      | Author's last name          |
| `prenom`       | String      | Author's first name         |
| `livre`        | List<Book>  | List of the author's books  |


### Database Creation Script

Create database :
```sql
CREATE DATABASE library;
```

---

## Installation Guide

### Pre-requisites
- Java Development Kit (JDK 17)
- Apache Maven
- MySQL Database
- IDE (e.g., IntelliJ IDEA, Eclipse)

### Installation Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/AliHELB/library.git
   ```
2. Navigate to the project directory:
   ```bash
   cd library
   ```
3. Configure the database in `application.properties` for the service:

#### Library (port 8080):
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/library
spring.datasource.username=your_username
spring.datasource.password=your_password
```

4. Start service:
   ```bash
   mvn spring-boot:run
   ```

---

## Usage Guide

### Books management endpoints
- **Add a Book:**
  - **URL:** `http://localhost:8080/livres`
  - **Method:** POST
  - **Body:**
    ```json
    {
      "titre": "Tintin",
      "genre": "Comic strip",
      "id_auteur": 1,
    }
    ```

- **Retrieve All Books:**
  - **URL:** `http://localhost:8080/livres`
  - **Method:** GET

- **Retrieve Book by ID:**
  - **URL:** `http://localhost:8080/livres/{id}`
  - **Method:** GET

- **Update a Book:**
  - **URL:** `http://localhost:8080/livres/{id}`
  - **Method:** PUT
  - **Body:**
    ```json
    {
      "titre": "Les aventures de Tintin",
      "genre": "Comic strip",
      "id_auteur": 1,
    }
    ```

- **Delete a Book:**
  - **URL:** `http://localhost:8080/livres/{id}`
  - **Method:** DELETE

### Authors Management Endpoints
- **Add an Author:**
  - **URL:** `http://localhost:8080/auteurs`
  - **Method:** POST
  - **Body:**
    ```json
    {
      "nom": "George",
      "prenom": "Remi",
    }
    ```

- **Retrieve All Authors:**
  - **URL:** `http://localhost:8080/auteurs`
  - **Method:** GET

- **Retrieve Author's details by Author ID:**
  - **URL:** `http://localhost:8080/auteurs/{id}`
  - **Method:** GET

---


Feel free to contribute or report issues to the repository!
