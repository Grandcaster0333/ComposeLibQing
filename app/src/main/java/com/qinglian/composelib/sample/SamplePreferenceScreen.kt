package com.qinglian.composelib.sample

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.qinglian.composelib.preference.container.PreferencePage
import com.qinglian.composelib.preference.data.PreferencePageViewModel

/**
 * A sample screen to illustrate how to use the preference lib.
 * Sample data a pre-written to VM.
 */
@Composable
fun SamplePreferenceScreen(viewModel: PreferencePageViewModel) {
    val preferenceItems by viewModel.uiState.collectAsState()

    PreferencePage(content = preferenceItems)
}