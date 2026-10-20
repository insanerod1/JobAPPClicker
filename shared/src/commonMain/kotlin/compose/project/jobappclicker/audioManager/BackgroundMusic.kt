package compose.project.jobappclicker.audioManager

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import io.github.kdroidfilter.composemediaplayer.audio.AudioPlayerState
import io.github.kdroidfilter.composemediaplayer.audio.rememberAudioPlayerLiveState

@Composable
fun BackgroundMusic() {
    val audioState = rememberAudioPlayerLiveState()

    val audioManager = remember {
        AudioManager(audioState.player)
    }

    val musicEnabled = AudioSettings.musicEnabled
    var wasPlaying by remember { mutableStateOf(false) }

    LaunchedEffect(musicEnabled) {
        if (musicEnabled) {
            audioManager.playPlaylist()
        } else {
            wasPlaying = false
            audioManager.stopMusic()
        }
    }

    LaunchedEffect(audioState.state, musicEnabled) {
        when (audioState.state) {
            AudioPlayerState.PLAYING -> {
                wasPlaying = musicEnabled
            }

            AudioPlayerState.IDLE -> {
                if (musicEnabled && wasPlaying) {
                    wasPlaying = false
                    audioManager.playNextTrack()
                }
            }

            else -> {
                // Do nothing while paused or buffering.
            }
        }
    }
}