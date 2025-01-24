# Hibernate-based Simple Library Management System

## Overview
This project demonstrates a simple Library Management System using Hibernate ORM. The application manages books and authors, showcasing basic CRUD operations.

---

## Features
1. **Book Management**
   - Add, update, delete, and view books.

2. **Author Management**
   - Add, update, delete, and view authors.

---

## Technologies Used
- **Backend**: Hibernate ORM, Java
- **Database**: H2 Database (In-memory or file-based)
- **Tools**: IntelliJ IDEA

---

## Prerequisites
1. **Java Development Kit (JDK)** - Version 11 or above.
2. **Maven** - For dependency management.
3. **IDE** - IntelliJ IDEA or any Java-compatible IDE.

---

## Installation and Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/your-repository/simple-library-management.git
   ```
2. Navigate to the project directory:
   ```bash
   cd simple-library-management
   ```
3. Build the project using Maven:
   ```bash
   mvn clean install
   ```
4. Run the application:
   ```bash
   mvn exec:java
   ```

---

## Project Structure
```
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com.library
│   │   │   │   ├── config         # Hibernate configuration
│   │   │   │   ├── dao            # Data Access Objects
│   │   │   │   ├── entity         # Hibernate entities
│   │   │   │   └── util           # Utility classes
│   │   └── resources
│   │       ├── application.properties  # Database configurations
│   │       ├── hibernate.cfg.xml       # Hibernate configuration file
│   │                  
```

---

## Database Configuration
The default database configuration uses an H2 in-memory database. Modify the `hibernate.cfg.xml` file for a different database:
```xml
<property name="hibernate.connection.url">jdbc:h2:~/simplelibrarydb</property>
<property name="hibernate.connection.username">sa</property>
<property name="hibernate.connection.password"></property>
<property name="hibernate.dialect">org.hibernate.dialect.H2Dialect</property>
```

---

## Hibernate Entities
### Book
```java
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String genre;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
```
### Author
```java
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nationality;
}
```

---

## Running the Application
1. Ensure the database is set up (if not using H2).
2. Start the application using your IDE or by executing:
   ```bash
   java -jar target/simple-library-management.jar
   ```
3. Use the terminal or a simple frontend interface to interact with the application.

---

## Future Enhancements
1. Add a search functionality for books by title or genre.
2. Implement a many-to-many relationship between books and categories.

---

## created by
@kishor darkunde

