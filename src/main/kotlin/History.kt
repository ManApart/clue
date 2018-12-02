class History {
    private val turns = mutableListOf<Turn>()

    fun addTurn(turn: Turn) {
        turns.add(turn)
        turn.print()
    }
}