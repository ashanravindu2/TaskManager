# 📝 Task Manager App – Full Stack Project

A full-stack Task Management application built with **Angular** (frontend) and **Spring Boot** (backend). This app allows users to **create**, **view**, **edit**, and **delete** tasks, with data stored in **MySQL** or **MongoDB**. Optional features include **JWT-based authentication** and **Dockerized deployment**.

---

## 📌 Features

### ✅ Core Functionality
- Create, read, update, and delete tasks
- Task status filtering (`TO_DO`, `IN_PROGRESS`, `DONE`)
- Responsive UI with Angular Material or Bootstrap
- Form validation (Reactive Forms preferred)
- Modular code structure (Controllers, Services, Repositories)

### 🔐 Optional (Bonus)
- JWT authentication (Login + Register)
- Protect backend routes with Spring Security
- Attach token from Angular to backend API requests
- Show/hide UI elements based on login status

### 🐳 Optional Docker Support
- Docker Compose for MySQL/MongoDB, backend, and frontend

---

## 🛠️ Tech Stack

| Layer         | Technology            |
|---------------|------------------------|
| Frontend      | Angular, TypeScript, HTML, CSS |
| Backend       | Spring Boot, Java, Spring Data JPA |
| Database      | MySQL or MongoDB       |
| Authentication| JWT, Spring Security (optional) |
| Deployment    | Docker, Docker Compose (optional) |

---

## 📂 Project Structure
TaskManager/ ├── backend/ # Spring Boot backend │ ├── src/main/java/... # Controllers, Services, Models │ └── ... ├── frontend/ # Angular frontend │ ├── src/app/ # Components, Services, Routes │ └── ... ├── docker-compose.yml # Optional: Docker setup └── README.md # Project documentation


---

## 🚀 How to Run the Project

### 🔧 Backend (Spring Boot)

1. Navigate to the backend folder:
   ```bash
   cd backend
./mvnw spring-boot:run

./gradlew bootRun

## Backend runs on: http://localhost:8080


# 💻 Frontend (Angular)

## cd frontend
## npm install
## Run App -  ng serve

## Frontend runs on: http://localhost:4200

# 🧪 API Endpoints

Method	Endpoint	Description
GET	api/v1/task	Get all tasks
GET api/v1/task/{id}	Get a task by ID
POST	/api/v1/task	Create a new task
PUT	/api/vi/task/{id}	Update an existing task
DELETE	/api/vi/task/{id}	Delete a task

# Postman doc check
https://documenter.getpostman.com/view/35385633/2sB2cYd1Vr

# 🔐 JWT Authentication (Optional)

Register
POST /api/v1/auth/sign-up

Angular stores token in localStorage or sessionStorage.

Token sent via:
Authorization: Bearer <JWT_TOKEN>

## Build Angular project:
cd frontend
ng build --prod

## Build backend JAR:
cd backend
./mvnw clean package

## Run containers:
docker-compose up --build

# 🗃️ Database Configuration
📌 MySQL Example (application.properties)

spring.datasource.url=jdbc:mysql://localhost:3306/taskdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

# 🧑‍💻 Credentials (JWT)

If you’ve enabled JWT:

Default Test User:

Username: admin

Password: admin123

🙌 Acknowledgments
Built with ❤️ by [https://github.com/ashanravindu2].


---

Would you like me to:
- Add live command instructions for Docker Compose?
- Create example screenshots you can use in the README?
- Help write the actual Dockerfiles and `docker-compose.yml`?

Let me know!





