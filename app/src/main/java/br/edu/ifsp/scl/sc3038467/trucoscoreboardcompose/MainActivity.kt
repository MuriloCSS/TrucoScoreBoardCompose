package br.edu.ifsp.scl.sc3038467.trucoscoreboardcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.ifsp.scl.sc3038467.trucoscoreboardcompose.ui.theme.TrucoScoreBoardComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TrucoScoreBoardComposeTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    ContadorTruco(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ContadorTruco(name: String, modifier: Modifier = Modifier) {

    var pontsA by remember { mutableStateOf(0) }
    var pontsB by remember { mutableStateOf(0) }

    Row(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            Text(text = "Equipe A", fontSize = 32.sp, modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 64.dp)

            )

            Text(text = "$pontsA", fontSize = 48.sp, modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 48.dp)
            )

            Button({}, modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 96.dp)
                .width(160.dp)
                .height(60.dp)
            ) {
                Text("+1 ponto")
            }
            Button({}, modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp)
                .width(160.dp)
                .height(60.dp)
            ) {
                Text("+3 pontos")
            }

        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            Text(text = "Equipe B", fontSize = 32.sp, modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 64.dp)

            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContadorTrucoPreview() {
    TrucoScoreBoardComposeTheme {
        ContadorTruco("Android")
    }
}