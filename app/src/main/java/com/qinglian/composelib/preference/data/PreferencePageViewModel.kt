package com.qinglian.composelib.preference.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * ViewModel for preference page
 */
class PreferencePageViewModel : ViewModel() {
    private val _uiState: MutableStateFlow<List<PreferenceItem>> = MutableStateFlow(ArrayList())
    val uiState = _uiState

    fun updatePreference(command: PreferenceUpdateCommand) {
        _uiState.update { list ->
            list.mapIndexed { i, item ->
                when (command) {
                    is PreferenceUpdateCommand.UpdateTitle -> {
                        if (i == command.index && item is PreferenceItem.Text)
                            item.copy(title = command.newTitle)
                        else if (i == command.index && item is PreferenceItem.Switch)
                            item.copy(title = command.newTitle)
                        else if (i == command.index && item is PreferenceItem.Group)
                            item.copy(title = command.newTitle)
                        else item
                    }
                    is PreferenceUpdateCommand.UpdateContent -> {
                        if (i == command.index && item is PreferenceItem.Text)
                            item.copy(content = command.newContent)
                        else if (i == command.index && item is PreferenceItem.Switch)
                            item.copy(content = command.newContent)
                        else if (i == command.index && item is PreferenceItem.Group)
                            item.copy(description = command.newContent)
                        else item
                    }
                    is PreferenceUpdateCommand.UpdateSwitch -> {
                        if (i == command.index && item is PreferenceItem.Switch)
                            item.copy(isChecked = command.isChecked)
                        else item
                    }
                    is PreferenceUpdateCommand.UpdateIcon -> {
                        if (i == command.index && item is PreferenceItem.Text)
                            item.copy(icon = command.newIcon)
                        else if (i == command.index && item is PreferenceItem.Switch)
                            item.copy(icon = command.newIcon)
                        else item
                    }
                }
            }
        }
    }

    fun setItems(items: List<PreferenceItem>) {
        _uiState.value = items
    }

    fun loadSampleData() {
        var mIsFoodChecked = true;
        var mIsRestChecked = false;
        var mIsHappyChecked = true;
        _uiState.value = listOf(
            PreferenceItem.Group(
                title = "Health Check",
                withDivider = true,
                children = listOf(
                    PreferenceItem.Switch(
                        content = "Force Sanders to eat today",
                        isChecked = mIsFoodChecked,
                        onChange = { mIsFoodChecked = it },
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Done,
                                contentDescription = null
                            )
                        }
                    ),
                    PreferenceItem.Switch(
                        content = "Force Sanders to rest today",
                        isChecked = mIsRestChecked,
                        onChange = { mIsRestChecked = it }
                    )
                )
            ),

            PreferenceItem.Group(
                title = "Mood Check",
                withDivider = true,
                children = listOf(
                    PreferenceItem.Switch(
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
                )
            ),

            PreferenceItem.Group(
                children = listOf(
                    PreferenceItem.Text(
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
                )
            ),
        )
    }

    private fun <T> MutableStateFlow<T>.update(transform: (T) -> T) {
        this.value = transform(this.value)
    }
}

sealed class PreferenceItem {
    data class Switch(
        val title: String? = null,
        val content: String,
        val isChecked: Boolean,
        val onChange: ((Boolean) -> Unit)? = null, //UI hint, this should not change in VM
        val icon: (@Composable (() -> Unit))? = null
    ) : PreferenceItem()

    data class Text(
        val title: String? = null,
        val content: String? = null,
        val onClick: (() -> Unit)? = null, //UI hint, this should not change in VM
        val icon: (@Composable (() -> Unit))? = null,
        val shouldIconAttachToTitle: Boolean = false //UI hint, this should not change in VM
    ) : PreferenceItem()

    data class Group(
        val title: String? = null,
        val description: String? = null,
        val withDivider: Boolean = false, //UI hint, this should not change in VM
        val children: List<PreferenceItem>
    ) : PreferenceItem()
}

sealed class PreferenceUpdateCommand {
    data class UpdateTitle(val index: Int, val newTitle: String) : PreferenceUpdateCommand()
    data class UpdateContent(val index: Int, val newContent: String) : PreferenceUpdateCommand()
    data class UpdateSwitch(val index: Int, val isChecked: Boolean) : PreferenceUpdateCommand()
    data class UpdateIcon(val index: Int, val newIcon: (@Composable (() -> Unit)))
        : PreferenceUpdateCommand()
}