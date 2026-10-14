package compose.project.jobappclicker.controllers

import compose.project.jobappclicker.models.Player
import compose.project.jobappclicker.models.upgrades.AutoClickerUpgrades
import compose.project.jobappclicker.models.upgrades.ClickerUpgrades
import compose.project.jobappclicker.models.upgrades.Upgrade


class PlayerController(private val player: Player) {
    fun click() {
        player.lifetimeScore += player.clickRate
        player.score += player.clickRate
    }
    fun upgradeUpgrade(Upgrade: Upgrade) {
        Upgrade.numberpurchased++
    }
    fun getScore(): Int {
        return player.score
    }
    fun getUpgradeList(): List<Upgrade> {
        return player.upgrades
    }

}