package compose.project.jobappclicker
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
    val name: String,
    var numberPurchased: Int = 0,
    val clickIncrease: Int,
    val secondaryCostFactor: Int,
    val initCost: Int
) {
    val currentCost: Int
        get() = secondaryCostFactor * numberPurchased + initCost

    fun purchase() {
        numberPurchased++
    }

    fun totalClickIncrease(): Int {
        return numberPurchased * clickIncrease
    }
}