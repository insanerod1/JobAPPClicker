package compose.project.jobappclicker.storage


interface GameStorage {
    //receives the player's current score, click rates, and upgrades
    // TODO: Convert GameSave to JSON in the storage implementation.
    // TODO: Browser implementation stores JSON in local storage.
    // TODO: Desktop implementation stores JSON in a save file.
    fun save(game: GameSave)

    //returns a saved play, or null if no save exists
    // TODO: Read stored JSON and convert it back into GameSave.
    // TODO: Handle invalid save data without overwriting it.
    // Returns null when no save exists.
    fun load(): GameSave?




}