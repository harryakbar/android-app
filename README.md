# Pokémon App — Android

An Android app that displays a list of Pokémon and their details, built with Jetpack Compose and the [PokéAPI](https://pokeapi.co/).

## Features

- Browse a list of Pokémon
- View details: name, ID, height, weight, and sprite image
- Bottom navigation
- MVVM architecture with ViewModel + StateFlow

## Tech Stack

- **Language:** Kotlin
- **UI:** Jetpack Compose
- **Architecture:** MVVM
- **State:** StateFlow
- **Serialization:** Kotlinx Serialization
- **API:** [PokéAPI](https://pokeapi.co/)
- **CI:** GitHub Actions

## Getting Started

### Prerequisites

- Android Studio (latest stable)
- Android SDK 26+

### Run

1. Clone the repo
2. Open in Android Studio
3. Run on emulator or physical device

```bash
git clone https://github.com/harryakbar/android-app.git
```

## Architecture

```
app/
└── src/main/java/dev/harryakbar/
    ├── MainActivity.kt
    ├── MainScreen.kt
    ├── BottomNavItem.kt
    └── pokemon/
        ├── Pokemon.kt              # Data models
        ├── PokemonListScreen.kt    # List UI
        ├── PokemonListViewModel.kt # List state
        ├── PokemonDetailScreen.kt  # Detail UI
        └── PokemonDetailViewModel.kt
```
