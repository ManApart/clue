import cards.Person
import cards.Room
import cards.Weapon
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class DeckTest {

    @Test
    fun cardsDoNotIncludeAnswer() {
        val answer = Accusation(Person.PLUM, Weapon.KNIFE, Room.BILLIARD_ROOM)
        val cards = Deck(1).getCards(answer).flatten()
        val totalCount = Person.values().size + Weapon.values().size + Room.values().size

        assertEquals(totalCount-3, cards.size)
        assertNull(cards.firstOrNull { it.person == answer.person })
        assertNull(cards.firstOrNull { it.weapon == answer.weapon})
        assertNull(cards.firstOrNull { it.room == answer.room })
    }

    @Test
    fun cardGroupsHandleRemainder() {
        val answer = Accusation(Person.PLUM, Weapon.KNIFE, Room.BILLIARD_ROOM)
        val cardGroups = Deck(5).getCards(answer)

        assertEquals(4, cardGroups[0].size)
        assertEquals(4, cardGroups[1].size)
        assertEquals(3, cardGroups[2].size)
        assertEquals(3, cardGroups[3].size)
        assertEquals(3, cardGroups[4].size)
    }
}