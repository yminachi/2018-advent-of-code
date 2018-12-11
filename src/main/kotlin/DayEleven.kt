class DayEleven {
    fun partOne(input: Int): Pair<Int, Int> {
        val allPower = populateBaseGrid(input)
        var previousTotals = Array(300, { IntArray(300) })
        var largestResult = LargestOfSizeResult(0, 0, 0, 0, arrayOf())

        for (size in 1..3) {
            val result = largestSquareOfSize(allPower, size, previousTotals)

            previousTotals = result.totalsGrid

            if (size == 3) {
                largestResult = result
            }
        }

        return Pair(largestResult.x + 1, largestResult.y + 1)
    }

    data class LargestOfSizeResult(val total: Int, val x: Int, val y: Int, val size: Int, val totalsGrid: Array<IntArray>)

    private fun largestSquareOfSize(grid: Array<IntArray>, size: Int, previousTotalsGrid: Array<IntArray>): LargestOfSizeResult {
        val gridSize = 301 - size
        val totalsGrid = Array(gridSize, { IntArray(gridSize) })

        var maxTotal = 0
        var maxTotalX = 0
        var maxTotalY = 0

        for (x in 0 until gridSize) {
            for (y in 0 until gridSize) {
                val total = findPowerForSquareOfSize(grid, x, y, size, previousTotalsGrid[x][y])
                totalsGrid[x][y] = total

                if (total >= maxTotal) {
                    maxTotalX = x
                    maxTotalY = y
                    maxTotal = total
                }
            }
        }

        return LargestOfSizeResult(maxTotal, maxTotalX, maxTotalY, size, totalsGrid)
    }

    private fun findPowerForSquareOfSize(grid: Array<IntArray>, x: Int, y: Int, size: Int, oneLessSizeValue: Int): Int {
        var sum = oneLessSizeValue
        for (i in 0 until size) {
            sum += grid[x + i][y + size - 1]
        }

        for (j in 0 until size - 1) {
            sum += grid[x + size - 1][y + j]
        }

        return sum
    }

    private fun findPower(input: Int, coordinate: Pair<Int, Int>): Int {
        val rackId = coordinate.first + 10
        val digits = ((rackId * coordinate.second + input) * rackId).toString().toCharArray()
        val hundredsDigit = digits[digits.count() - 3]
        return hundredsDigit.toString().toInt() - 5
    }

    private fun populateBaseGrid(input: Int): Array<IntArray> {
        val allPowerTotals = Array(300, { IntArray(300) })

        for (i in 0 until 300) {
            for (j in 0 until 300) {
                allPowerTotals[i][j] = findPower(input, Pair(i + 1, j + 1))
            }
        }

        return allPowerTotals
    }

    fun partTwo(input: Int): Triple<Int, Int, Int> {
        val allPower = populateBaseGrid(input)
        var previousTotals = Array(300, { IntArray(300) })
        var largestResult = LargestOfSizeResult(0, 0, 0, 0, arrayOf())

        for (size in 1..300) {
            val result = largestSquareOfSize(allPower, size, previousTotals)

            previousTotals = result.totalsGrid

            if (result.total >= largestResult.total) {
                largestResult = result
            }
        }

        return Triple(largestResult.x + 1, largestResult.y + 1, largestResult.size)
    }
}