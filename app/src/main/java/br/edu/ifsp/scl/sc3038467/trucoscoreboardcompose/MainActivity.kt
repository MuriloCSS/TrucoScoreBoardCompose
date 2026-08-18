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
import androidx.compose.material3.AlertDialog
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

    var pontosA by remember { mutableStateOf(0) }
    var pontosB by remember { mutableStateOf(0) }
    var mensagemAviso by remember { mutableStateOf("") }
    var alerta by remember { mutableStateOf(false) }

    fun somarPontos(timeA: Boolean, pontos: Int){
        if (timeA){
            pontosA += pontos
            if (pontosA >= 12){
                mensagemAviso = "A Equipe A ganhou a partida!"
                alerta = true
            }else if (pontosA == 11){
                mensagemAviso = "A Equipe A está na mão de 11"
                alerta = true
            }
        }else{
            pontosB += pontos
            if (pontosA >= 12){
                mensagemAviso = "A Equipe B ganhou a partida!"
                alerta = true
            }else if (pontosA == 11){
                mensagemAviso = "A Equipe B está na mão de 11"
                alerta = true
            }
        }
    }

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

            Text(text = "$pontosA", fontSize = 48.sp, modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 48.dp)
            )

            Button({somarPontos(true, 1)}, modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 96.dp)
                .width(160.dp)
                .height(60.dp)
            ) {
                Text("+1 ponto")
            }
            Button({somarPontos(true, 3)}, modifier = Modifier
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
    if (alerta){
        AlertDialog(
            onDismissRequest = {alerta = false},
            title = {Text("Aviso")},
            text = {Text(mensagemAviso)},
            confirmButton = {
                Button(
                    onClick ={if(pontosA >= 12 || pontosB >= 12){
                        pontosA = 0
                        pontosB = 0
                    }
                        alerta = false
                    }

                ) {
                    Text("OK")
                }
            }

        )
    }
}

@Preview(showBackground = true)
@Composable
fun ContadorTrucoPreview() {
    TrucoScoreBoardComposeTheme {
        ContadorTruco("Android")
    }
}