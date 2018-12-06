class DayFive {
    fun partOne(input: String): Int {
        var lastInput = input
        var thisInput = removeMatch(input)

        while (thisInput != lastInput) {
            lastInput = thisInput
            thisInput = removeMatch(thisInput)
        }

        return thisInput.length
    }

    private fun removeMatch(input: String): String {
        var previous = '0'

        input.toCharArray().forEachIndexed { index, c ->
            if (c.isUpperCase() && c.toLowerCase() == previous || c.isLowerCase() && c.toUpperCase() == previous) {
                return input.removeRange(index - 1, index + 1)
            }

            previous = c
        }

        return input
    }

    fun partTwo(input: String): Int {
        var minWithCharRemoved = Int.MAX_VALUE

        var c = 'A'
        while (c <= 'Z') {
            print(c.toString() + "\n")
            minWithCharRemoved = Math.min(minWithCharRemoved, partOne(input.replace(c.toString(), "").replace(c.toLowerCase().toString(), "")))
            ++c
        }

        return minWithCharRemoved
    }
}