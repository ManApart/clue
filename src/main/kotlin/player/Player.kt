package player

import Accusation
import cards.Person
import cards.Token

class Player(private val person: Person, private val cards: List<Token>, private val notes: Notes = Notes(cards),  private val controller: PlayerController = AI(cards, notes)) {

    fun makeAccusation() : Accusation {
        return controller.makeAccusation()
    }

    fun canRespondToAccusation(accusation: Accusation) : Boolean {
        return cards.contains(accusation.person) || cards.contains(accusation.weapon) || cards.contains(accusation.room)
    }

    fun accusationResponse(accusation: Accusation) : Token {
        return controller.accusationResponse(accusation)
    }

    fun canSolve() : Boolean {
        return false
    }

    fun viewResponse(response: Token) {

    }

}