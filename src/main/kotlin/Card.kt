import cards.Person
import cards.Room
import cards.Weapon
import java.lang.IllegalArgumentException

class Card(val person: Person? = null, val weapon: Weapon? = null, val room: Room? = null) {
    init {
        val notNull = countNotNull(person) + countNotNull(weapon) + countNotNull(room)
        if (notNull != 1) {
            throw IllegalArgumentException("Must have only a person, weapon, or room.")
        }
    }


    private fun countNotNull(property: Any?) : Int {
        return if (property != null) {
            1
        } else {
            0
        }
    }
}