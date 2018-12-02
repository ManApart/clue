package cards

import org.junit.Assert.*
import org.junit.Test

class CardTest {

    @Test(expected = IllegalArgumentException::class)
    fun allNullParamsThrowsError() {
        val card = Card()
    }

    @Test(expected = IllegalArgumentException::class)
    fun twoParamsFails() {
        val card = Card(Person.PEACOCK, Weapon.CANDLESTICK)
    }

    @Test(expected = IllegalArgumentException::class)
    fun threeParamsFails() {
        val card = Card(Person.PEACOCK, Weapon.CANDLESTICK, Room.BILLIARD_ROOM)
    }

    @Test
    fun cardMatchesPerson() {
        val card = Card(Person.PEACOCK)
        assertTrue(card.matches(Person.PEACOCK))
        assertFalse(card.matches(Person.PLUM))
    }

    @Test
    fun cardMatchesWeapon() {
        val card = Card(weapon = Weapon.CANDLESTICK)
        assertTrue(card.matches(Weapon.CANDLESTICK))
        assertFalse(card.matches(Weapon.KNIFE))
    }

    @Test
    fun cardMatchesRoom() {
        val card = Card(room = Room.BILLIARD_ROOM)
        assertTrue(card.matches(Room.BILLIARD_ROOM))
        assertFalse(card.matches(Room.CONSERVATORY))
    }
}