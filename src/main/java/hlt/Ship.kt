package hlt

class Ship(owner: Int, id: Int, position: Position, val halite: Int) : Entity(owner, id, position) {

    val isFull: Boolean
        get() = halite >= Constants.MAX_HALITE

    fun makeDropoff(): Command {
        return Command.transformShipIntoDropoffSite(id)
    }

    fun move(direction: Direction): Command {
        return Command.move(id, direction)
    }

    fun stayStill(): Command {
        return Command.move(id, Direction.STILL)
    }

    companion object {
        internal fun read(playerId: Int): Ship {
            val input = Input.readInput()

            val shipId = input.nextInt
            val x = input.nextInt
            val y = input.nextInt
            val halite = input.nextInt

            return Ship(playerId, shipId, Position(x, y), halite)
        }
    }
}
