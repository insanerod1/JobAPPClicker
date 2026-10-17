package compose.project.jobappclicker.models.upgrades

object UpgradeCatalog {
    fun createDefaultUpgrade(): MutableList<Upgrade> {
        return mutableListOf(
            ClickerUpgrades(
                name = "Better Applications",
                clickIncrease = 2,
                initCost = 10,
                secondaryCostFactor = 5
            ),
            ClickerUpgrades(
                name = "Resume Improvements",
                clickIncrease = 5,
                initCost = 50,
                secondaryCostFactor = 10
            ),
            ClickerUpgrades(
                name = "One-Thousand Pencils",
                clickIncrease = 10,
                initCost = 500,
                secondaryCostFactor = 100
            ),


            AutoClickerUpgrades(
                name = "Auto-Apply Script",
                autoClickIncrease = 1,
                initCost = 100,
                secondaryCostFactor = 50
            ),
            AutoClickerUpgrades(
                name = "Resume Submission Bot",
                autoClickIncrease = 5,
                initCost = 500,
                secondaryCostFactor = 250
            ),
            AutoClickerUpgrades(
                name = "Application Farm",
                autoClickIncrease = 20,
                initCost = 2500,
                secondaryCostFactor = 1250
            )
        )
    }
}