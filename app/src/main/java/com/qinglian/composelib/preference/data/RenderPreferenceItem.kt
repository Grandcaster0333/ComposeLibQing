package com.qinglian.composelib.preference.data

import androidx.compose.runtime.Composable
import com.qinglian.composelib.preference.components.PreferenceSwitch
import com.qinglian.composelib.preference.components.PreferenceText
import com.qinglian.composelib.preference.container.PreferenceGroup

@Composable
fun RenderPreferenceItem(item: PreferenceItem) {
    when (item) {
        is PreferenceItem.Text -> {
            PreferenceText(title = item.title, content = item.content, onClick = item.onClick,
                icon = item.icon, shouldIconAttachToTitle = item.shouldIconAttachToTitle)
        }
        is PreferenceItem.Switch -> {
            PreferenceSwitch(title = item.title, content = item.content, isChecked = item.isChecked,
                onChange = item.onChange, icon = item.icon)
        }
        is PreferenceItem.Group -> {
            PreferenceGroup(title = item.title, description = item.description, withDivider = item.withDivider) {
                item.children.forEach { RenderPreferenceItem(it) }
            }
        }
    }
}