package compose.project.jobappclicker.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.tooling.ComposeToolingApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import compose.project.jobappclicker.controllers.PlayerController

@Composable
fun StatsViewer(controller: PlayerController) {
    var count by remember { mutableStateOf(0) }

    Row (
        modifier = Modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ){
        Column (
            modifier = Modifier
        ) {
            Text(
                text = "this is column 1"
            )
        }
        Column (
            modifier = Modifier
        ){
            Text(
                text = "this is column 2",
            )
        }
    }
}