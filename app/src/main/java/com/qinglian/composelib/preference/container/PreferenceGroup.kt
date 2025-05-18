package com.qinglian.composelib.preference.container

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.qinglian.composelib.preference.PreferenceDivider
import com.qinglian.composelib.preference.PreferenceSectionHeader
import com.qinglian.composelib.preference.PreferenceSwitch

@Composable
fun PreferenceGroup(
    modifier: Modifier = Modifier,
    withDivider: Boolean = false,
    title: String? = null,
    description: String? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(modifier = modifier) {
        if (title != null) {
            PreferenceSectionHeader(title, description)
        }
        content()
        if (withDivider) {
            PreferenceDivider(modifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPreferenceGroup() {
    var mIsFoodChecked = true;
    var mIsRestChecked = true;
    PreferenceGroup (title = "Health check", withDivider = true) {
        PreferenceSwitch(
            title = null,
            content = "Force Sanders to eat today",
            isChecked = mIsFoodChecked,
            onChange = { mIsFoodChecked = it },
        )
        PreferenceSwitch(
            title = null,
            content = "Force Sanders to rest today",
            isChecked = mIsRestChecked,
            onChange = { mIsRestChecked = it },
        )
    }
}