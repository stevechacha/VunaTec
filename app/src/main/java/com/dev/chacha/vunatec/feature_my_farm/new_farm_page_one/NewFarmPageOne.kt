package com.dev.chacha.vunatec.feature_my_farm.new_farm_page_one

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dev.chacha.vunatec.core.presentation.common.theme.VunaTecTheme
import com.dev.chacha.vunatec.core.presentation.components.VunaToolbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewFarmPageOne() {
    Scaffold(
        topBar = {
        VunaToolbar(
            title = "New Farm",
            showMenuBar = true,
            showBackArrow = true
        ) {

        }
    }) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {

        }

    }

}

@Composable
@Preview(showBackground = true)
fun NewFarmPageOnePreview() {
    VunaTecTheme {
        NewFarmPageOne()
    }
}