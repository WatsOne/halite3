package hlt

class Command private constructor(val command: String) {
    companion object {
        fun spawnShip(): Command {
            return Command("g")
        }

        fun transformShipIntoDropoffSite(id: Int): Command {
            return Command("c $id")
        }

        fun move(id: Int, direction: Direction): Command {
            return Command("m $id ${direction.charValue}")
        }
    }
}
