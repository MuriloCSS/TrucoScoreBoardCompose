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
        }

        }
}