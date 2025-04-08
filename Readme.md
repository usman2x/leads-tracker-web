# Leads Management API

A simple CRUD application built with **Spring Boot 3.4.4**, **Java 21**, and **Maven**.

---

## 🚀 Tech Stack

- Java 21
- Spring Boot 3.4.4
- Maven
- H2 In-Memory Database
- Swagger / OpenAPI 3
- Docker

---

## 🔧 Build & Run Locally

### 🛠️ Prerequisites
- Java 21+
- Maven 3.8+
- Docker (for containerized run)

### ▶️ Run with Maven
```bash
mvn clean install
mvn spring-boot:run
```

### 🐳 Run with Docker
```bash
docker build -t leads-api .
docker run -p 8080:8080 leads-api
```

---

## 📘 API Documentation (Swagger UI)

Once the app is running, open in your browser:

```
http://localhost:8080/swagger-ui/index.html
```

---

## 🗄️ H2 Database Console

You can view the in-memory DB using:

```
http://localhost:8080/h2-console
```

- **JDBC URL:** `jdbc:h2:mem:leadsdb`
- **User:** `sa`
- **Password:** *(leave blank)*

---

## 📁 Seed Data

Seed data is auto-loaded on application startup from JSON/CSV (if enabled in config).

---

## ✅ Available Endpoints (Sample)

| Method | Endpoint           | Description        |
|--------|--------------------|--------------------|
| GET    | `/api/leads`       | Get all leads      |
| POST   | `/api/leads`       | Create a new lead  |
| PUT    | `/api/leads/{id}`  | Update a lead      |
| DELETE | `/api/leads/{id}`  | Delete a lead      |

---

## 🧩 Authentication & Authorization (Coming Soon)

- JWT-based login
- Role-based access control (RBAC)

---

## 📄 License

MIT License