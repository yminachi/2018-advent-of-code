import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DayTwoTests {
    private val dayTwo = DayTwo()

    private val input = InputReader().readInputFor("dayTwoInput")

    @Test
    fun part1Example() {
        val input = "abcdef\nbababc\nabbcde\nabcccd\naabcdd\nabcdee\nababab"
        assertEquals(12, dayTwo.partOne(input))
    }

    @Test
    fun part1Solution() {
        val result = dayTwo.partOne(input)

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
        val result = dayTwo.partTwo(input)

        assertEquals("ivjhcadokeltwgsfsmqwrbnuy", result)
    }
}