package compose.project.jobappclicker.models.upgrades

/*
Set with
val example = AutoClickerUpgrades(
    name = "example",
    numberPurchased = 0,
    autoClickIncrease = X,
    initCost = Y,
    secondaryCostFactor = Z
)
 */
class AutoClickerUpgrades(
override val name: String,
override var numberPurchased: Int = 0,
val autoClickIncrease: Int,
val initCost: Int,
val secondaryCostFactor: Int
) : Upgrade(name, initCost, numberPurchased) {
    val currentCost: Int
    get() = secondaryCostFactor * numberPurchased + initCost

    fun purchase() {
        numberPurchased++
    }

    fun totalAutoClickIncrease(): Int {
        return numberPurchased * autoClickIncrease
    }
}