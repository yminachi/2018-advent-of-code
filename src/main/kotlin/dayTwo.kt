class DayTwo {
    fun partOne(input: String): Int {
        val lines = input.split("\n")

        var contains2 = 0
        var contains3 = 0

        lines.forEach { line ->
            val letters = HashMap<Char, Int>()
            line.toCharArray().forEach { char ->
                letters[char] = letters[char]?.plus(1) ?: 1
            }

            if (letters.containsValue(2)) {
                contains2++
            }

            if (letters.containsValue(3)) {
                contains3++
            }
        }

        return contains2 * contains3
    }

    fun partTwo(input: String): String? {
        val lines = input.split("\n")

        lines.forEach { line ->
            lines.forEach { lineComparing ->
                var differences = 0
                var answer = ""
                for (i in 0 until line.length) {
                    if (line[i] != lineComparing[i]) {
                        differences++
                    } else {
                        answer += line[i]
                    }
                }

                if (differences == 1) {
                    return answer
                }
            }
        }

        return null
    }
}