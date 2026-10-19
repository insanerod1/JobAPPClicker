package compose.project.jobappclicker.models.upgrades

sealed class Upgrade (
    open val name: String,
    open val cost: Int,
    open var numberPurchased: Int
){

}