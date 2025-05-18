package com.qinglian.composelib.preference

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.qinglian.composelib.resources.Dimens

@Composable
fun PreferenceText(
    modifier: Modifier = Modifier,
    content: String,
    onClick: () -> Unit
) {
    Text(
        text = content,
        modifier = modifier.padding(vertical = Dimens.Padding.medium, horizontal = Dimens.Padding.small)
            .clickable { onClick() }
    )
}