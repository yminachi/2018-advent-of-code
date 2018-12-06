class DaySix {
    fun partOne(input: String): Int? {
        val points = hashMapOf<Int, Pair<Int, Int>>()
        val closestGrid = hashMapOf<Pair<Int, Int>, Int>()
        val ineligible = hashMapOf<Int, Boolean>()

        val lines = input.split("\n")

        lines.forEachIndexed { index, line ->
            val lineParts = line.split(", ")
            val x = lineParts[0].toInt()
            val y = lineParts[1].toInt()

            points[index] = Pair(x, y)
        }

        val maxX = points.values.maxBy { it.first }?.first?.plus(5)
        val maxY = points.values.maxBy { it.second }?.second?.plus(5)

        for (i in 0 until maxX!!) {
            for (j in 0 until maxY!!) {
                var shortestDistance = Int.MAX_VALUE
                var pointIndex = -1
                var currentlyTied = false

                points.forEach { point ->
                    val distance = Math.abs(point.value.first - i) + Math.abs(point.value.second - j)

                    if (distance < shortestDistance) {
                        pointIndex = point.key
                        shortestDistance = distance
                        currentlyTied = false
                    } else if (distance == shortestDistance) {
                        currentlyTied = true
                    }
                }

                if (!currentlyTied) {
                    closestGrid[Pair(i, j)] = pointIndex

                    if( i == 0 || i == maxX - 1 || j == 0 || j == maxY - 1) {
                        ineligible[pointIndex] = true
                    }
                }
            }
        }

        val pointsTotalClosestArea = hashMapOf<Int, Int>()

        points.forEach { point ->
            if (ineligible[point.key] != true) {
                pointsTotalClosestArea[point.key] = closestGrid.filter { it.value == point.key }.count()
            }
        }

        return pointsTotalClosestArea.maxBy { it.value }?.value
    }

    fun partTwo(input: String, distanceCap: Int): Int {
        val points = hashMapOf<Int, Pair<Int, Int>>()
        var placesWithinRange = 0

        val lines = input.split("\n")

        lines.forEachIndexed { index, line ->
            val lineParts = line.split(", ")
            val x = lineParts[0].toInt()
            val y = lineParts[1].toInt()

            points[index] = Pair(x, y)
        }

        val padding = distanceCap / points.count()

        val maxX = points.values.maxBy { it.first }?.first?.plus(padding)
        val maxY = points.values.maxBy { it.second }?.second?.plus(padding)

        for (i in -1 * padding until maxX!!) {
            for (j in -1 * padding until maxY!!) {
                var totalDistances = 0

                points.forEach { point ->
                    totalDistances += Math.abs(point.value.first - i) + Math.abs(point.value.second - j)
                }

                if (totalDistances < distanceCap) {
                    placesWithinRange++
                }
            }
        }

        return placesWithinRange
    }
}