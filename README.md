# SafeLink (KMP Edition)

![Build Status](https://github.com/millenniumsingha/Safelink/actions/workflows/ci.yml/badge.svg)
![CodeQL](https://github.com/millenniumsingha/Safelink/actions/workflows/codeql.yml/badge.svg)
![Coverage](https://img.shields.io/badge/coverage-enabled-brightgreen)

SafeLink is a cross-platform personal safety application built with **Kotlin Multiplatform (KMP)** and **Compose Multiplatform**. It allows users to manage emergency contacts and send SOS alerts with their location.

## 📚 Documentation

- **[ARCHITECTURE.md](ARCHITECTURE.md)** — Technical design, module structure, and data flow.
- **[CONTRIBUTING.md](CONTRIBUTING.md)** — How to contribute to the project.
- **[CHANGELOG.md](CHANGELOG.md)** — Full release history.

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

### iOS (macOS Only) — 🚧 Structure Ready

> **Note:** The KMP shared framework compiles for iOS targets, but the native SwiftUI app is not yet implemented. iOS development requires macOS + Xcode, which is not available in this environment.
>
> **What's complete:** Shared Kotlin code, `expect/actual` platform abstractions, framework export configuration.
>
> **What's needed:** Swift/SwiftUI app to consume the `Shared.framework`.

Once a Mac is available:
1.  Navigate to `iosApp/`.
2.  Open `iosApp.xcodeproj` in Xcode.
3.  Implement the SwiftUI app consuming `Shared.framework`.
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


## 📂 Project Structure
```text
├── composeApp/         # Shared UI & Platform Entry Points
├── shared/             # Domain, Data, & Logic
├── iosApp/             # Native iOS Shell
└── gradle/             # Build Configuration
```

## 🗺️ Roadmap

| Milestone | Description | Status |
|-----------|-------------|--------|
| **v2.0** | KMP Migration — Android, Desktop, iOS framework | ✅ Complete |
| **v2.1** | Release Signing + Windows Packaging | ✅ Complete |
| **v2.1.1** | Release Assets (APK + MSI) | ✅ Complete |
| **v2.1.3** | Tests + Coverage + CI Integration | ✅ Complete |
| **v2.2** | iOS Native App — SwiftUI integration | 🚧 Pending (requires macOS) |
| **v3.0** | Cloud Sync & Auth — Cross-device backup | 📋 Planned |
