import hlt.*
import java.util.Random
import kotlin.collections.ArrayList

object MyBot {
    @JvmStatic
    fun main(args: Array<String>) {
        val game = Game()
        // At this point "game" variable is populated with initial map data.
        // This is a good place to do computationally expensive start-up pre-processing.
        // As soon as you call "ready" function below, the 2 second per turn timer will start.
        game.ready("WatsOne")
        Log.log("Successfully created bot! My Player ID is " + game.myId)

        while (true) {
            game.updateFrame()
            val me = game.me
            val gameMap = game.gameMap

            val commandQueue = ArrayList<Command>()

            for (ship in me.ships.values) {
                if ((gameMap.at(ship)?.halite ?: 0) < Constants.MAX_HALITE / 10 || ship.isFull) {
                    val randomDirection = Direction.ALL_CARDINALS[Random().nextInt(4)]
                    commandQueue.add(ship.move(randomDirection))
                } else {
                    commandQueue.add(ship.stayStill())
                }
            }

            if (game.turnNumber <= 200 &&
                    me.halite >= Constants.SHIP_COST &&
                    gameMap.at(me.shipyard)?.isOccupied != true) {
                commandQueue.add(me.shipyard.spawn())
            }

            game.endTurn(commandQueue)
        }
    }
}
