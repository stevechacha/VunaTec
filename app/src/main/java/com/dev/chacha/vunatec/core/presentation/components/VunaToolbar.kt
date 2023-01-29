package com.dev.chacha.vunatec.core.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import com.dev.chacha.vunatec.R

@Composable
fun VunaToolbar(
    title: String,
    modifier: Modifier = Modifier,
    showBackArrow: Boolean = false,
    showMenuBar: Boolean = false,
    onClickAction: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

        },
        navigationIcon = {
            if (showBackArrow) {
                IconButton(onClick = { /*TODO*/ }) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_plus),
                        contentDescription = null
                    )
                }
            }
        },

        actions = {
            if (showMenuBar) {
                IconButton(onClick = { onClickAction()}) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_plus),
                        contentDescription = null
                    )
                }
            }
        }
    )

}