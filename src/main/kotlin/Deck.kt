import cards.Person
import cards.Room
import cards.Token
import cards.Weapon

class Deck(private val groups: Int) {

    fun getCards(): List<List<Token>> {
        val allCards = getAllCards().shuffled()
        val cardGroups = distributeCards(allCards)
        return cardGroups.values.toList()
    }

    private fun getAllCards(): List<Token> {
        return arrayOf(
                Person.values() as Array <Token>,
                Weapon.values() as Array<Token>,
                Room.values() as Array<Token>)
                .flatten()
    }

    private fun distributeCards(allCards: List<Token>) : Map<Int, List<Token>>{
        val cardGroups = mutableMapOf<Int, MutableList<Token>>()
        var cardCount = 0
        var player = 0
        while (cardCount < allCards.size) {
            if (!cardGroups.containsKey(player)) {
                cardGroups[player] = mutableListOf()
            }
            cardGroups[player]?.add(allCards[cardCount])
            cardCount++
            player++
            if (player > groups) {
                player = 0
            }
        }
        return cardGroups
    }

}