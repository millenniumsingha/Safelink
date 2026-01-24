# SafeLink (KMP Edition)

SafeLink is a cross-platform personal safety application built with **Kotlin Multiplatform (KMP)** and **Compose Multiplatform**. It allows users to manage emergency contacts and send SOS alerts with their location.

## 🏗 Architecture

The project follows a **Clean Architecture** approach with a single Shared Module:

*   **`composeApp`**: The UI layer (Jetpack Compose).
    *   `commonMain`: Shared UI code (Screens, Components, Navigation).
    *   `androidMain`: Android entry point (`MainActivity`).
    *   `desktopMain`: Desktop entry point (`Main.kt`).
    *   `iosMain`: iOS bridge (`MainViewController`).
*   **`shared`**: The core business logic and data.
    *   `domain`: Models, Repository Interfaces, Use Cases.
    *   `data`: Repository Implementations, SQLDelight Databases (`Contact.sq`).
    *   `di`: Dependency Injection (Koin).
*   **`iosApp`**: The native iOS project (SwiftUI) that consumes the shared framework.

## 🚀 Getting Started

### Prerequisites
*   **JDK 17+**
*   **Android Studio** (for Android/Desktop development)
*   **Xcode** (for iOS development, macOS only)

### Android
1.  Open the project in Android Studio.
2.  Select the `composeApp` configuration.
3.  Run on an emulator or device.

### Desktop
1.  Open the terminal.
2.  Run: `./gradlew :composeApp:run`

### iOS (macOS Only)
1.  Navigate to `iosApp/`.
2.  Open `iosApp.xcodeproj` in Xcode.
3.  Ensure the scheme is set to `iosApp`.
4.  Run on a Simulator or Device.

## 🔒 Permissions

To ensure the SOS functionality works as intended, the application requires the following permissions:

### 🤖 Android
*   **Location** (`ACCESS_FINE_LOCATION`, `ACCESS_COARSE_LOCATION`): Used to attach accurate coordinates to emergency alerts.
*   **SMS** (`SEND_SMS`): Used to send the SOS message directly to your emergency contacts.

### 🍎 iOS
*   **Location** (`NSLocationWhenInUseUsageDescription`): Required to access your current location for alerts.

### 🖥️ Desktop
*   **Location**: MacOS and Windows may prompt to allow location access for the application to function correctly.

## 🛠 Tech Stack
*   **Language**: Kotlin 2.0+
*   **UI**: Jetpack Compose / Compose Multiplatform
*   **DI**: Koin
*   **Database**: SQLDelight
*   **Async**: Coroutines & Flows
*   **Navigation**: Navigation Compose

## 📂 Project Structure
```text
├── composeApp/         # Shared UI & Platform Entry Points
├── shared/             # Domain, Data, & Logic
├── iosApp/             # Native iOS Shell
└── gradle/             # Build Configuration
```
