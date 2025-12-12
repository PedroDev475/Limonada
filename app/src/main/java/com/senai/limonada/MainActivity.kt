package com.senai.limonada

import android.os.Bundle
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
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
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
    var etapaAtual by remember { mutableStateOf(1) }

    val imageResource = when (etapaAtual){
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val stringResource = when (etapaAtual) {
        1 -> R.drawable.lemon_drink
        2 -> R.drawable.lemon_tree
        3 -> R.drawable.lemon_squeeze
        else -> R.drawable.lemon_restart
    }


    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = "Imagem da etapa  $etapaAtual",
            modifier = modifier
                .clickable {
                    etapaAtual = if (etapaAtual < 4) etapaAtual + 1 else 1
                }
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(stringResource)
    }
}