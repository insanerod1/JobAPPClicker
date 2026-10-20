 package compose.project.jobappclicker.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.project.jobappclicker.ui.colors.Black

 @Composable
fun StatsViewer(
    score: Int,
    lifetimeScore: Int,
    onClose: () -> Unit
) {

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
    ){
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
                text = "Stats",
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp
            )
            Text("Current applications: $score")
            Text("Lifetime applications earned: $lifetimeScore")
            Text("Job offers: 0")

            Button(onClick = onClose) {
                Text("Back")
            }
        }
    }
}
