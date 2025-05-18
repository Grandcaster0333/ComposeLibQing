package com.qinglian.composelib.preference

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.qinglian.composelib.resources.Dimens

/**
 * Title for a preference section
 *
 * @param title: title of the section. Mandatory. Or why are you using this?
 * @param content: optional description text of the section. When set to null, show title only.
 * @param modifier: ...hopefully this is self-explanatory
 */
@Composable
fun PreferenceSectionHeader(title: String, content: String?, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = title,
            modifier = modifier.padding(Dimens.Padding.small)
        )
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
fun PreviewPreferenceSectionHeader() {
    PreferenceSectionHeader("Health check", null)
}