package com.qinglian.composelib.preference.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.qinglian.composelib.resources.Dimens
import com.qinglian.composelib.ui.theme.ComposeLibQingTheme

/**
 * Text preference. Icon, subtitle, all good stuffs.
 * ... don't stair at me, my sanity still exists... hopefully.
 *
 * @param modifier: ...hopefully this is self-explanatory
 * @param title: title (main text) of the section. Mandatory. Or why are you using this?
 * @param content: optional description text of the section. Disabled by default
 * @param onClick: if you want the text to react... Shhhh, be careful, don't wake it up.
 * @param icon: Optional icon on the left, Disabled by default. Yes I'm not supporting RTL yet.
 *        only attached to title.
 */
@Composable
fun PreferenceText(modifier: Modifier = Modifier, title: String, content: String? = null,
                   onClick: (() -> Unit)? = null, icon: (@Composable (() -> Unit))? = null
) {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            icon?.let { it(); Spacer(modifier = Modifier.width(Dimens.Padding.medium)) }
            Text(
                text = title,
                modifier = modifier
                    .padding(
                        vertical = Dimens.Padding.medium,
                        horizontal = Dimens.Padding.small
                    )
                    .weight(Dimens.Weight.SMALL) //in case switch takes space
                    .clickable { onClick?.let { it() } }
            )
        }

        if (content != null) {
            Text(
                text = content,
                modifier = modifier.padding(Dimens.Padding.small)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPreferenceText() {
    ComposeLibQingTheme {
        PreferenceText (
            title = "Try harder.",
            onClick = { }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPreferenceTextFull() {
    ComposeLibQingTheme {
        PreferenceText (
            title = "Try harder. And don't forget who is watching. You shouldn't let go.",
            onClick = { },
            icon = {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = null
                )
            },
            content = "I like the weather today"
        )
    }
}