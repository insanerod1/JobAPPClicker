package compose.project.jobappclicker.storage
import java.io.File
import kotlinx.serialization.json.Json

class DesktopGameStorage : GameStorage{
    // finds current user's home folder, and save path is put in that folder
    private val saveFile = File(
        File(System.getProperty("user.home"), "jobappclicker"),
        "save.json"
    )

    private val json = Json {
        encodeDefaults = true //default values
        ignoreUnknownKeys = true //if save contains a field gamesave doesnt define, can still load
    }

    override fun save(game: GameSave) {
        saveFile.parentFile.mkdirs() //makes file if needed
        saveFile.writeText(json.encodeToString(game))
    }
    //returns null if file doesn't exist. if it does exist, readText gets contents
    override fun load(): GameSave? {
        if(!saveFile.exists()) return null
        return json.decodeFromString<GameSave>(saveFile.readText())
        //decodeFromString, turns JSON back into a game save
    }

}