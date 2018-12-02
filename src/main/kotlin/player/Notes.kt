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
    }

    fun canSolve(): Boolean {
        return Person.values().size - eliminatedPeople.size == 1
                && Weapon.values().size - eliminatedWeapons.size == 1
                && Room.values().size - eliminatedRooms.size == 1
    }

    fun getSuspects() : List<Person> {
        return Person.values().filter { !eliminatedPeople.contains(it) }
    }

    fun getSuspectedWeapons() : List<Weapon> {
        return Weapon.values().filter { !eliminatedWeapons.contains(it) }
    }

    fun getSuspectedRooms() : List<Room> {
        return Room.values().filter { !eliminatedRooms.contains(it) }
    }

}