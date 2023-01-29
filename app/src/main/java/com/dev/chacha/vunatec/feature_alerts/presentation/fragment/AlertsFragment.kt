package com.dev.chacha.vunatec.feature_alerts.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.chacha.vunatec.core.presentation.common.theme.VunaTecTheme
import com.dev.chacha.vunatec.feature_alerts.domain.model.alerts
import com.dev.chacha.vunatec.feature_alerts.presentation.component.AlertsItem

class AlertsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                VunaTecTheme {
                    AlertScreen(
                        onClickAction = {}
                    )
                }
            }
        }
    }
}

@Composable
fun AlertScreen(
    onClickAction: () -> Unit
) {
    AlertsContent(onClickAction = onClickAction)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertsContent(
    onClickAction: () -> Unit
) {
    Scaffold(
        topBar = {

        }) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            LazyColumn(
                contentPadding = PaddingValues(bottom = 8.dp)
            ) {
                items(alerts){ alerts ->
                    AlertsItem(
                        alerts = alerts,
                        onClickAction = onClickAction
                    )
                }

            }

        }
    }
}

@Preview
@Composable
fun AlertScreenPreview() {
    VunaTecTheme {
        AlertScreen {

        }
    }
}
