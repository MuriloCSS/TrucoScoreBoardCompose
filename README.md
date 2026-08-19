# TrucoScoreBoard 

Aplicativo Android desenvolvido em **Jetpack Compose** para marcação e controle de pontuação em partidas de Truco.

---

##  Sobre o Projeto

O **TrucoScoreBoard** é um placar eletrônico simples e direto projetado para facilitar a contagem de pontos durante partidas de Truco entre duas equipes (Equipe A e Equipe B). O app conta com alertas automáticos para situações especiais de jogo como **Mão de 11** e **Vitória da partida**.

---

##  Funcionalidades

- **Contagem de Pontos:**
  - Botão de incremento rápido de **+1 ponto**.
  - Botão de incremento de **+3 pontos** (podendo ser pressionado repetidas vezes para mãos de 6 ou 9).
- **Alerta de Mão de 11:**
  - Notificação informando qual equipe atingiu a pontuação de 11 pontos.
- **Detecção de Vitória:**
  - Identificação e aviso da equipe vencedora ao atingir ou ultrapassar 12 pontos.
  - Reinício automático da contagem ao confirmar o término da partida no diálogo de alerta.
- **Reinício Manual:**
  - Botão dedicado para zerar o placar a qualquer momento do jogo.
- **Interface Declarativa:**
  - Desenvolvida 100% em **Jetpack Compose** com componentes do **Material Design 3** e suporte a *Edge-to-Edge*.
