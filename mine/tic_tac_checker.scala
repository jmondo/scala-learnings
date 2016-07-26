// 7L7W homework challenge. I wrote this one myself.

class Board(val placements: List[String]) {
  def winner(): String = {
    for(i <- 0 until 3) {
      if(winnerOfRow(i) != "") return winnerOfRow(i)
      if(winnerOfCol(i) != "") return winnerOfCol(i)
    }
    if(winnerOfDiag1 != "") return winnerOfDiag1
    if(winnerOfDiag2 != "") return winnerOfDiag2

    return ""
  }

  def announceWinner = {
    if(winner != "") {
      println("The winner is...")
      println(winner)
    } else if (placements.contains("_")) {
      println("Nobody wins!... YET")      
    } else {
      println("Nobody wins!")
    }
  }

  private def winnerOfRow(row: Integer): String = {
    val offset = row * 3
    winnerFromVals(placements.slice(offset, offset + 3))
  }

  private def winnerFromVals(vals: List[String]): String = {
    if(vals.distinct.length == 1 && vals.head != "_") {
      vals.head
    } else {
      ""
    }
  }

  private def winnerOfCol(column: Int): String = {
    var vals = List[String]()
    for(i <- (column until 9) by 3) { vals = placements(i) :: vals }
    winnerFromVals(vals)
  }

  private def winnerOfDiag1(): String = {
    var vals = List[String]()
    for(i <- (0 until 9) by 4) { vals = placements(i) :: vals }
    winnerFromVals(vals)
  }

  private def winnerOfDiag2(): String = {
    var vals = List[String]()
    for(i <- (2 to 6) by 2) { vals = placements(i) :: vals }
    winnerFromVals(vals)
  }
}

val pieces = List(
  "o", "x", "o",
  "x", "x", "o",
  "_", "_", "x"
)

val board = new Board(pieces)
board.announceWinner
