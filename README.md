# 📱 SpamShieldAI – Android Frontend

**SpamShieldAI** is an Android-based mobile application designed to detect spam messages using a **Machine Learning (ML) model** deployed on a **FastAPI backend**.
This app allows users to enter or receive text messages and instantly know whether a message is **Spam** or **Not Spam**.

---

## 🚀 Features

* 🧠 Real-time spam message detection
* 🌐 API connection with FastAPI backend
* 📊 Machine Learning model trained on SMS Spam Collection dataset
* ⚡ Fast and lightweight Android app
* 🎨 Simple and user-friendly interface
* 🔐 Secure backend communication using HTTP requests

---

## 🧩 Tech Stack

| Layer                 | Technology Used                   |
| --------------------- | --------------------------------- |
| **Frontend (App)**    | Android Studio, Java/Kotlin       |
| **Backend**           | FastAPI (Python)                  |
| **Machine Learning**  | scikit-learn, pandas, pickle      |
| **Model Type**        | Naive Bayes (Spam Classification) |
| **API Communication** | Retrofit / Volley / HTTPClient    |

---

## 🧠 How It Works

1. The Android app takes user input (SMS text).
2. The app sends the text to the FastAPI backend endpoint:

   ```
   POST http://<your-backend-ip>:8000/predict
   ```
3. The backend loads the trained ML model and vectorizer.
4. The backend returns a prediction:

   * `"Spam"`
   * `"Not Spam"`
5. The app displays the result to the user.

---

## ⚙️ Setup Instructions

### Step 1: Clone the Repository

```bash
git clone https://github.com/Sankara4/spam_shield_ai.git
```

### Step 2: Open in Android Studio

* Open Android Studio
* Select **File → Open → spam_shield_ai**
* Let Gradle sync automatically

### Step 3: Configure Backend URL

In your MainActivity (or API service class), update the backend URL:

```java
String BASE_URL = "http://<your-computer-ip>:8000";
```

Make sure your backend (FastAPI) server is running.

---

## 🧩 Backend Repository

Backend code and ML model are available here:
👉 [Spam Detection Backend (FastAPI)](https://github.com/Sankara4/spam_detector_backend)

---

## 📸 Screenshots

*(You can add screenshots later in this section)*
Example:

```
📱 Home Screen
📊 Prediction Result
```

---

## 👨‍💻 Author

**Chegondi Hemasankarakumar**

* 💼 [LinkedIn Profile](https://www.linkedin.com/in/chegondi-hemasankarakumar-a08817350)
* 📧 Contact: [chegondisankarakumar@gmail.com](mailto:chegondisankara@gmail.com)

---

## 🏁 License

This project is licensed under the **MIT License** – feel free to use and modify it for educational or personal purposes.
