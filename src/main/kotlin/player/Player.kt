package player

import cards.Person

import Accusation
import cards.Card

class Player(val person: Person, private val cards: List<Card>, private val notes: Notes = Notes(cards), private val controller: PlayerController = AI(cards, notes)) {

    override fun toString(): String {
        return person.toString()
    }

    fun makeAccusation(): Accusation {
        return controller.makeAccusation()
    }

    fun canRespondToAccusation(accusation: Accusation): Boolean {
        return cards.any { it.matches(accusation.person) } || cards.any { it.matches(accusation.weapon) } || cards.any { it.matches(accusation.room) }
    }

    fun accusationResponse(accusation: Accusation): Card {
        return controller.accusationResponse(accusation)
    }

    fun canSolve(): Boolean {
        return notes.canSolve()
    }

    fun viewResponse(response: Card) {
        notes.eliminate(response)
    }

}