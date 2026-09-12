package com.example.pattikkoodu.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.random.Random

data class InstallationState(
    val progress: Float = 0f,
    val currentJargon: String = "Preparing to install...",
    val logs: List<String> = emptyList(),
    val isCrashed: Boolean = false
)

class InstallationViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(InstallationState())
    val uiState: StateFlow<InstallationState> = _uiState.asStateFlow()

    private val jargonList = listOf(
        "Extracting APK...",
        "Verifying application signature...",
        "Allocating storage space...",
        "Optimizing DEX files...",
        "Compiling Android App Bundle...",
        "Running dex2oat...",
        "Configuring app permissions...",
        "Registering with Package Manager...",
        "Setting up application sandboxes...",
        "Extracting native libraries...",
        "Processing assets...",
        "Scanning for malware...",
        "Preparing application resources...",
        "Finalizing installation..."
    )

    fun startInstallation() {
        viewModelScope.launch {
            // Reset state
            _uiState.value = InstallationState()
            
            var currentProgress = 0f
            // Progress will halt between 90% and 99%
            val maxProgress = Random.nextDouble(0.90, 0.99).toFloat()
            
            while (currentProgress < maxProgress) {
                // Update jargon occasionally
                if (Random.nextFloat() < 0.4f || _uiState.value.logs.isEmpty()) {
                    val newJargon = jargonList.random()
                    _uiState.value = _uiState.value.copy(
                        currentJargon = newJargon,
                        logs = (_uiState.value.logs + newJargon).takeLast(5)
                    )
                }

                // Random delay between progress updates to make it unpredictable
                delay(Random.nextLong(100, 800))
                
                // Random progress increment
                val increment = Random.nextDouble(0.01, 0.08).toFloat()
                currentProgress = (currentProgress + increment).coerceAtMost(maxProgress)
                
                _uiState.value = _uiState.value.copy(progress = currentProgress)
            }
            
            // Reached max progress, hold for a tense moment
            delay(Random.nextLong(1500, 3000))
            
            // Trigger fake crash
            _uiState.value = _uiState.value.copy(
                isCrashed = true,
                currentJargon = "Installation failed: INSTALL_FAILED_CONFLICTING_PROVIDER",
                logs = _uiState.value.logs + "Installation failed: INSTALL_FAILED_CONFLICTING_PROVIDER"
            )
        }
    }

    fun reset() {
        _uiState.value = InstallationState()
    }
}
