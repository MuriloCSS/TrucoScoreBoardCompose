package br.edu.ifsp.scl.sc3038467.trucoscoreboardcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.ifsp.scl.sc3038467.trucoscoreboardcompose.ui.theme.TrucoScoreBoardComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrucoScoreBoardComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    TrucoApp()
                }
            }
        }
    }
}

@Composable
fun TrucoApp() {
    var scoreA by remember { mutableIntStateOf(0) }
    var scoreB by remember { mutableIntStateOf(0) }

    var alertMao11ShownA by remember { mutableStateOf(false) }
    var alertMao11ShownB by remember { mutableStateOf(false) }

    var showDialog by remember { mutableStateOf(false) }
    var dialogTitle by remember { mutableStateOf("") }
    var dialogMessage by remember { mutableStateOf("") }
    var isGameOver by remember { mutableStateOf(false) }


    fun resetGame() {
        scoreA = 0
        scoreB = 0
        alertMao11ShownA = false
        alertMao11ShownB = false
        isGameOver = false
        showDialog = false
    }

    fun addPoints(isTeamA: Boolean, points: Int) {
        if (isTeamA) scoreA += points else scoreB += points

        if (scoreA >= 12) {
            dialogTitle = "Fim de Jogo"
            dialogMessage = "A Equipe A venceu a partida!"
            isGameOver = true
            showDialog = true
        } else if (scoreB >= 12) {
            dialogTitle = "Fim de Jogo"
            dialogMessage = "A Equipe B venceu a partida!"
            isGameOver = true
            showDialog = true
        } else {
            if (scoreA == 11 && scoreB == 11 && (!alertMao11ShownA || !alertMao11ShownB)) {
                alertMao11ShownA = true
                alertMao11ShownB = true
                dialogTitle = "Atenção: Mão de 11!"
                dialogMessage = "Ambas as equipes estão com 11 pontos"
                showDialog = true
            } else if (scoreA == 11 && !alertMao11ShownA) {
                alertMao11ShownA = true
                dialogTitle = "Atenção: Mão de 11!"
                dialogMessage = "A Equipe A está na mão de 11!"
                showDialog = true
            } else if (scoreB == 11 && !alertMao11ShownB) {
                alertMao11ShownB = true
                dialogTitle = "Atenção: Mão de 11!"
                dialogMessage = "A Equipe B está na mão de 11!"
                showDialog = true
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Equipe A", fontSize = 28.sp, fontWeight = FontWeight.Bold)
                Text(
                    text = "$scoreA",
                    fontSize = 72.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 24.dp)
                )
                Button(
                    onClick = { addPoints(isTeamA = true, points = 1) },
                    enabled = !isGameOver,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3CAF66)),
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)
                ) {
                    Text("+1 Ponto")
                }
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = { addPoints(isTeamA = true, points = 3) },
                    enabled = scoreA < 11 && !isGameOver,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3)),
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)
                ) {
                    Text("+3 Pontos")
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(2.dp)
                    .background(Color.LightGray)
                    .padding(horizontal = 8.dp)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Equipe B", fontSize = 28.sp, fontWeight = FontWeight.Bold)
                Text(
                    text = "$scoreB",
                    fontSize = 72.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 24.dp)
                )
                Button(
                    onClick = { addPoints(isTeamA = false, points = 1) },
                    enabled = !isGameOver,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3CAF66)),
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)
                ) {
                    Text("+1 Ponto")
                }
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = { addPoints(isTeamA = false, points = 3) },
                    enabled = scoreB < 11 && !isGameOver,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3)),
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)
                ) {
                    Text("+3 Pontos")
                }
            }
        }

        }
}