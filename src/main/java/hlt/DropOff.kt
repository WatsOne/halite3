package hlt

class DropOff(owner: Int, id: Int, position: Position) : Entity(owner, id, position) {

    companion object {
        internal fun read(playerId: Int): DropOff {
            val input = Input.readInput()

            val dropOffId = input.nextInt
            val x = input.nextInt
            val y = input.nextInt

            return DropOff(playerId, dropOffId, Position(x, y))
        }
    }
}
