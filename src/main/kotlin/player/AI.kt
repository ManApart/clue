package player

import Accusation
import cards.Person
import cards.Token

class AI(private val myCards: List<Token>, private val notes: Notes) : PlayerController {
    override fun makeAccusation(): Accusation {
        return Accusation(Person.PEACOCK)
    }

    override fun accusationResponse(accusation: Accusation): Token {
        return when {
            myCards.contains(accusation.person) -> accusation.person
            myCards.contains(accusation.weapon) -> accusation.weapon
            myCards.contains(accusation.room) -> accusation.room
            else -> throw IllegalArgumentException("Should never offer a response without a card match")
        }
    }
}