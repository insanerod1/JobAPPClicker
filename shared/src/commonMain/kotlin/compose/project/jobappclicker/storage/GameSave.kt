package compose.project.jobappclicker.storage

import kotlinx.serialization.Serializable


@Serializable
data class SavedUpgrade(
    val upgradeId: String, //identifies upgrade
    val quantityPurchased: Int=0 //stores purchased quantity
)

@Serializable
data class GameSave(
    val score: Int = 0, //stores score
    val lastSavedTime: Long = 0L, //holds timestamp in milliseconds, 0L (no time stamp recorded yet)
    val upgrades: List<SavedUpgrade> = emptyList(), //new player no upgrades
    val lifetimeScore: Int = 0,
)