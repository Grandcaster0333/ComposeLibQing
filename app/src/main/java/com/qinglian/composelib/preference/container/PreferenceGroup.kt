package com.qinglian.composelib.preference.container

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.qinglian.composelib.preference.components.PreferenceDivider
import com.qinglian.composelib.preference.components.PreferenceSwitch
import com.qinglian.composelib.preference.components.PreferenceText

/**
 * Container for a group of settings.
 *
 * @param modifier hopefully you understand this if you are using this library
 * @param withDivider if divider should be shown at the end of the section
 * @param title section title, disabled by default
 * @param description description of the section, disabled by default. This only shows when section
 *        title exists. You don't want it to get TOO complicated too, right?
 * @param content ...FREEEEEEEEE
 */
@Composable
fun PreferenceGroup(modifier: Modifier = Modifier, withDivider: Boolean = false,
                    title: String? = null, description: String? = null,
                    content: @Composable ColumnScope.() -> Unit
) {
    Column(modifier = modifier) {
        if (title != null) {
            PreferenceText(title = title, content = description)
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