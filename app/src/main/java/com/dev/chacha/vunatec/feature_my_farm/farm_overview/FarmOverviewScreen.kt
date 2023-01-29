package com.dev.chacha.vunatec.feature_my_farm.farm_overview

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.chacha.vunatec.R
import com.dev.chacha.vunatec.core.presentation.common.theme.VunaTecTheme
import com.dev.chacha.vunatec.core.presentation.components.VunaToolbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FarmOverviewScreen() {
    Scaffold(topBar = {
        VunaToolbar(
            title = stringResource(id = R.string.farm_overview),

        ) {

        }
    }) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = stringResource(id = R.string.new_farm),
                    textAlign = TextAlign.Center
                )
            }
        }

    }

}


@Composable
@Preview(showBackground = true)
fun FarmOverviewPreview() {
    VunaTecTheme {
        FarmOverviewScreen()
    }
}