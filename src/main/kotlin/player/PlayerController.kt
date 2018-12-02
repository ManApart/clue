package player

import Accusation
import cards.Token

interface PlayerController {
    fun makeAccusation() : Accusation
    fun accusationResponse(accusation: Accusation) : Token
}