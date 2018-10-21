package hlt

class Shipyard(owner: Int, position: Position) : Entity(owner, -1, position) {

    fun spawn(): Command {
        return Command.spawnShip()
    }
}
