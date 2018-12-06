class DayThree {
    fun partOne(input: String): Int {
        val lines = input.split("\n")

        val grid = hashMapOf<Pair<Int, Int>, Int>()

        lines.forEach { line ->
            val lineParts = line.split("#", " @ ", ",", ": ", "x")

            val x = lineParts[2].toInt()
            val y = lineParts[3].toInt()
            val width = lineParts[4].toInt()
            val height = lineParts[5].toInt()

            for (i in 0 until width) {
                for (j in 0 until height) {
                    grid[Pair(x + i, y + j)] = grid[Pair(x + i, y + j)]?.plus(1) ?: 1
                }
            }
        }

        return grid.values.filter({it > 1}).count()
    }

    fun partTwo(input: String): Int? {
        val lines = input.split("\n")

        lines.forEach { line ->
            val lineParts = line.split("#", " @ ", ",", ": ", "x")

            val id = lineParts[1].toInt()
            val x = lineParts[2].toInt()
            val y = lineParts[3].toInt()
            val width = lineParts[4].toInt()
            val height = lineParts[5].toInt()

            var foundIntersection = false

            lines.forEach { comparingLine ->
                val lineParts2 = comparingLine.split("#", " @ ", ",", ": ", "x")

                val id2 = lineParts2[1].toInt()
                val x2 = lineParts2[2].toInt()
                val y2 = lineParts2[3].toInt()
                val width2 = lineParts2[4].toInt()
                val height2 = lineParts2[5].toInt()

                val intersectingX = x == x2 || x < x2 && x + width > x2 || x > x2 && x2 + width2 > x
                val intersectingY = y == y2 || y < y2 && y + height > y2 || y > y2 && y2 + height2 > y

                if (intersectingX && intersectingY && id2 != id) {
                    foundIntersection = true
                }
            }

            if (!foundIntersection) {
                return id
            }
        }

        return null
    }
}