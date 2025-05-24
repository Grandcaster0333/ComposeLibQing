package com.qinglian.composelib.preference.container

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.qinglian.composelib.preference.components.PreferenceSwitch
import com.qinglian.composelib.preference.data.PreferenceItem
import com.qinglian.composelib.preference.data.RenderPreferenceItem
import com.qinglian.composelib.resources.Dimens
import com.qinglian.composelib.ui.theme.ComposeLibQingTheme


/**
 * A page container for all preferences
 */
@Composable
fun PreferencePage(modifier: Modifier = Modifier,
                   content: List<PreferenceItem>
) {
    var mShouldSetDarkMode by remember { mutableStateOf(false) }

    ComposeLibQingTheme (darkTheme = mShouldSetDarkMode) {
        Surface(
            modifier = Modifier.fillMaxSize().padding(WindowInsets.statusBars.asPaddingValues()),
            color = MaterialTheme.colorScheme.background,
        ) {
            Column(modifier = modifier.padding(Dimens.Padding.small)) {
                PreferenceSwitch(
                    content = "Enable dark mode",
                    isChecked = mShouldSetDarkMode,
                    onChange = { mShouldSetDarkMode = it },
                )
                content.forEach { RenderPreferenceItem(it) }
            }
        }
    }
}