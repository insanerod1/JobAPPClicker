package compose.project.jobappclicker.storage


interface GameStorage {
    //saves the score, upgrade quantities, and last saved timestamp.
    fun save(game: GameSave)

    //returns a saved play, or null if no save exists
    fun load(): GameSave?




}