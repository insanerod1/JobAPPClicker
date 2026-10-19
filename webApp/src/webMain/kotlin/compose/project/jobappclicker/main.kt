package compose.project.jobappclicker

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import compose.project.jobappclicker.storage.BrowserGameStorage
import compose.project.jobappclicker.storage.GameSave

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    val storage = BrowserGameStorage()

    ComposeViewport {
        App()
    }
}