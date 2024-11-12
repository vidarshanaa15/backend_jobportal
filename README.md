# Job Portal Application - Backend
**Frontend** : https://github.com/vidarshanaa15/frontend_jobportal

## Table of Contents
- [Description](#description)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Usage](#usage)
- [Configuration](#configuration)

## Description
This is the backend service for the Job Portal Application, built using Java Spring Boot. It manages core functionalities like user authentication, job management, and application processing, serving data and operations to the React-based frontend. The backend ensures secure and efficient data handling and integrates seamlessly with the frontend for a cohesive user experience.

## Technologies Used
- **Backend**: Java Spring Boot
- **Database**: PostgreSQL
- **APIs**: RESTful APIs
- **Other**: Hibernate, JPA

## Installation
To set up the backend locally, follow these steps:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/projectname.git
   cd projectname
   ```

2. **Set up the Database**:
- Ensure PostgreSQL is up and running
- Create a new database for the project(e.g., candidate_info)

3. **Build and Run the Application**:
- Use Maven or Gradle to build the project
  ```bash
   ./mvnw clean install
   ```
- Start the application
  ```bash
   ./mvnw spring-boot:run
   ```

## Usage
- To use the backend interface, access http://localhost:8080
- Make sure the frontend is configured to point to the backend at this address

## Configuration
Configure the backend with necessary properties in application.properties
```bash
  # Database configuration
spring.datasource.url=jdbc:postgresql://localhost:8080/jobportal_db
spring.datasource.username=yourUsername
spring.datasource.password=yourPassword

# JPA configuration
spring.jpa.hibernate.ddl-auto=update

# Server port
server.port=8080
```
