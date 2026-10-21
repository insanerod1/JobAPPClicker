package compose.project.jobappclicker

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import compose.project.jobappclicker.audioManager.BackgroundMusic
import compose.project.jobappclicker.controllers.PlayerController
import compose.project.jobappclicker.models.Player
import compose.project.jobappclicker.storage.GameStorage
import compose.project.jobappclicker.ui.MainScreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive

//? means it can be null
@Composable
fun App(storage: GameStorage? = null) {
    val controller = remember(storage) {
        val player = Player()
        val controller = PlayerController(player)

        storage?.load()?.let { save ->
            controller.restoreSave(save)
        }
        controller
    }

    LaunchedEffect(storage, controller){
        val gameStorage = storage?: return@LaunchedEffect

        while (isActive) {
            delay(5000) //wait 5 seconds, code saves and then repeats the loop
            gameStorage.save(controller.createSave())
        }
    }

    BackgroundMusic()
    MainScreen(controller)
    /*
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }
    }
    */
}