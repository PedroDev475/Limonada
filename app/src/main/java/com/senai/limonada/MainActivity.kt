package com.senai.limonada

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.senai.limonada.ui.theme.LimonadaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LimonadaTheme {

                    LimonadaAPP(

                    )
                }
            }
        }
    }


@Composable
fun LimonadaAPP() {
    LimonadaGelada(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun LimonadaGelada (modifier: Modifier = Modifier) {
    var resultado by remember { mutableStateOf(1) }
    val imageResource = when (resultado) {
        1 -> R.drawable.lemon_drink
        2 -> R.drawable.lemon_tree
        3 -> R.drawable.lemon_squeeze
        else -> R.drawable.lemon_restart
    }
}