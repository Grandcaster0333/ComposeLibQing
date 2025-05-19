package com.qinglian.composelib.preference.container

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.qinglian.composelib.preference.components.PreferenceSwitch
import com.qinglian.composelib.preference.components.PreferenceText
import com.qinglian.composelib.resources.Dimens
import com.qinglian.composelib.ui.theme.ComposeLibQingTheme


/**
 * A page container for all preferences
 */
@Composable
fun PreferencePage(modifier: Modifier = Modifier, content: @Composable ColumnScope.() -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier = modifier.padding(Dimens.Padding.small)) {
            content()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPreferencePage() {
    var mIsFoodChecked = true;
    var mIsRestChecked = false;
    var mIsHappyChecked = true;
    ComposeLibQingTheme (darkTheme = true) {
        PreferencePage {
            PreferenceGroup(title = "Health check", withDivider = true) {
                PreferenceSwitch(
                    content = "Force Sanders to eat today",
                    isChecked = mIsFoodChecked,
                    onChange = { mIsFoodChecked = it },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Done,
                            contentDescription = null
                        )
                    }
                )
                PreferenceSwitch(
                    content = "Force Sanders to rest today",
                    isChecked = mIsRestChecked,
                    onChange = { mIsRestChecked = it },
                )
            }

            PreferenceGroup(title = "Mood check", withDivider = true) {
                PreferenceSwitch(
                    content = "Is Sanders happy today",
                    isChecked = mIsHappyChecked,
                    onChange = { mIsHappyChecked = it },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = null
                        )
                    }
                )
            }

            PreferenceGroup {
                PreferenceText(
                    title = "Try harder. And don't forget who is watching. You shouldn't let go.",
                    onClick = { },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = null
                        )
                    },
                    content = "And I like the weather today",
                )
            }
        }
    }
}