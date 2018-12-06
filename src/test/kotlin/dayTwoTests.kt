import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class DayTwoTests {
    private val dayTwo = DayTwo()

    @Test
    fun part1Example() {
        val input = "abcdef\nbababc\nabbcde\nabcccd\naabcdd\nabcdee\nababab"
        assertEquals(12, dayTwo.partOne(input))
    }

    @Test
    fun part1Solution() {
        val result = dayTwo.partOne(getInput())

        assertEquals(7657, result)
    }

    @Test
    fun part2Example() {
        assertEquals("fgij", dayTwo.partTwo("abcde\n" +
                "fghij\n" +
                "klmno\n" +
                "pqrst\n" +
                "fguij\n" +
                "axcye\n" +
                "wvxyz"))
    }

    @Test
    fun part2Solution() {
        val result = dayTwo.partTwo(getInput())

        assertEquals("ivjhcadokeltwgsfsmqwrbnuy", result)
    }

    private fun getInput(): String {
        return  File("/Users/yasi/projects/adventofcode/src/test/resources/dayTwoInput.txt").readText(Charsets.UTF_8)
    }
}