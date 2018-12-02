import cards.Person
import cards.Weapon
import cards.Room
import player.Player

//TODO - much of the logic in this class should be pulled out / re-orged to be testable
class Game(players: List<Person>) {
    private val answer = Accusation(Person.random(), Weapon.random(), Room.random())

    val cards = Deck(players.size).getCards(answer)
    val players = createPlayers(players)

    val history = History()

    private fun createPlayers(players: List<Person>): List<Player> {
        val list = mutableListOf<Player>()
        for (i: Int in 0 until players.size) {
            list.add(Player(players[i], cards[i]))
        }
        return list
    }

    fun start() {
        println("Starting game; looking for answer: $answer")
        var solved = false
        while (!solved) {
                for (i: Int in 0 until players.size) {
                    val player = players[i]
                if (player.canSolve()) {
                    println("$player has solved the murder.")
                    print("Answer: $answer")
                    solved = true
                    break
                } else {
                    takeTurn(player)
                }
            }
        }
    }

    private fun takeTurn(player: Player) {
        val accusation = player.makeAccusation()
        val turn = Turn(player, accusation)

        val otherPlayers = getOtherPlayers(player)
        for (i: Int in 0 until otherPlayers.size) {
            val other = otherPlayers[i]
            if (other.canRespondToAccusation(accusation)) {
                val response = other.accusationResponse(accusation)
                player.viewResponse(response)
                turn.response = response
                turn.responsePlayer = other
                break
            } else {
                turn.denials.add(other)
            }
        }

        if (turn.response == null){
            player.deduceResponse(accusation)
        }

        history.addTurn(turn)
    }

    private fun getOtherPlayers(player: Player) : List<Player> {
        val i = players.indexOf(player)
        return players.subList(i+1, players.size) + players.subList(0, i)
    }


}