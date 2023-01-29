package com.dev.chacha.vunatec.feature_send_data.send_data

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.dev.chacha.vunatec.R
import com.dev.chacha.vunatec.core.utils.observeEvent
import com.dev.chacha.vunatec.databinding.DetectionFragmentBinding

class DetectionFragment : Fragment(R.layout.detection_fragment) {

    private var _binding: DetectionFragmentBinding? = null

    private val detectionFragmentBinding
        get() = _binding!!

    private val viewModel: DetectionViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =  DetectionFragmentBinding.inflate(inflater, container, false)

        return detectionFragmentBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpObservers()
        navigateToDetection()

    }

    private fun navigateToDetection() {
        detectionFragmentBinding.toLive.setOnClickListener {
            viewModel.navigateToDetection()


        }
    }

    private fun setUpObservers() {
        viewModel.uiState.observe(viewLifecycleOwner) {
            when (it) {
                DetectionsUIState.Loading -> {
                    //renderLoading()
                }
                is DetectionsUIState.Error -> {
                    //renderError()
                }
                is DetectionsUIState.Message -> {
                }
                else -> {}
            }
        }
        viewModel.interactions.observeEvent(viewLifecycleOwner) {
            when (it) {
                is DetectionsActions.Navigate -> findNavController().navigate(it.destination)
            }
        }
    }

}