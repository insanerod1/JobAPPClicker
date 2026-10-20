package compose.project.jobappclicker.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.project.jobappclicker.audioManager.AudioSettings
import compose.project.jobappclicker.controllers.PlayerController
import compose.project.jobappclicker.ui.colors.Black
import jobappclicker.shared.generated.resources.*
import org.jetbrains.compose.resources.painterResource

@Composable
fun SettingsView(onClose: () -> Unit, controller: PlayerController) {
    val soundEnabled = AudioSettings.soundEnabled
    val musicEnabled = AudioSettings.musicEnabled
    var showDeleteConfirmation by remember { mutableStateOf(false) }

    val backdropInteractions = remember { MutableInteractionSource() }
    val panelInteractions = remember { MutableInteractionSource() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.55f))
            .clickable(
                interactionSource = backdropInteractions,
                indication = null,
                onClick = onClose
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .widthIn(max = 420.dp)
                .fillMaxWidth(0.9f)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)
                .border(2.dp, Black, RoundedCornerShape(16.dp))
                .clickable(
                    interactionSource = panelInteractions,
                    indication = null,
                    onClick = {}
                )
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Settings",
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(
                            if (soundEnabled) {
                                Res.drawable.SoundOn
                            } else {
                                Res.drawable.SoundOff
                            }
                        ),
                        contentDescription = if (soundEnabled) {
                            "Turn sound off"
                        } else {
                            "Turn sound on"
                        },
                        colorFilter = ColorFilter.tint(Color(0xFF333333)),
                        modifier = Modifier
                            .size(48.dp)
                            .clickable {
                                AudioSettings.soundEnabled =
                                    !AudioSettings.soundEnabled
                            }
                    )
                    Text("Sound")
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(
                            if (musicEnabled) {
                                Res.drawable.MusicOn
                            } else {
                                Res.drawable.MusicOff
                            }
                        ),
                        contentDescription = if (musicEnabled) {
                            "Turn music off"
                        } else {
                            "Turn music on"
                        },
                        colorFilter = ColorFilter.tint(Color(0xFF333333)),
                        modifier = Modifier
                            .size(48.dp)
                            .clickable {
                                AudioSettings.musicEnabled =
                                    !AudioSettings.musicEnabled
                            }
                    )
                    Text("Music")
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(Res.drawable.Delete),
                        contentDescription = "Delete user data",
                        colorFilter = ColorFilter.tint(Color(0xFF333333)),
                        modifier = Modifier
                            .size(48.dp)
                            .clickable {
                                showDeleteConfirmation = true
                            }
                    )
                    Text("Reset")
                }
            }

            Button(onClick = onClose) {
                Text("Close")
            }
        }
    }

    if (showDeleteConfirmation) {
        AlertDialog(
            onDismissRequest = { showDeleteConfirmation = false },
            title = { Text("Delete user data") },
            text = { Text("Are you sure?") },
            confirmButton = {
                TextButton(onClick = {
                    controller.reset()
                    showDeleteConfirmation = false

                }) {
                    Text("Yes")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDeleteConfirmation = false }) {
                    Text("No")
                }
            }
        )
    }
}