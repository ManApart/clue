import cards.Person
import cards.Weapon
import cards.Room
import player.Player

//TODO - much of the logic in this class should be pulled out / re-orged to be testable
class Game(players: List<Person>) {
    private val answer = Accusation(Person.random(), Weapon.random(), Room.random())

    val cards = Deck(players.size).getCards(answer)
    val players = createPlayers(players)

    private fun createPlayers(players: List<Person>): List<Player> {
        val list = mutableListOf<Player>()
        for (i: Int in 0 until players.size) {
            list.add(Player(players[i], cards[i]))
        }
        return list
    }

    fun start() {
        var solved = false
        while (!solved) {
            players.forEach { player ->
                if (player.canSolve()) {
                    println("$player has solved the murder.")
                    print("Answer: $answer")
                    return@forEach
                } else {
                    makeAccusation(player)
                }
            }
            solved = true
        }
    }

    private fun makeAccusation(player: Player) {
        val accusation = player.makeAccusation()
        println("$player makes $accusation")
        val otherPlayers = getOtherPlayers(player)
        for (i: Int in 0 until otherPlayers.size) {
            val other = otherPlayers[i]
            if (other.canRespondToAccusation(accusation)) {
                println("$other can deny the accusation")
                val response = other.accusationResponse(accusation)
                player.viewResponse(response)
                break
            } else {
                println("$other cannot deny the accusation")
            }
        }
    }

    private fun getOtherPlayers(player: Player) : List<Player> {
        val i = players.indexOf(player)
        return players.subList(i+1, players.size) + players.subList(0, i)
    }


}