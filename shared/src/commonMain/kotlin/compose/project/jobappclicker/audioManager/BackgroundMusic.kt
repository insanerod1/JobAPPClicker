package compose.project.jobappclicker.audioManager

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import io.github.kdroidfilter.composemediaplayer.audio.AudioPlayer
import io.github.kdroidfilter.composemediaplayer.audio.AudioPlayerState
import io.github.kdroidfilter.composemediaplayer.audio.rememberAudioPlayerLiveState

@Composable
fun BackgroundMusic() {
    val audioState = rememberAudioPlayerLiveState()

    val audioManager = remember {
       AudioManager(audioState.player)
    }

    var wasPlaying by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        audioManager.playPlaylist()
    }

    LaunchedEffect(audioState.state) {
        when (audioState.state) {
            AudioPlayerState.PLAYING -> {
                wasPlaying = true
            }

            AudioPlayerState.IDLE -> {
                if (wasPlaying) {
                    wasPlaying = false
                    audioManager.playNextTrack()
                }
            }
        else -> {
            //if paused or buffering
        }}
    }
}