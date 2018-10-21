package hlt

class Player(val id: Int, val shipyard: Shipyard) {
    var halite: Int = 0
    val ships = mutableMapOf<Int, Ship>()
    val s2 = mutableListOf<Ship>()
    val dropoffs = mutableMapOf<Int, DropOff>()

    internal fun update(numShips: Int, numDropoffs: Int, halite: Int) {
        this.halite = halite

        ships.clear()
        for (i in 0 until numShips) {
            val ship = Ship.read(id)
            ships[ship.id] = ship
            s2.add(ship)
        }

        dropoffs.clear()
        for (i in 0 until numDropoffs) {
            val dropoff = DropOff.read(id)
            dropoffs[dropoff.id] = dropoff
        }
    }

    companion object {
        internal fun read(): Player {
            val input = Input.readInput()

            val playerId = input.nextInt
            val shipyardX = input.nextInt
            val shipyardY = input.nextInt

            return Player(playerId, Shipyard(playerId, Position(shipyardX, shipyardY)))
        }
    }
}
