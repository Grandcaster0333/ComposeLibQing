package com.qinglian.composelib.preference

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.qinglian.composelib.resources.Dimens
import com.qinglian.composelib.ui.theme.ComposeLibQingTheme

/**
 * Switch preference
 *
 * @param title: title of the preference. When set to null, hide title and only show content line
 * @param content: description of the preference
 * @param isChecked: default value of whether the switch is checked or not
 * @param onChange: callback for switch status change
 * @param modifier: ...hopefully this is self-explanatory
 */
@Composable
fun PreferenceSwitch(title: String?, content: String, isChecked: Boolean,
                     onChange: ((Boolean) -> Unit)?, modifier: Modifier = Modifier) {
    Column {
        if (title != null) {
            Text(
                text = title,
                modifier = modifier.padding(Dimens.Padding.small)
            )
        }
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier.fillMaxWidth()
        ) {
            Text(
                text = content,
                modifier = modifier.padding(Dimens.Padding.small)
            )
            Switch(
                checked = isChecked,
                onCheckedChange = onChange,
                modifier = modifier.padding(Dimens.Padding.small)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPreferenceSwitch() {
    var mIsChecked = true;
    ComposeLibQingTheme {
        PreferenceSwitch(
            title = "Health check",
            content = "Force Sanders to eat today",
            isChecked = mIsChecked,
            onChange = { mIsChecked = it },
        )
    }
}