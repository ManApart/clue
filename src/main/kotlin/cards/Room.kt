package cards

enum class Room : Token {
    BALLROOM,
    BILLIARD_ROOM,
    CONSERVATORY,
    DINING_ROOM,
    KITCHEN,
    HALL,
    LOUNGE,
    STUDY;

    companion object {
        fun random() : Room {
            return Room.values().toList().shuffled().first()
        }
    }
}