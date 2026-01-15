Sentilytics – Intelligent Sentiment Analysis System

Sentilytics is a full-stack, machine learning–powered sentiment analysis system that analyzes movie reviews and classifies them as Positive or Negative with a confidence score.  
The project integrates Java, Spring Boot, Weka ML, MySQL, and a professional analytics dashboard UI.

This project demonstrates an end-to-end AI backend system with persistence, analytics, API documentation, and a modern frontend.

---

Features

- Machine Learning–based sentiment prediction (Weka – Logistic Regression)
- Text preprocessing with TF-IDF (`StringToWordVector`)
- RESTful APIs using Spring Boot
- MySQL database integration
- Prediction history & analytics (total / positive / negative)
- Swagger UI for API documentation
- Professional dashboard frontend (HTML, CSS, JS)
- Robust error handling
- Runnable production-ready JAR

---

System Architecture

Frontend (HTML/CSS/JS)
↓
Spring Boot REST API
↓
Weka ML Model (Logistic Regression)
↓
MySQL Database

---

Tech Stack

Backend
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Weka ML (TF-IDF + Logistic Regression)
- MySQL
- Maven

Frontend
- HTML5
- CSS3 (Modern Dashboard UI)
- JavaScript (Fetch API)

Tools
- Postman
- Swagger UI
- VS Code / IntelliJ IDEA

---

Project Structure

sentiment-analysis/
│
├── src/main/java/com/movie/sentiment
│ ├── controller
│ ├── service
│ ├── repository
│ ├── entity
│ ├── ml
│ ├── dto
│ └── config
│
├── src/main/resources
│ ├── application.properties
│ ├── dataset/
│ └── model/
│
├── frontend/
│ ├── index.html
│ ├── style.css
│ └── app.js
│
├── pom.xml
└── README.md

---

Machine Learning Details

- Algorithm: Logistic Regression
- Feature Extraction: TF-IDF (`StringToWordVector`)
- Dataset: IMDb movie reviews (ARFF format)
- Evaluation Metrics:
  - Accuracy
  - Precision
  - Recall
  - F1-Score

---

Database Setup (MySQL)

Create Database

CREATE DATABASE sentiment_db;
USE sentiment_db;
Tables are auto-created by Hibernate.

---

Configuration
Update src/main/resources/application.properties:

server.port=8081

spring.datasource.url=jdbc:mysql://localhost:3306/sentiment_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect

spring.jpa.open-in-view=false

---

How to Run the Project
Train the ML Model (One Time)

mvn compile exec:java "-Dexec.mainClass=com.movie.sentiment.ml.ModelTrainer"

This creates:
src/main/resources/model/sentiment.model

Build the Project
mvn clean install -DskipTests

---

Run Backend (Spring Boot)

Option A: Using Maven
mvn spring-boot:run

Option B: Using JAR (Production Mode)
java -jar target/sentiment-0.0.1-SNAPSHOT.jar

Backend runs at:
http://localhost:8081

---

Swagger API Documentation

Open in browser:
http://localhost:8081/swagger-ui.html

Available APIs:

POST /api/sentiment/predict
GET /api/sentiment/history
GET /api/sentiment/history/positive
GET /api/sentiment/history/negative
GET /api/sentiment/stats

---

Frontend Setup

Option 1: Direct Open
Go to frontend/
Double-click index.html

Option 2 (Recommended): Live Server
Install Live Server extension in VS Code
Right-click index.html → Open with Live Server
Frontend connects automatically to backend.

---

Dashboard Features

Sentiment analysis input
Confidence visualization
Prediction history table
Live statistics (Total / Positive / Negative)
Error & loading handling

---

Deployment Ready

Fully packaged as a runnable JAR
Can be deployed on:
Local server
AWS / Azure / Render
Docker (optional extension)

---

Future Enhancements
Aspect-based sentiment analysis
Deep learning models (LSTM / BERT)
User authentication
Real-time analytics dashboard
Cloud deployment
