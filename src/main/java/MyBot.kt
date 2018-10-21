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

            val commandQueue = mutableListOf<Command>()

            when (game.turnNumber) {
                1 -> commandQueue.add(me.shipyard.spawn())
                2 -> {
                    commandQueue.add(me.s2[0].move(Direction.NORTH))
                }
                3 -> commandQueue.add(me.s2[0].move(Direction.NORTH))
                4 -> commandQueue.add(me.s2[0].move(Direction.NORTH))
                5 -> {
                    commandQueue.add(me.shipyard.spawn())
                }
                in (6..10) -> commandQueue.add(me.s2[0].move(Direction.NORTH))
            }

            game.endTurn(commandQueue)
        }
    }
}