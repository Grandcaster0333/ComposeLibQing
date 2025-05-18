package com.qinglian.composelib.preference.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.qinglian.composelib.resources.Dimens

/**
 * Divider class of preferences
 */
@Composable
fun PreferenceDivider(modifier: Modifier) {
    HorizontalDivider(
        modifier = modifier.padding(vertical = Dimens.Padding.medium),
        color = Color.Gray,
        thickness = Dimens.ComponentSize.dividerThickness
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewPreferenceDivider() {
    PreferenceDivider(Modifier)
}