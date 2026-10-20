package compose.project.jobappclicker.audioManager

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

object AudioSettings {
    var musicEnabled by mutableStateOf(true)
    var soundEnabled by mutableStateOf(true)
}