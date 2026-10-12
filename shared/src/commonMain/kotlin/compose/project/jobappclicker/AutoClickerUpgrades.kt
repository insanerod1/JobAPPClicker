package compose.project.jobappclicker
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
val name: String,
var numberPurchased: Int = 0,
val autoClickIncrease: Int,
val initCost: Int,
val secondaryCostFactor: Int
) {
    val currentCost: Int
    get() = secondaryCostFactor * numberPurchased + initCost

    fun purchase() {
        numberPurchased++
    }

    fun totalAutoClickIncrease(): Int {
        return numberPurchased * autoClickIncrease
    }
}

