package compose.project.jobappclicker.storage



// TODO: Add kotlinx.serialization
data class SavedUpgrade(
    val upgradeId: String, //identifies upgrade
    val quantityPurchased: Int=0 //stores purchased quantity
)


// TODO: Add kotlinx.serialization
data class GameSave(
    val score: Int = 0, //stores score
    val lastSavedTime: Long = 0L, //holds timestamp in milliseconds, 0L (no time stamp recorded yet)
    val upgrades: List<SavedUpgrade> = emptyList() //new player no upgrades
)