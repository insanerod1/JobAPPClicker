package compose.project.jobappclicker.audioManager

import io.github.kdroidfilter.composemediaplayer.audio.AudioPlayer
import jobappclicker.shared.generated.resources.Res

class SoundEffectsManager {
    private val soundEffects = AudioPlayer()

    fun playClickSound() {
        val audioUri = Res.getUri(MusicTrack.CLICK.filePath)
        soundEffects.play(audioUri)
    }

    fun playPurchaseSound() {
        val audioUri = Res.getUri(MusicTrack.PURCHASE.filePath)
        soundEffects.play(audioUri)
    }
}