package compose.project.jobappclicker.models.upgrades

/*
Set with
val example = ClickerUpgrades(
    name = "example",
    numberPurchased = 0,
    clickIncrease = X,
    initCost = Y,
    secondaryCostFactor = Z
)
 */
class ClickerUpgrades(
    override val name: String,
    override var numberPurchased: Int = 0,
    val clickIncrease: Int,
    val secondaryCostFactor: Int,
    val initCost: Int
) : Upgrade(name, initCost, numberPurchased){
    val currentCost: Int
        get() = secondaryCostFactor * numberPurchased + initCost

    fun purchase() {
        numberPurchased++
    }

    fun totalClickIncrease(): Int {
        return numberPurchased * clickIncrease
    }
}