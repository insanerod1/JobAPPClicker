package compose.project.jobappclicker.storage

import kotlinx.serialization.json.Json
import web.storage.localStorage

//implements interface GameStorage
class BrowserGameStorage(
    private val saveKey: String = "jobAppClickerSave"
) : GameStorage {

    private val json = Json {
        encodeDefaults = true
        ignoreUnknownKeys = true
    }

    //converts your data into JSON and stores it
    override fun save(game: GameSave) {
        val jsonText = json.encodeToString(game)
        localStorage.setItem(saveKey, jsonText)
    }
    //reads that JSON and converts it back into GameSave
    override fun load(): GameSave? {
        val jsonText = localStorage.getItem(saveKey) ?: return null
        return json.decodeFromString<GameSave>(jsonText)
    }


}