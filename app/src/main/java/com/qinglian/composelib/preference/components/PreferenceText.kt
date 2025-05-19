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
import androidx.compose.material3.MaterialTheme
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
 * @param title: title of the section. Disabled by default.
 * @param content: description text of the section.
 * @param onClick: if you want the text to react... Shhhh, be careful, don't wake it up.
 * @param icon: Optional icon on the left, Disabled by default. Yes I'm not supporting RTL yet.
 * @param shouldIconAttachToTitle: if you want the icon to show near title instead of content.
 *        Default to false.
 */
@Composable
fun PreferenceText(modifier: Modifier = Modifier, title: String? = null, content: String? = null,
                   onClick: (() -> Unit)? = null, icon: (@Composable (() -> Unit))? = null,
                   shouldIconAttachToTitle: Boolean = false
) {
    Column (modifier = modifier.clickable { onClick?.let { it() } }) {
        title?.let {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (shouldIconAttachToTitle || content == null) {
                    icon?.let { it(); Spacer(modifier = Modifier.width(Dimens.Padding.medium)) }
                }
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = modifier
                        .padding(
                            vertical = Dimens.Padding.medium,
                            horizontal = Dimens.Padding.small
                        )
                        .weight(Dimens.Weight.SMALL)
                )
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (content != null) {
                if (!shouldIconAttachToTitle) {
                    icon?.let { it(); Spacer(modifier = Modifier.width(Dimens.Padding.medium)) }
                }
                Text(
                    text = content,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = modifier.padding(Dimens.Padding.small)
                        .weight(Dimens.Weight.SMALL) //in case icon takes space
                )
            }
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
            content = "And I like the weather today",
        )
    }
}