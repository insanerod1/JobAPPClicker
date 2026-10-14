package compose.project.jobappclicker.models.upgrades

import androidx.compose.animation.core.infiniteRepeatable

object UpgradeCatalog {
    fun createDefaultUpgrade(): MutableList<Upgrade>
    {
        return mutableListOf(
            ClickerUpgrades(
                name = "",
                numberPurchased = 0,
                clickIncrease = 0,
                secondaryCostFactor = 0,
                initCost = 0
            ),
            AutoClickerUpgrades(
                name = "",
                numberPurchased = 0,
                autoClickIncrease = 0,
                initCost = 0,
                secondaryCostFactor = 0,
            )
        )
    }
}
