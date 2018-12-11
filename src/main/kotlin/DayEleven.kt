class DayEleven {
    data class Result(val total: Int, val coordinate: Pair<Int, Int>, val size: Int, val wholeGrid: HashMap<Pair<Int, Int>, Int>)

    fun partOne(input: Int): Pair<Int, Int> {
        return largestSquareOfSize(input, 3, hashMapOf()).coordinate
    }

    private fun largestSquareOfSize(input: Int, size: Int, previousSizeGrid: HashMap<Pair<Int, Int>, Int>): Result {
        var maxTotal = 0
        var result = Pair(0,0)
        val grid = hashMapOf<Pair<Int, Int>, Int>()

        for (x in 1..(301 - size)) {
            for (y in 1..(301 - size)) {

                val squarePower = if (previousSizeGrid[Pair(x, y)] == null)
                    findPowerForSquareOfSize(input, Pair(x, y), size) else
                    findPowerForSquareOfSize(input, Pair(x, y), size, previousSizeGrid[Pair(x, y)]!!)

                if (squarePower > maxTotal) {
                    maxTotal = squarePower
                    result = Pair(x, y)
                }

                grid[Pair(x,y)] = squarePower
            }
        }

        return Result(maxTotal, result, size, grid)
    }

    private fun findPowerForSquareOfSize(input: Int, coordinate: Pair<Int, Int>, size: Int): Int {
        var sum = 0
        for (i in 0 until size) {
            for (j in 0 until size) {
                sum += findPower(input, Pair(coordinate.first + i, coordinate.second + j))
            }
        }

        return sum
    }

    private fun findPowerForSquareOfSize(input: Int, coordinate: Pair<Int, Int>, size: Int, oneLessSizeValue: Int): Int {
        var sum = oneLessSizeValue
        for (i in 0 until size) {
            sum += findPower(input, Pair(coordinate.first + i, coordinate.second + size - 1))
        }

        for (j in 0 until size) {
            sum += findPower(input, Pair(coordinate.first + size - 1, coordinate.second + j))
        }

        return sum
    }

    private fun findPower(input: Int, coordinate: Pair<Int, Int>): Int {
        val rackId = coordinate.first + 10
        val digits = ((rackId * coordinate.second + input) * rackId).toString().toCharArray()
        val hundredsDigit = digits[digits.count() - 3]
        return hundredsDigit.toString().toInt() - 5
    }

    fun partTwo(input: Int): Triple<Int, Int, Int> {
        var largestResult = Result(0, Pair(0,0), 1, hashMapOf())
        var previousSizeGrid = hashMapOf<Pair<Int, Int>, Int>()

        for (s in 1..300) {
            print(s.toString() + "\n")
            val result = largestSquareOfSize(input, s, previousSizeGrid)
            if (result.total > largestResult.total) {
                largestResult = Result(result.total, result.coordinate, s, hashMapOf())
            }
            previousSizeGrid = result.wholeGrid
        }

        return Triple(largestResult.coordinate.first, largestResult.coordinate.second, largestResult.size)
    }
}