# RedReader MVVM 

This repository contains a **complete reimplementation** of a Reddit-style Android application inspired by the open-source **RedReader** project.  
The application was developed **from scratch** using modern Android development practices, with a primary focus on **MVVM architecture, clean code organization, and feature extensibility**.

> **Important**  
> This repository is **not a fork** of the original RedReader codebase.  
> All source code, architecture, and feature implementations in this repository were written independently.


## Motivation

The original RedReader project is a mature and widely used open-source Reddit client. However, its architecture reflects earlier Android design patterns, where UI components are tightly coupled with control and data-handling logic. This makes feature modification and extension more complex over time.

The goal of this project was to:
- Rebuild a RedReader-like application using **MVVM**
- Enforce **clear separation of concerns**
- Improve **maintainability and developer experience**
- Serve as a **reference implementation** for modern Android architecture


## Architecture Overview

This project follows a **Model–View–ViewModel (MVVM)** architecture with a dedicated **Repository layer**.

### High-level structure

- **View (Activity / Fragment)**
  - Renders UI
  - Observes ViewModel state
  - Handles user interactions only

- **ViewModel**
  - Manages UI-related state
  - Contains presentation logic
  - Survives configuration changes

- **Repository**
  - Acts as a single source of truth
  - Abstracts data access
  - Handles preferences and data providers

- **Model**
  - Plain data objects representing users, posts, and settings


## Implemented Features

All features listed below were **designed and implemented as part of this reimplementation**.

### User Profile
- Displays user name, avatar, and basic account information
- Includes an About/Bio section
- Shows a scrollable list of user-created posts
- Each post displays metadata such as subreddit, votes, comments, and time

### Settings Module
A unified settings interface providing access to multiple configuration options:

- **App Theme**
  - Light / Dark mode switching
  - Theme selection persists across restarts

- **Start Screen Selection**
  - Choose default launch screen:
    - Home
    - Trending
    - Favourite

- **Notifications**
  - Opens notifications section

- **Privacy Policy**
  - Displays policy content using a reusable informational screen

- **Help Center**
  - Provides access to help and support resources

- **Terms of Service**
  - Displays terms content

- **About App / About Phone**
  - Shows application version and device information
  - Implemented using Material Design principles

### Reusable Informational Screens
- A single reusable Activity is used to render multiple informational pages
- Content is configured at runtime using intent parameters
- Reduces UI duplication and simplifies navigation logic


## Project Structure

The project is organized by **responsibility** rather than by individual screens. This structure reflects the MVVM architecture and makes it easier for developers to understand, modify, and extend the codebase.

app/
- ui/
- viewmodel/
- repository/
- model/
- util/

### ui
Contains all user interface components, including Activities, Fragments, and RecyclerView adapters.  
Classes in this package are responsible only for rendering UI and handling user interactions.  
They observe state exposed by ViewModels and do not contain business logic or direct data access.

### viewmodel
Contains all ViewModel classes.  
ViewModels manage UI-related state, handle presentation logic, and survive configuration changes.  
They expose observable data to the UI layer and interact with repositories to retrieve or persist data.

### repository
Contains repository classes that act as the single source of truth for application data.  
Repositories abstract data access and hide implementation details related to preferences, configuration values, and future data sources.  
This layer ensures that ViewModels remain independent of how or where data is stored.

### model
Contains plain data objects representing domain entities such as users, posts, and settings.  
These classes are UI-independent and are used across layers to pass structured data.

### util
Contains utility and helper classes shared across the application.  
This includes configuration helpers, theme managers, and other reusable components that do not belong to a specific feature or layer.

## How to Build and Run

### Steps

- Open the project in Android Studio
- Allow Gradle to sync
- Build the project
  - Build → Make Project
- Run the application on one of the following:
  - Android Emulator
  - Physical Android device (USB debugging enabled)


## Testing and Validation

- Manual testing performed
- Verified:
  - Configuration changes (screen rotation)
  - ViewModel state persistence
- Ensured:
  - Consistent navigation behavior
  - Correct preference behavior
- Architecture supports:
  - Future unit testing
  - Future integration testing


## Relationship to Original RedReader

- Inspired by the original RedReader application
- Original repository:
  - https://github.com/QuantumBadger/RedReader
- No source code was copied
- Used only as a conceptual reference


## License

- Intended for academic and educational use

## Author

- **Marufa Jahan Rume**
- GitHub:
  - https://github.com/marufajahanrume


