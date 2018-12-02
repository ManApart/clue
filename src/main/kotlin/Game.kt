import cards.Person
import player.Player

class Game(players: List<Person>) {
    val cards = Deck(players.size).getCards()
    val players = createPlayers(players)

    private fun createPlayers(players: List<Person>) : List<Player>{
        val list = mutableListOf<Player>()
        for (i: Int in 0 until players.size){
            list.add(Player(players[i], cards[i]))
        }

        return list
    }

    fun start() {
        var solved = false
        while (!solved){
            players.forEach {player ->
                if (player.canSolve()){
                    return@forEach
                } else {
                    val accusation = player.makeAccusation()
                    val otherPlayers = players.filter { it != player }
                    otherPlayers.forEach {other ->
                        if (other.canRespondToAccusation(accusation)){
                            val response = other.accusationResponse(accusation)
                            player.viewResponse(response)
                            return@forEach
                        }
                    }
                }
            }
            solved = true
        }
    }



}