package compose.project.jobappclicker.models

sealed class Upgrade (
    open val name: String,
    open val cost: Int,
    open val level: Int
)