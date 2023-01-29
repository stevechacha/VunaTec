package com.dev.chacha.vunatec.feature_my_farm.predict_harvest_date

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dev.chacha.vunatec.R
import com.dev.chacha.vunatec.core.presentation.components.VunaToolbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PredictedHarvestDateScreen() {
    Scaffold(
        topBar = {
            VunaToolbar(
                title = stringResource(id = R.string.crop_health),
                showBackArrow = true,
                showMenuBar = true
            ) {

            }

        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_plus),
                contentDescription = null
            )

            Text(
                text = stringResource(id = R.string.predicted_harvest_date)
            )

            Text(
                text = stringResource(id = R.string.instructions_one)
            )

            Button(onClick = { /*TODO*/ }) {
                Text(text = stringResource(id = R.string.add_calender))
            }


        }

    }
}