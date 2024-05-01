package com.nuwandacreations.regimientoinmemorialreykmp

import ui.App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.FirebaseOptions
import dev.gitlive.firebase.initialize

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Firebase.initialize(
            applicationContext,
            options = FirebaseOptions(
                applicationId = "1:2956592392:android:c4cf7c4b06369085ea18bd",
                apiKey = "AIzaSyAbNoBc1HNfeq1k_9VJf_jg_LDOAOqov4w",
                projectId = "regimientoinmemorialdelrey",
                storageBucket = "regimientoinmemorialdelrey.appspot.com"
            )
        )

        setContent {
            App()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}