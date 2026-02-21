# CODTECH Internship – Task 2  
## REST API Client Using Java

---

## 📌 Introduction
This project is developed as part of the **CODTECH Internship Program (Task 2)**.  
The main objective of this task is to design and implement a **Java-based REST API Client** that can consume a **public REST API**, process the received data, and display the output in a structured and readable format.

The application demonstrates how Java handles:
- HTTP communication
- REST API integration
- JSON parsing
- Error handling

---

## 🎯 Objective
- To understand REST API concepts
- To learn how to make HTTP requests in Java
- To parse JSON responses
- To display API data in a structured console format

---

## 🛠️ Technologies & Tools Used
| Technology | Description |
|-----------|-------------|
| Java | Core programming language |
| HTTPURLConnection | For sending HTTP requests |
| REST API | For fetching real-time data |
| JSON | Data exchange format |
| org.json Library | JSON parsing |
| VS Code / IntelliJ | Development environment |

---

## 🌐 API Information
**API Name:** Open-Meteo Weather API  
**API Type:** Public REST API (No API Key Required)

### Sample API Endpoint
## sample input
API URL:
https://api.open-meteo.com/v1/forecast?latitude=13.08&longitude=80.27&current_weather=true

## sample output
===== Weather Report =====
Location       : Chennai
Temperature    : 31.2 °C
Wind Speed     : 12.5 km/h
Weather Code   : 1
==========================

## sample json

{
  "latitude": 13.1,
  "longitude": 80.3,
  "generationtime_ms": 0.3,
  "current_weather": {
    "temperature": 31.2,
    "windspeed": 12.5,
    "winddirection": 150,
    "weathercode": 1,
    "time": "2026-02-11T10:00"
  }
}

