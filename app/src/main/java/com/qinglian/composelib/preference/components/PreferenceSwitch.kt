package com.qinglian.composelib.preference.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
fun PreferenceSwitch(modifier: Modifier = Modifier, title: String? = null, content: String,
                     isChecked: Boolean, onChange: ((Boolean) -> Unit)?,
                     icon: (@Composable (() -> Unit))? = null) {
    Column {
        title?.let {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                modifier = modifier.padding(Dimens.Padding.small)
            )
        }
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier.fillMaxWidth().clickable { onChange?.let { it(!isChecked) } }
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.weight(Dimens.Weight.SMALL) //in case switch takes space
            ) {
                icon?.let { it(); Spacer(modifier = Modifier.width(Dimens.Padding.medium)) }
                Text(
                    text = content,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = modifier.padding(Dimens.Padding.small)
                )
            }
            Switch(
                checked = isChecked,
                onCheckedChange = null,
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
            icon = {
                Icon(
                    imageVector = Icons.Default.Done,
                    contentDescription = null
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPreferenceSwitchLongText() {
    var mIsChecked = true;
    ComposeLibQingTheme {
        PreferenceSwitch(
            title = "Health check",
            content = "Force Sanders to eat today and sleep and rest and ok what should I say here",
            isChecked = mIsChecked,
            onChange = { mIsChecked = it },
            icon = {
                Icon(
                    imageVector = Icons.Default.Done,
                    contentDescription = null
                )
            }
        )
    }
}