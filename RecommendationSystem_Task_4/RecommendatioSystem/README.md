# 🤖 AI-Based Recommendation System  
### CODTECH Internship – Task 4  

---

## 📌 Project Overview  

This project is an **AI-Based Recommendation System** developed using **Java**.  

The system suggests products to users based on sample rating data. It analyzes user preferences and recommends the top-rated products that the user has not already rated.

This implementation demonstrates the basic working principle of recommendation engines used in platforms like Amazon, Netflix, and Spotify.

---

## 🎯 Objective  

- Build a recommendation system using Java  
- Analyze user preference data  
- Suggest products based on ratings  
- Implement simple AI-based recommendation logic  

---

## 🛠️ Technologies Used  

- Java  
- File Handling (CSV)  
- Collections Framework (HashMap)  
- Sorting & Stream API  

---

## 📂 Project Structure  

RecommendationSystem/  
│  
├── RecommendationSystem.java  
└── ratings.csv  

---

## 📊 Dataset Format  

The system uses a CSV file containing user-product ratings in the format:

UserName,ProductName,Rating  

Example:

User1,Laptop,4  
User1,Mobile,5  
User2,Tablet,4  

---

## ⚙️ How It Works  

1. The program reads user ratings from `ratings.csv`.
2. It calculates the average rating for each product.
3. It removes products already rated by the current user.
4. It recommends the top 3 highest-rated products.

---

## ▶️ How to Run the Project  

### Step 1: Compile  
