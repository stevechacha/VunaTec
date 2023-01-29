package com.dev.chacha.vunatec.feature_my_farm.presentation.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.dev.chacha.vunatec.R
import com.dev.chacha.vunatec.core.presentation.common.theme.VunaTecTheme
import com.dev.chacha.vunatec.feature_calender.presentation.fragments.ProfileScreen

class MyFarmFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                VunaTecTheme {
                    ProfileScreen()
                }
            }
        }
    }


}