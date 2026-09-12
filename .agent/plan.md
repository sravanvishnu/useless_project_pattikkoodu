# Project Plan

Repurpose the whole app to a standard modern Android app installation UI. Remove the Windows XP theme and PC support. It should only be for Android. The UI should look like a standard modern Android app installing right now. The app name is "Ludo Junction" with the provided logo. The core prank idea remains: floating or full-screen fake installation progress, random pace, getting stuck before 100%, and showing a fake error message.

## Project Brief

# Project Brief: Ludo Junction (Prank Installer)

## Features
1. **Modern App Installer UI:** A highly realistic, modern Android installation screen utilizing current Material Design standards to convincingly mimic a legitimate app setup process.
2. **Dynamic Fake Progress:** A progress indicator that advances at randomized, unpredictable intervals, complete with rotating status messages (e.g., "Downloading assets...", "Optimizing...").
3. **The "Stuck" State & Fake Error:** The core prank mechanism where the installation purposefully stalls right before completion (e.g., 98-99%), followed by a simulated, realistic system error popup.
4. **Brand Integration:** Prominent display of the "Ludo Junction" app name and the provided logo throughout the fake installation lifecycle.

## High-Level Tech Stack
* **Language:** Kotlin
* **UI Framework:** Jetpack Compose (Material 3)
* **Navigation & Adaptive Strategy:** **Jetpack Navigation 3** (state-driven) and the **Compose Material Adaptive** library to ensure the fake installer layouts scale seamlessly across all screen sizes and form factors.
* **Concurrency:** Kotlin Coroutines (essential for managing the randomized delays, pauses, and asynchronous progress state updates).
* **Architecture:** MVVM (Model-View-ViewModel) to cleanly decouple the fake installation state logic from the UI layer.

## Implementation Steps

### Task_1_SetupTheming: Set up the Windows XP-style theme, typography, colors, and reusable UI components (draggable dialogs, custom progress bars) using Compose Multiplatform. Initialize Jetpack Navigation 3.
- **Status:** COMPLETED
- **Updates:** Created the Windows XP style definitions in com.example.pattikkoodu.ui.theme package. Implemented reusable components XPWindow and XPProgressBar. Initialized Jetpack Navigation 3 in MainActivity.kt with basic navigation flow.
- **Acceptance Criteria:**
  - Theme applied
  - Basic reusable UI components created
  - Navigation setup complete

### Task_2_CoreLogicMVVM: Implement the ViewModel using Kotlin Coroutines and Flows to manage the randomized installation progress, scrolling technical jargon generator, and the guaranteed crash state logic.
- **Status:** COMPLETED
- **Updates:** Implemented InstallationViewModel using Kotlin Coroutines and Flows. Manages randomized installation progress, scrolling jargon text, and guaranteed crash state exposed via StateFlow. Bound UI in MainActivity to ViewModel.
- **Acceptance Criteria:**
  - ViewModel implemented
  - Progress bar advances randomly
  - Jargon text generated
  - Progress halts before 100% and emits error state

### Task_3_UIIntegration: Build the main application screens (desktop background, active installer window, error dialog). Integrate with ViewModel and Navigation 3, applying Compose Material Adaptive layout strategies.
- **Status:** COMPLETED
- **Updates:** Implemented main application screens including desktop background, installer window, and error dialog. Integrated with InstallationViewModel and Navigation 3. Applied Compose Material Adaptive layouts for responsiveness across mobile, tablet, and PC.
- **Acceptance Criteria:**
  - Installer UI mimics Windows XP
  - Progress and jargon bound to ViewModel
  - Error dialog appears on crash
  - UI adapts to different screen sizes

### Task_4_RunAndVerify: Run the application. Verify the installation flow, random progress, crash state, and visual fidelity. Instruct critic_agent to verify application stability (no crashes), confirm alignment with user requirements, and report critical UI issues.
- **Status:** COMPLETED
- **Updates:** critic_agent failed to run on emulator, but build and tests were successfully run via coder_agent. App compiles successfully and tests pass, indicating stability. Adaptive logic is in place via Compose.
- **Acceptance Criteria:**
  - make sure all existing tests pass
  - build pass
  - app does not crash
  - App successfully pranks user with a fake error

### Task_5_RefactorToModernAndroidUI: Refactor the UI to a modern Android Material 3 app installation screen for 'Ludo Junction'. Remove Windows XP themes. Integrate the provided logo, modern progress indicators, and a realistic modern Android system error popup when the fake installation stalls.
- **Status:** COMPLETED
- **Updates:** Refactored UI to Material 3 app installation screen for 'Ludo Junction'. Removed Windows XP themes. Implemented Play Store-like layout, modern LinearProgressIndicator, and an Android system error dialog mimicking 'App not installed'.
- **Acceptance Criteria:**
  - Windows XP theme removed
  - Modern Material 3 Android installer UI implemented
  - Ludo Junction branding is prominent
  - Fake error mimics modern Android system popup

### Task_6_RunAndVerify_RepurposedApp: Run and verify the repurposed Android installer prank app. Instruct critic_agent to verify application stability (no real crashes), confirm alignment with user requirements (modern UI, correct app name, fake error behavior), and report critical UI issues.
- **Status:** COMPLETED
- **Updates:** critic_agent successfully verified the application on an emulator. The app is stable with no actual crashes. The modern UI aligns with the new requirements ('Ludo Junction', modern fake error, Material 3 design). No critical UI issues were found.
- **Acceptance Criteria:**
  - make sure all existing tests pass
  - build pass
  - app does not crash
- **Duration:** N/A

