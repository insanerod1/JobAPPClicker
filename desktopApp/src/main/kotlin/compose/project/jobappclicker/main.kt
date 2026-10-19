package compose.project.jobappclicker

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import compose.project.jobappclicker.storage.DesktopGameStorage

fun main() {
    val storage = DesktopGameStorage()

    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "JobAPPClicker",
        )
        {
            App(storage)
        }
    }
}