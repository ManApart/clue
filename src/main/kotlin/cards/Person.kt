package cards

enum class Person {
    GREEN,
    MUSTARD,
    PEACOCK,
    PLUM,
    SCARLETT,
    WHITE;

    companion object {
        fun random() : Person {
            return Person.values().toList().shuffled().first()
        }
    }
}