package compose.project.jobappclicker.audioManager

import io.github.kdroidfilter.composemediaplayer.audio.AudioPlayer
import jobappclicker.shared.generated.resources.Res


class AudioManager(private val player: AudioPlayer) {

    private val playlist = MusicTrack.playlist

    private var currentTrackIndex = 0

    fun playPlaylist() {
        currentTrackIndex = 0
        playCurrentTrack()
    }

    fun playNextTrack() {
        if (currentTrackIndex < playlist.lastIndex) {
            currentTrackIndex++
        } else {
            currentTrackIndex = 0
        }
        playCurrentTrack()
    }

    fun playCurrentTrack() {
        val currentTrack = playlist[currentTrackIndex]
        val audioUri = Res.getUri(currentTrack.filePath)

        player.play(audioUri)
    }



    fun stopMusic() {
        player.stop()
    }
}