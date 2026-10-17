package compose.project.jobappclicker.audioManager

enum class MusicTrack (
    val filePath: String
    ) {
    TRACK_ONE("files/audio/BackgroundTrack-1.mp3"),
    TRACK_TWO("files/audio/BackgroundTrack-2.mp3"),
    TRACK_THREE("files/audio/BackgroundTrack-3.mp3"),
    CLICK("files/audio/click.wav"),
    INVALID("files/audio/invalid.wav"),
    PURCHASE("files/audio/purchase.wav");

    companion object {
        val playlist = listOf(TRACK_ONE, TRACK_TWO, TRACK_THREE)
    }
}