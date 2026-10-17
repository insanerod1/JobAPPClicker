package compose.project.jobappclicker.models.upgrades

object UpgradeCatalog {
    fun createDefaultUpgrade(): MutableList<Upgrade> {
        return mutableListOf(
            ClickerUpgrades(
                name = "Better Applications",
                clickIncrease = 2,
                initCost = 10,
                secondaryCostFactor = 5
            ),
            ClickerUpgrades(
                name = "Resume Improvements",
                clickIncrease = 5,
                initCost = 50,
                secondaryCostFactor = 10
            ),
            ClickerUpgrades(
                name = "Extra Pens",
                clickIncrease = 10,
                initCost = 500,
                secondaryCostFactor = 100
            ),
            ClickerUpgrades(
                name = "Keyboard Macro",
                clickIncrease = 25,
                initCost = 2500,
                secondaryCostFactor = 500
            ),
            ClickerUpgrades(
                name = "Resume Printing Press",
                clickIncrease = 50,
                initCost = 10000,
                secondaryCostFactor = 2000
            ),
            ClickerUpgrades(
                name = "Intern With Six Monitors",
                clickIncrease = 100,
                initCost = 50000,
                secondaryCostFactor = 10000
            ),
            ClickerUpgrades(
                name = "Cover Letter Cloning Chamber",
                clickIncrease = 250,
                initCost = 250000,
                secondaryCostFactor = 50000
            ),
            ClickerUpgrades(
                name = "Quantum ATS Whisperer",
                clickIncrease = 500,
                initCost = 1250000,
                secondaryCostFactor = 250000
            ),
            ClickerUpgrades(
                name = "Multiverse Applicant Array",
                clickIncrease = 1000,
                initCost = 10000000,
                secondaryCostFactor = 2000000
            ),
            ClickerUpgrades(
                name = "Infinite Submit Button",
                clickIncrease = 5000,
                initCost = 100000000,
                secondaryCostFactor = 20000000
            ),

            AutoClickerUpgrades(
                name = "Auto-Apply Script",
                autoClickIncrease = 1,
                initCost = 100,
                secondaryCostFactor = 50
            ),
            AutoClickerUpgrades(
                name = "Resume Submission Bot",
                autoClickIncrease = 5,
                initCost = 500,
                secondaryCostFactor = 250
            ),
            AutoClickerUpgrades(
                name = "Application Farm",
                autoClickIncrease = 20,
                initCost = 2500,
                secondaryCostFactor = 1250
            ),
            AutoClickerUpgrades(
                name = "Polite Robot Fleet",
                autoClickIncrease = 50,
                initCost = 10000,
                secondaryCostFactor = 2500
            ),
            AutoClickerUpgrades(
                name = "Self-Refilling Resume Printer",
                autoClickIncrease = 100,
                initCost = 50000,
                secondaryCostFactor = 10000
            ),
            AutoClickerUpgrades(
                name = "Application Drone Swarm",
                autoClickIncrease = 250,
                initCost = 250000,
                secondaryCostFactor = 50000
            ),
            AutoClickerUpgrades(
                name = "Self-Replicating Cover Letters",
                autoClickIncrease = 500,
                initCost = 1250000,
                secondaryCostFactor = 250000
            ),
            AutoClickerUpgrades(
                name = "Quantum Job Board Harvester",
                autoClickIncrease = 1000,
                initCost = 10000000,
                secondaryCostFactor = 2000000
            ),
            AutoClickerUpgrades(
                name = "Parallel-Universe Applicant Clone",
                autoClickIncrease = 5000,
                initCost = 100000000,
                secondaryCostFactor = 20000000
            ),
            AutoClickerUpgrades(
                name = "Time-Traveling Sentient Submit Button",
                autoClickIncrease = 25000,
                initCost = 1000000000,
                secondaryCostFactor = 200000000
            )
        )
    }
}