package compose.project.jobappclicker.models.upgrades

sealed class Upgrade (
    open val name: String,
    open var cost: Int,
    open var numberPurchased: Int,
    open var initCost: Int,
){
    fun resetUpgrade() {
        numberPurchased = 0
        cost = initCost
    }

}