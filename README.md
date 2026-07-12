# Enterprise Order Management System (Microservices)

A production-inspired **Enterprise Order Management System (OMS)** built using **Java, Spring Boot, Microservices, React, PostgreSQL, JWT Authentication, and API Gateway**. The project demonstrates how independent services communicate securely while following clean architecture and industry-standard development practices.

> **Project Status:** 🚧 In Progress

---

# Features

* Microservices architecture
* JWT-based authentication and authorization
* Role-Based Access Control (Admin/User)
* API Gateway for centralized routing
* RESTful APIs
* PostgreSQL database
* React frontend
* Modular and scalable design
* Git version control with incremental commits

---

# Tech Stack

## Backend

* Java 17
* Spring Boot
* Spring Security
* Spring Data JPA
* REST APIs
* Maven

## Frontend

* React
* Axios

## Database

* PostgreSQL

## Security

* JWT Authentication
* BCrypt Password Encryption

## Architecture

* Microservices
* API Gateway

## Dev Tools

* Git
* Postman
* IntelliJ IDEA

## Planned

* Docker
* Docker Compose
* AWS EC2 Deployment
* Service Discovery
* Centralized Configuration
* API Documentation (Swagger/OpenAPI)

---

# Architecture

```text
                    +----------------------+
                    |    React Frontend    |
                    +----------+-----------+
                               |
                               |
                     HTTP Requests
                               |
                    +----------v-----------+
                    |     API Gateway      |
                    |       Port 8080      |
                    +----------+-----------+
                               |
          -----------------------------------------
          |                                       |
          |                                       |
+---------v---------+                  +----------v---------+
|   Auth Service    |                  |   Order Service    |
|     Port 8081     |                  |     Port 8082      |
+---------+---------+                  +----------+---------+
          |                                       |
          |                                       |
+---------v---------+                  +----------v---------+
| PostgreSQL        |                  | PostgreSQL         |
| auth_db           |                  | order_db           |
+-------------------+                  +--------------------+
```

---

# Microservices

## 1. Auth Service

Responsibilities

* User Registration
* User Login
* Password Encryption
* JWT Token Generation
* Token Validation
* Role Management

### Endpoints

| Method | Endpoint         | Description         |
| ------ | ---------------- | ------------------- |
| POST   | `/auth/register` | Register a new user |
| POST   | `/auth/login`    | Authenticate user   |
| GET    | `/auth/validate` | Validate JWT token  |

---

## 2. Order Service

Responsibilities

* Create Orders
* Retrieve Orders
* Track Order Status
* Validate JWT through Auth Service

### Endpoints

| Method | Endpoint                | Description        |
| ------ | ----------------------- | ------------------ |
| POST   | `/orders`               | Create Order       |
| GET    | `/orders/user/{userId}` | Get Orders of User |

---

## 3. API Gateway

Responsibilities

* Single entry point
* Request routing
* Gateway logging
* Future authentication filter

---

# Authentication Flow

```text
User
   |
   | Login
   v
Auth Service
   |
   | Generate JWT
   v
Client
   |
   | Authorization: Bearer <JWT>
   v
API Gateway
   |
   v
Order Service
   |
   | Validate Token
   v
Auth Service
```

---

# Database Design

## Users

| Column   | Type         |
| -------- | ------------ |
| id       | UUID         |
| username | String       |
| email    | String       |
| password | String       |
| role     | USER / ADMIN |

---

## Orders

| Column      | Type                                       |
| ----------- | ------------------------------------------ |
| id          | UUID                                       |
| userId      | UUID/String                                |
| productName | String                                     |
| quantity    | Integer                                    |
| status      | CREATED / PROCESSING / SHIPPED / DELIVERED |
| createdAt   | Timestamp                                  |

---

# Project Structure

```text
enterprise-order-management-system
│
├── auth-service
│   ├── controller
│   ├── service
│   ├── repository
│   ├── model
│   ├── security
│   └── dto
│
├── order-service
│   ├── controller
│   ├── service
│   ├── repository
│   ├── client
│   └── dto
│
├── api-gateway
│
└── oms-frontend
```

---

# Getting Started

## Clone Repository

```bash
git clone https://github.com/your-username/enterprise-order-management-system.git

cd enterprise-order-management-system
```

---

## Start PostgreSQL

Create two databases:

```text
auth_db

order_db
```

---

## Run Services

Start the applications in the following order:

```text
1. Auth Service
2. Order Service
3. API Gateway
4. React Frontend
```

---

# API Flow

## Register User

```http
POST /auth/register
```

## Login

```http
POST /auth/login
```

Returns

```json
{
  "token": "<JWT_TOKEN>"
}
```

---

## Create Order

```http
POST /orders
```

Header

```text
Authorization: Bearer <JWT_TOKEN>
```

---

# Current Progress

* [x] Auth Service
* [x] JWT Authentication
* [x] User Registration
* [x] User Login
* [x] Order Service
* [x] PostgreSQL Integration
* [x] API Gateway
* [x] React Frontend
* [ ] Docker
* [ ] Docker Compose
* [ ] AWS EC2 Deployment
* [ ] Service Discovery
* [ ] Config Server
* [ ] Swagger Documentation
* [ ] Unit & Integration Tests
* [ ] CI/CD Pipeline

---

# Future Enhancements

* Product Service
* Inventory Service
* Payment Service
* Notification Service
* Order History
* Email Notifications
* Kafka Event Streaming
* Redis Caching
* Prometheus & Grafana Monitoring
* ELK Stack Logging
* Kubernetes Deployment

---

# Learning Outcomes

This project demonstrates hands-on experience with:

* Java Backend Development
* Spring Boot
* Microservices Architecture
* REST API Design
* Spring Security
* JWT Authentication
* PostgreSQL
* API Gateway
* React Integration
* Git Workflow
* Production-Oriented Project Structure

---

# Author

**Subhashree A**

Aspiring Java Backend / Software Engineer passionate about building scalable backend systems using Spring Boot, Microservices, and Cloud technologies.
