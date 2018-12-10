class DayEight {
    data class NodeResult(val value: Int, val currentIndex: Int)

    fun partOne(input: String): Int {
        val entries = input.split(" ")
        val intEntries = entries.map { it.toInt() }
        return partOne(intEntries).value
    }

    private fun partOne(input: List<Int>): NodeResult {
        val nodes = input[0]
        val metadatas = input[1]
        var currentSum = 0
        var currentIndex = 2

        for (n in 0 until nodes){
            val result = partOne(input.subList(currentIndex, input.count()))
            currentSum += result.value
            currentIndex += result.currentIndex
        }

        for (n in currentIndex until currentIndex + metadatas) {
            currentSum += input[currentIndex]
            currentIndex++
        }

        return NodeResult(currentSum, currentIndex)
    }

    fun partTwo(input: String): Int {
        val entries = input.split(" ")
        val intEntries = entries.map { it.toInt() }
        return partTwo(intEntries).value
    }

    private fun partTwo(input: List<Int>): NodeResult {
        val nodes = input[0]
        val metadatas = input[1]
        var currentIndex = 2
        var currentSum = 0

        val nodeValues = arrayListOf<Int>()

        for (n in 0 until nodes){
            val result = partTwo(input.subList(currentIndex, input.count()))
            nodeValues.add(result.value)
            currentIndex += result.currentIndex
        }

        for (n in currentIndex until currentIndex + metadatas) {
            val metadataEntry = input[currentIndex]
            if (nodes == 0) {
                currentSum += metadataEntry
            } else if (metadataEntry > 0 && metadataEntry <= nodeValues.count()) {
                currentSum += nodeValues[metadataEntry - 1]
            }
            currentIndex++
        }

        return NodeResult(currentSum, currentIndex)
    }
}