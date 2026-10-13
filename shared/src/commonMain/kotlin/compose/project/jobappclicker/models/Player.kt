package compose.project.jobappclicker.models

import compose.project.jobappclicker.models.upgrades.Upgrade

class Player (
    var score: Int = 0,
    var clickRate: Int = 1,
    var autoClickPerSecond: Int = 0,
    val upgrades: MutableList<Upgrade>
) {

}

