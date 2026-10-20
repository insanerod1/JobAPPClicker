package compose.project.jobappclicker.models

import compose.project.jobappclicker.models.upgrades.Upgrade
import compose.project.jobappclicker.models.upgrades.UpgradeCatalog

class Player(
    var score: Int = 0,
    var lifetimeScore: Int = 0,
    var clickRate: Int = 1,
    var autoClickPerSecond: Int = 0,
    val upgrades: MutableList<Upgrade> = UpgradeCatalog.createDefaultUpgrade()
)
{
    fun reset()
    {
        score = 0
        clickRate = 1
        autoClickPerSecond = 0
        lifetimeScore = 0
        for  (Upgrade in upgrades)
        {
            Upgrade.resetUpgrade()
        }

    }
}

