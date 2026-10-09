package compose.project.jobappclicker

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform