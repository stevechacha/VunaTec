package com.dev.chacha.vunatec.feature_payments.presentation.fragments

import android.os.Build
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.dev.chacha.vunatec.R
import com.dev.chacha.vunatec.core.presentation.common.theme.VunaTecTheme
import com.dev.chacha.vunatec.feature_calender.presentation.fragments.ProfileScreen
import com.maxkeppeker.sheets.core.models.base.rememberSheetState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import java.time.LocalDate

class PaymentsFragment : Fragment() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                VunaTecTheme {
                    PaymentsScreen()
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentsScreen() {
    val calenderState = rememberSheetState()
    CalendarDialog(
        state = calenderState,
        config =  CalendarConfig(
            monthSelection = true,
            yearSelection = true,
            disabledDates = listOf(LocalDate.now())
        ),
        selection = CalendarSelection.Date{ date ->
            Log.d("SelectedDate","$date")

        }
    )

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            calenderState.show()
        }) {
            Text(text = "Date Picker")
        }
    }

}
