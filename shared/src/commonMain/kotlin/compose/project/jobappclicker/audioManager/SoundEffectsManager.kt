package compose.project.jobappclicker.audioManager

import io.github.kdroidfilter.composemediaplayer.audio.AudioPlayer
import jobappclicker.shared.generated.resources.Res

class SoundEffectsManager {

    private val soundEffects = AudioPlayer()



    fun playClickSound() {
        val audioUri = Res.getUri(MusicTrack.CLICK.filePath)
        soundEffects.setVolume(0.5f)
        soundEffects.play(audioUri)
    }

    fun playPurchaseSound() {
        val audioUri = Res.getUri(MusicTrack.PURCHASE.filePath)
        soundEffects.setVolume(0.5f)
        soundEffects.play(audioUri)
    }
}