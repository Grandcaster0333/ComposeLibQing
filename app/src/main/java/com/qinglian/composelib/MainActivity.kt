package com.qinglian.composelib

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.qinglian.composelib.preference.data.PreferencePageViewModel
import com.qinglian.composelib.sample.SamplePreferenceScreen

/**
 * Main activity.
 *
 * Surprise! YOU REALLY ONLY NEED THIS ONE ACTIVITY!
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel = viewModel<PreferencePageViewModel>()
            LaunchedEffect(Unit) {
                viewModel.loadSampleData()
            }

            SamplePreferenceScreen(viewModel = viewModel)
        }
    }
}