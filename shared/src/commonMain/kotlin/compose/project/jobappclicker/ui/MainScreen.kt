package compose.project.jobappclicker.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
import compose.project.jobappclicker.audioManager.SoundEffectsManager
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
    var count by remember(controller) {
        mutableStateOf(controller.getScore())
    }

    val soundEffects = remember {SoundEffectsManager()}

    val upgrades = remember(controller) {
        controller.getUpgradeList()
    }

    val clickUpgrades = remember(upgrades) {
        upgrades.filterIsInstance<ClickerUpgrades>()
    }

    val autoClickerUpgrades = remember(upgrades) {
        upgrades.filterIsInstance<AutoClickerUpgrades>()
    }

    val clickAmount = 1 + clickUpgrades.sumOf {
        it.totalClickIncrease()
    }

    val autoClickRate = autoClickerUpgrades.sumOf {
        it.totalAutoClickIncrease()
    }

    var showSettings by remember { mutableStateOf(false) }

    var showStats by remember { mutableStateOf(false) }

    LaunchedEffect(autoClickRate) {
        while (autoClickRate > 0) {
            delay(1000L)
            controller.earnApplications(autoClickRate)
            count = controller.getScore()
        }
    }

    val clickApplicationWord =
        if (clickAmount == 1) "application" else "applications"
    val applicationWord =
        if (autoClickRate == 1) "application" else "applications"

    val clickUpgradeScrollState = rememberScrollState()
    val autoClickerScrollState = rememberScrollState()

    Box(modifier = Modifier.fillMaxSize()) {
        Row (
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Column(
                modifier = Modifier.weight(1f)
                    .background(Grey)
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box (
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(bottom = 20.dp)
                    ) {
                        Text(
                            text = "Applications Sent: ${controller.getScore()}",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp,
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
                                    controller.earnApplications(clickAmount)
                                    count = controller.getScore()
                                    soundEffects.playClickSound()
                                }
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .padding(bottom = 20.dp, start = 20.dp, end = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(25.dp),
                    verticalAlignment = Alignment.Bottom,

                    ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(50.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .border(color = Black, width = 2.dp, shape = RoundedCornerShape(16.dp))
                            .clickable{
                                showStats = true
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Statsview",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                        )
                    }

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(50.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .border(color = Black, width = 2.dp, shape = RoundedCornerShape(16.dp))
                            .clickable{
                                showSettings = true
                                count = controller.getScore()
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Settings",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                        )
                    }
                }
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {
                Text(
                    text = "Click Upgrades",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(end = 12.dp)
                            .verticalScroll(clickUpgradeScrollState)
                    ) {
                        clickUpgrades.forEach { upgrade ->
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                                    .border(1.dp, Black, RoundedCornerShape(8.dp))
                                    .padding(12.dp),
                                verticalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Text(upgrade.name, fontWeight = FontWeight.Bold)
                                Text("+${upgrade.clickIncrease} applications per click")
                                Text("Owned: ${upgrade.numberPurchased}")
                                Text("Cost: ${upgrade.currentCost}")

                                Button(
                                    enabled = count >= upgrade.currentCost,
                                    onClick = {
                                        val cost = upgrade.currentCost
                                        if(controller.spendApplications(cost)){
                                            upgrade.purchase()
                                            count = controller.getScore()
                                            soundEffects.playPurchaseSound()
                                        }
                                    }

                                ) {
                                    Text("Buy")
                                }
                            }
                        }
                    }

                    VerticalScrollbar(
                        adapter = rememberScrollbarAdapter(clickUpgradeScrollState),
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .fillMaxHeight()
                    )
                }
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {
                Text(
                    text = "Autoclicker Upgrades",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(end = 12.dp)
                            .verticalScroll(autoClickerScrollState)
                    ) {
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
                                        if (controller.spendApplications(cost)){
                                            upgrade.purchase()
                                            count = controller.getScore()
                                        }
                                    }
                                ) {
                                    Text("Buy")
                                }
                            }
                        }
                    }

                    VerticalScrollbar(
                        adapter = rememberScrollbarAdapter(autoClickerScrollState),
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .fillMaxHeight()
                    )
                }
            }
        }
        if(showStats){
            StatsViewer(
                score = controller.getScore(),
                lifetimeScore = controller.getLifetimeScore(),
                onClose = {showStats = false}
            )
        }

        if(showSettings) {
            SettingsView(onClose = {showSettings = false}, controller,)
        }
    }

}