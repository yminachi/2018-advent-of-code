class DayOne {
    fun partOne(input: String): Int {
        val changes = input.split("\n")
        var sum = 0

        changes.forEach {
            sum += it.toInt()
        }

        return sum
    }

    fun partTwo(input: String, prevSum: Int?, prevMap: HashMap<Int, Boolean>?): Int? {
        val changes = input.split("\n")

        var sum = prevSum ?: 0
        var sumMap = prevMap ?: hashMapOf(0 to true)

        changes.forEach {
            sum += it.toInt()

            if (sumMap[sum] != true) {
                sumMap[sum] = true
            } else {
                return sum
            }
        }

        return partTwo(input, sum, sumMap)
    }
}