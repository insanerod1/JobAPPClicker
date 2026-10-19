package compose.project.jobappclicker.controllers

import compose.project.jobappclicker.models.Player
import compose.project.jobappclicker.models.upgrades.AutoClickerUpgrades
import compose.project.jobappclicker.models.upgrades.ClickerUpgrades
import compose.project.jobappclicker.models.upgrades.Upgrade
import compose.project.jobappclicker.storage.GameSave
import compose.project.jobappclicker.storage.SavedUpgrade


class PlayerController(private val player: Player) {
    fun click() {
        player.lifetimeScore += player.clickRate
        player.score += player.clickRate
    }
    fun upgradeUpgrade(upgrade: Upgrade) {
        upgrade.numberPurchased++
    }
    fun getScore(): Int {
        return player.score
    }
    fun getUpgradeList(): List<Upgrade> {
        return player.upgrades
    }
    fun createSave(): GameSave {
        return GameSave(
            score = player.score,
            lifetimeScore = player.lifetimeScore,
            upgrades = player.upgrades.map { upgrade ->
                SavedUpgrade(
                    upgradeId = upgrade.name,
                    quantityPurchased = upgrade.numberPurchased
                )
            }
        )
    }
    fun restoreSave(save: GameSave) {
        player.score = save.score
        player.lifetimeScore = save.lifetimeScore

        player.upgrades.forEach { upgrade ->
            val savedUpgrade = save.upgrades.find{
                it.upgradeId == upgrade.name
            }
            upgrade.numberPurchased = savedUpgrade?.quantityPurchased ?:0
        }
        //starting strength + bonuses from purchased click upgrades
        player.clickRate = 1 + player.upgrades
            .filterIsInstance<ClickerUpgrades>()
            .sumOf { it.totalClickIncrease() }

        //calculates how many applications the player earns automatically each second
        player.autoClickPerSecond = player.upgrades
            .filterIsInstance<AutoClickerUpgrades>()
            .sumOf { it.totalAutoClickIncrease() }
    }
    fun earnApplications(amount: Int){
        player.score += amount
        player.lifetimeScore += amount
    }
    fun spendApplications(amount: Int): Boolean{
        if (player.score < amount) return false

        player.score -= amount
        return true
    }
}