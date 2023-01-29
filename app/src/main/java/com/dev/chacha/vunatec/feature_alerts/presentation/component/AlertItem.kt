package com.dev.chacha.vunatec.feature_alerts.presentation.component

import android.service.autofill.OnClickAction
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dev.chacha.vunatec.R
import com.dev.chacha.vunatec.feature_alerts.domain.model.Alerts

@Composable
fun AlertsItem(
    alerts: Alerts,
    onClickAction: () -> Unit
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(60.dp)
        .background(Color.Gray)

    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            AsyncImage(
                model = alerts.icon,
                contentDescription = null
            )
            Column(
                modifier = Modifier.padding(start = 10.dp, end = 0.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = alerts.alertTypTitle
                )
                Row(horizontalArrangement = Arrangement.SpaceBetween){
                    Image(painter = painterResource(id = R.drawable.ic_plus),
                        contentDescription = null)
                    Image(painter = painterResource(id = R.drawable.ic_plus),
                        contentDescription = null)
                    Text(text = alerts.alertTypeSubtitle)
                    Text(text = alerts.durationAlerts)
                }

            }

        }

    }

}