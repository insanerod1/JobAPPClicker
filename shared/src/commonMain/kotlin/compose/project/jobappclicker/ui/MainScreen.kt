package compose.project.jobappclicker.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.project.jobappclicker.controllers.PlayerController
import compose.project.jobappclicker.models.upgrades.AutoClickerUpgrades
import compose.project.jobappclicker.models.upgrades.ClickerUpgrades
import compose.project.jobappclicker.ui.colors.Black
import compose.project.jobappclicker.ui.colors.Grey
import jobappclicker.shared.generated.resources.Application
import jobappclicker.shared.generated.resources.Res
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource

@Composable
fun MainScreen(controller: PlayerController) {
    var count by remember { mutableStateOf(0) }


    val upgrades = remember {
        listOf(
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
                name = "One-Thousand Pencils",
                clickIncrease = 10,
                initCost = 500,
                secondaryCostFactor = 100
            )
        )
    }

    val autoClickerUpgrades = remember {
        listOf(
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
            )
        )
    }



    val clickAmount = 1 + upgrades.sumOf {
        it.totalClickIncrease()
    }

    val autoClickRate = autoClickerUpgrades.sumOf {
        it.totalAutoClickIncrease()
    }

    LaunchedEffect(autoClickRate) {
        while (autoClickRate > 0) {
            delay(1000L)
            count += autoClickRate
        }
    }

    val clickApplicationWord =
        if (clickAmount == 1) "application" else "applications"
    val applicationWord =
        if (autoClickRate == 1) "application" else "applications"

    Row (
        modifier = Modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Column (
            modifier = Modifier
                .weight(1f)
                .background(Grey)
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Count: $count",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Text(
                text = "$clickAmount $clickApplicationWord per click",
                color = Color.White,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )

            Text(
                text = "$autoClickRate $applicationWord per second",
                color = Color.White,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 10.dp)
            )

            Image(
                painter = painterResource(Res.drawable.Application),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(400.dp)
                    .aspectRatio(0.75f)
                    .clip(RoundedCornerShape(16.dp))
                    .border(
                        width = 2.dp,
                        color = Black,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .clickable {
                        count += clickAmount

                    }
            )
        }
        Column (
            modifier = Modifier.weight(1f),
        ){
            Text(
                text = "Click Upgrade",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
            )
            upgrades.forEach { upgrade ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .border(1.dp, Black, RoundedCornerShape(8.dp))
                        .padding(12.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ){
                    Text(upgrade.name, fontWeight = FontWeight.Bold)
                    Text("+${upgrade.clickIncrease} applications per click")
                    Text("Owned: ${upgrade.numberPurchased}")
                    Text("Cost: ${upgrade.currentCost}")

                    Button(
                        enabled = count >= upgrade.currentCost,
                        onClick = {
                            if (count>= upgrade.currentCost) {
                                count-= upgrade.currentCost
                                upgrade.purchase()
                            }
                        }
                    ){
                        Text("Buy")
                    }

                }

            }
        }
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "Autoclicker Upgrades",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )


            autoClickerUpgrades.forEach { upgrade ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .border(1.dp, Black, RoundedCornerShape(8.dp))
                        .padding(12.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(upgrade.name, fontWeight = FontWeight.Bold)
                    Text("+${upgrade.autoClickIncrease} applications per second")
                    Text("Owned: ${upgrade.numberPurchased}")
                    Text("Cost: ${upgrade.currentCost}")

                    Button(
                        enabled = count >= upgrade.currentCost,
                        onClick = {
                            val cost = upgrade.currentCost
                            if (count >= cost) {
                                count -= cost
                                upgrade.purchase()
                            }
                        }
                    ) {
                        Text("Buy")
                    }
                }
            }
        }
    }

}