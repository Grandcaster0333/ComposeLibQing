package com.qinglian.composelib.preference.container

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.qinglian.composelib.preference.PreferenceSwitch
import com.qinglian.composelib.preference.PreferenceText
import com.qinglian.composelib.resources.Dimens


/**
 * A page container for all preferences
 */
@Composable
fun PreferencePage(modifier: Modifier = Modifier, content: @Composable ColumnScope.() -> Unit) {
    Column(modifier = modifier.padding(Dimens.Padding.small)) {
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPreferencePage() {
    var mIsFoodChecked = true;
    var mIsRestChecked = true;
    var mIsHappyChecked = true;
    PreferencePage {
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

        PreferenceGroup (title = "Mood check", withDivider = true) {
            PreferenceSwitch(
                title = null,
                content = "Is Sanders happy today",
                isChecked = mIsHappyChecked,
                onChange = { mIsHappyChecked = it },
            )
        }

        PreferenceGroup {
            PreferenceText (
                content = "Try get closer.",
                onClick = { }
            )
        }
    }
}