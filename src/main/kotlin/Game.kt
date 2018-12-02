import cards.Person
import player.Player

class Game(players: List<Person>) {
    val cards = Deck(players.size).getCards()
    val players = createPlayers(players)

    private fun createPlayers(players: List<Person>) : Map<Person, Player>{
        val map = mutableMapOf<Person, Player>()
        for (i: Int in 0..players.size){
            map[players[i]] = Player(players[i], cards[i])
        }
        return map
    }

//    fun startGame() {
//        var solved = false
//        while (!solved){
//            players.forEach {
//                if (it.)
//            }
//        }
//    }



}