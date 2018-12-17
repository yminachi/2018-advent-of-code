class DayFourteen {
    fun partOne(input: Int): String {
        val scores = arrayListOf(3,7)

        var elf1Index = 0
        var elf2Index = 1

        for (i in 2..input + 10) {
            val sum = scores[elf1Index] + scores[elf2Index]
            val digit1 = sum / 10
            val digit2 = sum % 10

            if (digit1 > 0) {
                scores.add(digit1)
            }

            scores.add(digit2)

            elf1Index = (elf1Index + scores[elf1Index] + 1) % scores.count()
            elf2Index = (elf2Index + scores[elf2Index] + 1) % scores.count()
        }

        var result = ""
        for (i in input until input + 10) {
            result += scores[i].toString()
        }

        return result
    }

    fun partTwo(input: String): Int {
        val scores = arrayListOf(3,7)
        val matchedCharacters = input.length

        var elf1Index = 0
        var elf2Index = 1

        val scoreToMatch = input.toCharArray().map { it.toString().toInt() }

        while (true) {
            val sum = scores[elf1Index] + scores[elf2Index]
            val digit1 = sum / 10
            val digit2 = sum % 10

            if (digit1 > 0) {
                scores.add(digit1)
            }

            scores.add(digit2)

            elf1Index = (elf1Index + scores[elf1Index] + 1) % scores.count()
            elf2Index = (elf2Index + scores[elf2Index] + 1) % scores.count()

            //because there are up to 2 recipes added per round
            for (x in 0..1) {
                var matches = true

                for (i in 0 until matchedCharacters) {
                    val scoreIndex = scores.count() - matchedCharacters - x + i
                    if (scoreIndex < 0 || scores[scoreIndex] != scoreToMatch[i]) {
                        matches = false
                    }
                }

                if (matches) {
                    return scores.count() - matchedCharacters - x
                }
            }
        }
    }
}