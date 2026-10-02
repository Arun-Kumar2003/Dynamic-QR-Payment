DynamicPay QR -- Dynamic Payment QR Code Generation System

A college project that generates dynamic UPI payment QR codes based on
the amount entered by the user.

Technologies Used

React JS

Java

Spring Boot

Spring Data JPA

PostgreSQL

Spring Security

Axios

QRCode React

Project Flow

React Frontend
      |
      | Enter amount
      v
Generate QR
      |
      | POST /api/payments
      v
Spring Boot Backend
      |
      +---- Store payment details ----> PostgreSQL
      |
      +---- Generate UPI QR data
      v
React displays QR Code

Features

Enter a dynamic payment amount.

Generate a unique order ID.

Store payment details in PostgreSQL.

Generate UPI payment QR data with the entered amount.

Display the generated QR code in the React frontend.

REST API communication between React and Spring Boot.

Backend API

Create Payment

Method: POST

Endpoint:

http://localhost:8080/api/payments

Request Body:

{
  "amount": 384.00
}

Example Response:

{
  "orderId": "ORD-A1B2C3D4",
  "amount": 384.00,
  "currency": "INR",
  "status": "CREATED",
  "qrData": "upi://pay?pa=yourupi@upi&pn=College%20Project&am=384&cu=INR&tr=ORD-A1B2C3D4"
}

Database

PostgreSQL is used to store payment records.

Example database configuration:

spring.datasource.url=jdbc:postgresql://localhost:5432/payment
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update

Do not upload real database passwords or other credentials to GitHub.

Running the Backend

Open the Spring Boot project in STS or another Java IDE.

Configure PostgreSQL and the payment1 database.

Update your database credentials.

Run the Spring Boot application.

The backend runs on:

http://localhost:8080

Running the Frontend

Open the React project in a terminal and run:

npm install
npm run dev

The React application normally runs on:

http://localhost:5173

Note

This project is developed for academic and demonstration purposes. It
demonstrates dynamic UPI QR generation and storage of payment details.
It is not a production payment-processing system.
