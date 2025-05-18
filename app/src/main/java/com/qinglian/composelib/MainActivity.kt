package com.qinglian.composelib

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.qinglian.composelib.preference.components.PreferenceSwitch
import com.qinglian.composelib.ui.theme.ComposeLibQingTheme

/**
 * Main activity.
 *
 * Surprise! YOU REALLY ONLY NEED THIS ONE ACTIVITY!
 */
class MainActivity : ComponentActivity() {
    private var mIsChecked = true;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeLibQingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PreferenceSwitch(
                        modifier = Modifier.padding(innerPadding),
                        title = "Health check",
                        content = "Force Sanders to eat today",
                        isChecked = mIsChecked,
                        onChange = { mIsChecked = it }
                    )
                }
            }
        }
    }
}