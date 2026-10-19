package compose.project.jobappclicker.storage


interface GameStorage {
    //saves the score, upgrade quantities, and last saved timestamp.
    // TODO: implement JSON storage for browser and desktop
    fun save(game: GameSave)

    //returns a saved play, or null if no save exists
    // TODO: handle invalid save data without overwriting it
    fun load(): GameSave?




}