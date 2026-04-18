# Nav3Kmp Project Overview

Nav3Kmp is a modern Kotlin Multiplatform (KMP) project that demonstrates a cutting-edge tech stack for cross-platform development targeting **Android**, **iOS**, **Desktop (JVM)**, and **Web (Wasm)**. It leverages Compose Multiplatform for shared UI and experimental libraries like Navigation 3.

## 🚀 Key Technologies
- **UI:** [Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform) with Material 3.
- **Navigation:** [Navigation 3 (androidx-nav3)](https://developer.android.com/jetpack/androidx/releases/navigation) for declarative navigation.
- **Adaptive UI:** `NavigationSuiteScaffold` from Compose Material 3 Adaptive for responsive layouts.
- **Dependency Injection:** [Koin](https://insert-koin.io/) (with Koin Annotations support).
- **Local Database:** [Room 3 (KMP)](https://developer.android.com/jetpack/androidx/releases/room) with SQLite.
- **Networking:** [Ktor](https://ktor.io/) with Kotlinx Serialization.
- **Secure Storage:** [KSafe](https://github.com/Anifantakis/KSafe) for cross-platform secure data.
- **Logging:** [Kermit](https://github.com/touchlab/Kermit).

## 🏗 Project Architecture
The project follows a modularized clean architecture:
- **`:composeApp`**: The main shared UI module containing Screens, ViewModels, and App entry point.
- **`:core:data`**: The data layer, managing repositories and integrating database/network sources.
- **`:core:database`**: Contains Room database definitions, entities, and DAOs.
- **`:core:designsystem`**: Shared UI components, themes, and design tokens.
- **`:core:safe`**: Security-related logic and secure storage abstractions.
- **`:iosApp`**: The native iOS entry point (Swift).
- **`:mykmpapp`**: An auxiliary Android application module.

## 🛠 Building and Running

### Android
```bash
./gradlew :composeApp:assembleDebug
```

### Desktop (JVM)
```bash
./gradlew :composeApp:run
```

### Web (Wasm)
```bash
./gradlew :composeApp:wasmJsBrowserDevelopmentRun
```

### iOS
Open the `iosApp` directory in Xcode or use the IDE's run configuration.

### Static Analysis & Formatting
- **Linting:** `./gradlew ktlintFormat`
- **Static Analysis:** `./gradlew detekt`

## 📖 Development Conventions
- **Navigation:** Use `Navigation 3` patterns. Screens are defined as `entry` within `NavDisplay` in `App.kt`.
- **ViewModels:** Shared ViewModels should extend `ViewModel` from `androidx.lifecycle` and be injected via `koinViewModel()`.
- **Dependency Injection:** Register modules in `di/` folders and use Koin's DSL or Annotations.
- **Database:** Define Room entities and DAOs in `:core:database`. Use the `room3` Gradle plugin for schema management.
- **Resources:** Use `Compose Resources` for strings, drawables, and fonts.

## 🗺 Module Graph
A script is available to regenerate dependency graphs:
```bash
./generateModuleGraphs.sh
```
Graphs are stored in `docs/images/graphs/`.
