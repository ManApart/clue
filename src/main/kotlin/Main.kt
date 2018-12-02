import cards.Person

fun main(args: Array<String>) {
    val game = Game(listOf(Person.GREEN, Person.MUSTARD, Person.PEACOCK))
    game.start()
}