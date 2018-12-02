package cards

enum class Weapon : Token {
    CANDLESTICK,
    KNIFE,
    PIPE,
    REVOLVER,
    ROPE,
    WRENCH;

    companion object {
        fun random() : Weapon {
            return Weapon.values().toList().shuffled().first()
        }
    }
}