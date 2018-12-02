package player

import Accusation
import cards.Card

interface PlayerController {
    fun makeAccusation() : Accusation
    fun accusationResponse(accusation: Accusation) : Card
    fun deduceFromUnansweredResponse(accusation: Accusation)
}