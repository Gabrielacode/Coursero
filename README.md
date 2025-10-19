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
  


---

## 🏗️ Tech Stack

| Layer | Technology |
|-------|-------------|
| **Backend** | Spring Boot |
| **Database** | PostgreSQL |
| **ORM** | Hibernate / Spring Data JPA |
| **Security** | Spring Security (JWT + Roles) |
| **Build Tool** | Maven or Gradle |
| **API Style** | REST |
| **Pagination** | Spring Data `Pageable` |

---

## 📁 Project Structure

src/  
├── main/  
│ ├── java/com/example/coursemanagement/  
│ │ ├── controller/ #REST controllers  
│ │ ├── model/ # JPA entities  
│ │ ├── repository/ # Database access layer  
│ │ ├── service/ # Business logic  
│ │ └── security/ # Authentication & JWT config 
│ └── resources/  
│ ├── application.properties  
│ └──  
assets/  #For images stored by the user 

