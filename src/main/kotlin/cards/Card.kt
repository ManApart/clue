package cards

class Card(val person: Person? = null, val weapon: Weapon? = null, val room: Room? = null) {
    init {
        val notNull = countNotNull(person) + countNotNull(weapon) + countNotNull(room)
        if (notNull != 1) {
            throw IllegalArgumentException("Must have only a person, weapon, or room.")
        }
    }

    fun matches(other: Person) : Boolean {
        return person == other
    }

    fun matches(other: Weapon) : Boolean {
        return other == other
    }

    fun matches(other: Room) : Boolean {
        return room == other
    }

    private fun countNotNull(property: Any?) : Int {
        return if (property != null) {
            1
        } else {
            0
        }
    }

}