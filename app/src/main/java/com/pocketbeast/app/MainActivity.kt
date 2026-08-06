package com.pocketbeast.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pocketbeast.app.theme.PocketBeastTheme
import androidx.compose.runtime.remember
import com.pocketbeast.app.factory.CompanionFactory
import com.pocketbeast.app.game.CompanionGameLoop
import com.pocketbeast.app.ui.PetCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PocketBeastTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CompanionScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CompanionScreen(modifier: Modifier = Modifier) {
    val companion = remember {
        CompanionFactory.createWolf("Fenrir")
    }

    CompanionGameLoop(
        companion = companion
    )

    PetCard(
        companion = companion,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun CompanionScreenPreview() {
    PocketBeastTheme {
        CompanionScreen()
    }
}