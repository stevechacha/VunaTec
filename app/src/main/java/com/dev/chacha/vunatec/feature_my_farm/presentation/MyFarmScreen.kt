package com.dev.chacha.vunatec.feature_my_farm.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.chacha.vunatec.R
import com.dev.chacha.vunatec.core.presentation.components.VunaToolbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun MyFarmScreen() {
    val amountSunny = 100
    val typeOfWeather = "Sunny,$amountSunny"
    Scaffold(
        topBar = {
            VunaToolbar(
                title = "Farm Overview",
                showMenuBar = true
            ) {
                
            }
        }) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize(),
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_plus),
                    contentDescription = null,
                    modifier = Modifier.size(100.dp)
                )
                Column(
                ) {
                    Text(text = "Weather: $typeOfWeather ")
                    Text(text = "Harvest: $typeOfWeather ")
                    Text(text = "Est.yield: $typeOfWeather ")
                    Text(text = "Fertilized: $typeOfWeather ")
                    Text(text = "Healthy: $typeOfWeather ")
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.crop_health)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.crop_health)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.crop_health)
                )

            }

        }

    }
}