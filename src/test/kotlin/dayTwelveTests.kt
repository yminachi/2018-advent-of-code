import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DayTwelveTests {
    private val dayTwelve = DayTwelve()

    private val exampleInput = "initial state: #..#.#..##......###...###\n" +
            "\n" +
            "...## => #\n" +
            "..#.. => #\n" +
            ".#... => #\n" +
            ".#.#. => #\n" +
            ".#.## => #\n" +
            ".##.. => #\n" +
            ".#### => #\n" +
            "#.#.# => #\n" +
            "#.### => #\n" +
            "##.#. => #\n" +
            "##.## => #\n" +
            "###.. => #\n" +
            "###.# => #\n" +
            "####. => #"
    private val input = InputReader().readInputFor("dayTwelveInput")

    @Test
    fun part1Example() {
        assertEquals(325, dayTwelve.partOne(exampleInput))
    }

    @Test
    fun part1Solution() {
        val result = dayTwelve.partOne(input)

        assertEquals(2040, result)
    }

    @Test
    fun part2Solution() {
        val result = dayTwelve.partTwo(input)

        assertEquals(1700000000011, result)
    }
}