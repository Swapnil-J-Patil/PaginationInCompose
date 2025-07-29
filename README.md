# 🛸 Rick & Morty Explorer

An Android app built with **Jetpack Paging 3**, Kotlin, and **Jetpack Compose** to explore characters from the Rick and Morty universe via the [Rick and Morty API](https://rickandmortyapi.com/). Scroll infinitely through characters, view their details, and enjoy smooth pagination with a clean UI.

---

## 📸 Demo

![Image](https://github.com/user-attachments/assets/a3dd0ec7-6d79-4dd3-a4a0-85264464fde7)

---

## 🚀 Features:

- 🧠 **Pagination with Paging 3** — Efficient and smooth infinite scrolling
- 🧑‍🚀 **Rick and Morty API Integration**
- 🧾 **Character detail screen** with episode info
- ⚙️ **MVVM Architecture** using clean layering
- 🎨 Built with **Jetpack Compose**
- 🔄 Pull-to-refresh support
- 🌗 Dark/Light theme ready

---

## 🧪 Tech Stack:

- 🟣 Kotlin
- 🟢 Jetpack Compose
- 🟧 Paging 3
- 🟨 Retrofit
- 🟦 Coroutines + Flow
- 🧪 Hilt for Dependency Injection
- 🟫 Coil for Image Loading

---

## 🧩 How It Works

1. App fetches paged character data from the Rick and Morty API.
2. PagingSource loads characters 20 at a time.
3. PagingData is submitted to a `LazyColumn`.
4. Each character item is clickable and opens a detail screen with more info.

---

## 🚀 Getting Started

### Prerequisites

- Android Studio (latest stable)
- Kotlin 1.9+
- Jetpack Compose Compiler enabled

### How to Use

1. Clone this repository
2. Open the project in Android Studio
3. Run the app on your emulator or physical device
4. Swipe left/right to explore animated soda flavors!

---

## 🛠️ License

This project is licensed under the MIT License.

---

## 🌟 Show Your Support

If you enjoyed the animation or found it inspiring, consider leaving a ⭐ on the repo and sharing it with your dev friends!
