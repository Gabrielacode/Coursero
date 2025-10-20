# 📚 Course Management System
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0-green?logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue?logo=postgresql)
![License](https://img.shields.io/badge/license-MIT-lightgrey)
![Build](https://img.shields.io/badge/build-passing-brightgreen)

A **Spring Boot–based Course Management Application** that allows users to create, update, delete, and view courses.  
The system implements **secure authentication**, **pagination**, and **access control**, ensuring that only the course owner or an admin can modify course data.

---

## 🚀 Features

-  **Authentication & Authorization**
    - Register and log in users with secure role-based access.
    - Only owners or admins can update or delete a course.

- **Course Management**
    - Create, update, delete, and view course listings.
    - Paginated results for efficiency.

- **Search Functionality**
  - Search courses by title or description.

---

## Pictures 
 - ### Login Page  
  <img src="/pictures/coursero1.png" label ="Login">  
            
- ### Register Page  
  <img src="/pictures/coursero2.png" label ="Register ">

- ### Main Page
  <img src="/pictures/coursero3.png" label ="Main ">
---

## 🏗️ Tech Stack

| Layer | Technology |
|-------|-------------|
| **Backend** | Spring Boot |
| **Database** | PostgreSQL |
| **ORM** | Hibernate / Spring Data JPA |
| **Security** | Spring Security (Roles) |
| **Build Tool** | Maven or Gradle |
| **API Style** | REST |
| **Pagination** | Spring Data `Pageable` |

---

## 📁 Project Structure

src/  
├── main/  
│ ├── java/com/example/coursemanagement/  
│ │ ├── controller/ #REST controllers  
│ │ ├── entities/ # JPA entities  
│ │ ├── repositories/ # Database access layer  
│ │ ├── dtos/ # Data transfer objects  
│ │ ├── services/ # Business logic  
│ │ ├── utils/ # Utilities  
│ │ └── configuration/ # Authentication & Web Mvc config   
│ └── resources/  
│ ├── application.properties    
│ └── templates # Contain website UI
assets/  #For images stored by the user 

---

## ⚙️ Getting Started

### 🧩 1. Clone the Repository
```bash
    git clone https://github.com/Gabrielacode/Coursero.git
    cd Coursero
```
### 🗄️ 2. Configure PostgreSQL
Edit your application.properties file: 
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/course_db
spring.datasource.username=your username
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

#Or you can configure any database of your choice 

```

### ▶️ 3. Run the Application
```bash
  mvn spring-boot:run
```
Open your browser  and visit
```text
  http://localhost:8089/
```
