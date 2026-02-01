# Architecture

SafeLink follows **Clean Architecture** principles with Kotlin Multiplatform.

## Module Overview

```
├── composeApp/         # UI Layer (Jetpack Compose Multiplatform)
│   ├── commonMain/     # Shared UI code (Screens, Components, Navigation)
│   ├── androidMain/    # Android entry point (MainActivity)
│   ├── desktopMain/    # Desktop entry point (Main.kt)
│   └── iosMain/        # iOS bridge (MainViewController)
│
├── shared/             # Core Business Logic & Data
│   ├── domain/         # Models, Repository Interfaces, Use Cases
│   ├── data/           # Repository Implementations, SQLDelight DB
│   └── di/             # Koin Dependency Injection
│
├── iosApp/             # Native iOS Shell (SwiftUI)
└── gradle/             # Build Configuration
```

## Layer Responsibilities

| Layer | Module | Responsibility |
|-------|--------|----------------|
| **UI** | `composeApp` | Screens, navigation, user interaction |
| **Domain** | `shared/domain` | Business rules, use cases, models |
| **Data** | `shared/data` | Database, repositories, platform abstractions |
| **DI** | `shared/di` | Koin modules for dependency injection |

## Tech Stack

| Component | Technology |
|-----------|------------|
| Language | Kotlin 2.0+ |
| UI | Jetpack Compose / Compose Multiplatform |
| DI | Koin |
| Database | SQLDelight |
| Async | Coroutines & Flows |
| Navigation | Navigation Compose |

## Data Flow

```
UI (Compose) → ViewModel → UseCase → Repository → SQLDelight Database
```

## Platform Abstractions

The project uses Kotlin's `expect/actual` pattern for platform-specific code:

| Feature | Common (`expect`) | Platform (`actual`) |
|---------|------------------|---------------------|
| Database Driver | `DatabaseDriverFactory` | Android/iOS/Desktop implementations |
| Location | `LocationService` | Platform-specific APIs |
| Messaging | `MessagingService` | SMS (Android), etc. |
