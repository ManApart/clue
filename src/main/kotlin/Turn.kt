import cards.Card
import player.Player

class Turn(val player: Player, val accusation: Accusation) {
    val denials = mutableListOf<Player>()
    var response: Card? = null
    var responsePlayer: Player? = null

    fun print() {
        println("$player makes $accusation")

        if (denials.isNotEmpty()) {
            println("${denials.joinToString(", ")} cannot deny the accusation")
        }
        if (responsePlayer != null) {
            println("$responsePlayer can deny the accusation")
        }
    }

}