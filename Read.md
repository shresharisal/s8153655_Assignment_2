# NIT3213 Final Assignment – Student ID: s8153655

## 🧩 Overview
This Android app is developed as part of **NIT3213 Mobile Application Development**.  
It demonstrates **MVVM architecture**, **Hilt Dependency Injection**, **Retrofit networking**, and **Jetpack Compose UI**.

The app simulates a simple login system and displays dashboard data fetched from an API.

---

## 🛠️ Tech Stack
| Layer | Technology Used |
|--------|------------------|
| **UI** | Jetpack Compose, Material 3 |
| **Architecture** | MVVM (Model–View–ViewModel) |
| **Dependency Injection** | Dagger Hilt |
| **Networking** | Retrofit + Gson |
| **Concurrency** | Kotlin Coroutines |
| **Testing** | JUnit 4, Mockito, Coroutine Test |

---

## 🧭 App Structure

│
├── data/
│ ├── model/ # Data classes (Entity, LoginResponse)
│ ├── remote/ # Retrofit API interface
│ └── repository/ # Repository implementation
│
├── domain/
│ ├── repository/ # Repository interface
│ └── usecase/ # Business logic (LoginUseCase, GetDashboardUseCase)
│
├── ui/
│ ├── viewmodel/ # ViewModels (LoginViewModel, DashboardViewModel)
│ └── screen/ # Composables (LoginScreen, DashboardScreen, DetailsScreen)
│
├── di/ # Hilt modules
└── MyApplication.kt # Hilt Application class

