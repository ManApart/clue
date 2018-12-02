package player

import Accusation
import cards.Card
import cards.Person
import cards.Room
import cards.Weapon

class AI(private val cards: List<Card>, private val notes: Notes) : PlayerController {

    override fun makeAccusation(): Accusation {
//        return Accusation(Person.random(), Weapon.random(), Room.random())
        val person = notes.getSuspects().first()
        val weapon = notes.getSuspectedWeapons().first()
        val room = notes.getSuspectedRooms().first()
        return Accusation(person, weapon, room)
    }

    override fun accusationResponse(accusation: Accusation): Card {
        return when {
            cards.any{ it.matches(accusation.person)} -> Card(accusation.person)
            cards.any{ it.matches(accusation.weapon)} -> Card(weapon = accusation.weapon)
            cards.any{ it.matches(accusation.room)} -> Card(room = accusation.room)
            else -> throw IllegalArgumentException("Should never offer a response without a card match")
        }
    }
}