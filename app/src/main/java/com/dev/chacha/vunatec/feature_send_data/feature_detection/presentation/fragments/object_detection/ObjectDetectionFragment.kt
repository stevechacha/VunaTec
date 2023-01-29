package com.dev.chacha.vunatec.feature_send_data.feature_detection.presentation.fragments.object_detection

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dev.chacha.vunatec.R

class ObjectDetectionFragment : Fragment() {

    companion object {
        fun newInstance() = ObjectDetectionFragment()
    }

    private lateinit var viewModel: ObjectDetectionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.object_detection_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ObjectDetectionViewModel::class.java)
        // TODO: Use the ViewModel
    }

}