import cards.Card
import cards.Person
import cards.Room
import cards.Weapon

class Deck(private val groups: Int) {

    fun getCards(ignore: Accusation): List<List<Card>> {
        val allCards = getAllCards(ignore).shuffled()
        val cardGroups = distributeCards(allCards)
        return cardGroups.values.toList()
    }

    private fun getAllCards(ignore: Accusation): List<Card> {
        return Person.values().filter { it != ignore.person }.map { Card(person = it) } +
                Weapon.values().filter { it != ignore.weapon }.map { Card(weapon = it) } +
                Room.values().filter { it != ignore.room }.map { Card(room = it) }

    }

    private fun distributeCards(allCards: List<Card>): Map<Int, List<Card>> {
        val cardGroups = mutableMapOf<Int, MutableList<Card>>()
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