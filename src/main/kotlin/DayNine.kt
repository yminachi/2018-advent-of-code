import java.util.*

class DayNine {
    fun partOne(input: String): Long {
        val parts = input.split(" players; last marble is worth ", " points")
        val numberOfPlayers = parts[0].toInt()
        val lastMarbleWorth = parts[1].toInt()

        val playerScores = arrayListOf<Long>()

        for (i in 0 until numberOfPlayers) {
            playerScores.add(0)
        }

        val circle = LinkedList(listOf(0))

        var currentPlayer = 0

        for (i in 1..lastMarbleWorth) {
            if (i % 23 == 0) {
                playerScores[currentPlayer] += i.toLong()
                rotateCounterClockwise(circle, 7)
                playerScores[currentPlayer] += circle.first.toLong()
                circle.pop()
            } else {
                rotateClockwise(circle, 2)
                circle.push(i)
            }

            currentPlayer++
            if (currentPlayer == numberOfPlayers) {
                currentPlayer = 0
            }
        }

        return playerScores.max() ?: 0
    }

    private fun rotateClockwise(circle: LinkedList<Int>, number: Int) {
        for (i in 0 until number) {
            val e = circle.pop()
            circle.add(e)
        }
    }

    private fun rotateCounterClockwise(circle: LinkedList<Int>, number: Int) {
        for (i in 0 until number) {
            val e = circle.removeLast()
            circle.push(e)
        }
    }
}