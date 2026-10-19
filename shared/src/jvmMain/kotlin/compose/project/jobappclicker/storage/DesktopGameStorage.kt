package compose.project.jobappclicker.storage
import java.io.File
import kotlinx.serialization.json.Json

class DesktopGameStorage : GameStorage{
    private val saveFile = File(
        File(System.getProperty("user.home"), "jobappclicker"),
        "save.json"
    )

    private val json = Json {
        encodeDefaults = true
        ignoreUnknownKeys = true
    }

    override fun save(game: GameSave) {
        saveFile.parentFile.mkdirs()
        saveFile.writeText(json.encodeToString(game))
    }
    override fun load(): GameSave? {
        if(!saveFile.exists()) return null
        return json.decodeFromString<GameSave>(saveFile.readText())
    }

}