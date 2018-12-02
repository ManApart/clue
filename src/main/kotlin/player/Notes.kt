package player

import cards.Card
import cards.Person
import cards.Room
import cards.Weapon
import java.lang.IllegalArgumentException


class Notes(cards: List<Card>) {
    private val eliminatedPeople = mutableListOf<Person>()
    private val eliminatedWeapons = mutableListOf<Weapon>()
    private val eliminatedRooms = mutableListOf<Room>()

    var murderer: Person? = null
    var murderWeapon: Weapon? = null
    var murderRoom: Room? = null

    init {
        cards.forEach { eliminate(it) }
    }

    fun eliminate(card: Card) {
        when {
            card.person != null -> eliminatedPeople.add(card.person)
            card.weapon != null -> eliminatedWeapons.add(card.weapon)
            card.room != null -> eliminatedRooms.add(card.room)
            else -> throw IllegalArgumentException("Invalid card $card")
        }

        updateAnswers()
    }

    fun isEliminated(card: Card): Boolean {
        return when {
            card.person != null -> eliminatedPeople.contains(card.person)
            card.weapon != null -> eliminatedWeapons.contains(card.weapon)
            card.room != null -> eliminatedRooms.contains(card.room)
            else -> throw IllegalArgumentException("Invalid card $card")
        }
    }

    private fun updateAnswers() {
        if (murderer == null && Person.values().size - eliminatedPeople.size == 1) {
            murderer = (Person.values().toList() - eliminatedPeople).first()
        }
        if (murderWeapon == null && Weapon.values().size - eliminatedWeapons.size == 1) {
            murderWeapon = (Weapon.values().toList() - eliminatedWeapons).first()
        }
        if (murderRoom == null && Weapon.values().size - eliminatedRooms.size == 1) {
            murderRoom = (Room.values().toList() - eliminatedRooms).first()
        }
    }

    fun canSolve(): Boolean {
        return murderer != null && murderWeapon != null && murderWeapon != null
    }

    fun getSuspects(): List<Person> {
        return Person.values().filter { !eliminatedPeople.contains(it) }
    }

    fun getSuspectedWeapons(): List<Weapon> {
        return Weapon.values().filter { !eliminatedWeapons.contains(it) }
    }

    fun getSuspectedRooms(): List<Room> {
        return Room.values().filter { !eliminatedRooms.contains(it) }
    }

}