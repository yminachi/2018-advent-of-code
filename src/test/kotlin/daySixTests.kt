import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DaySixTests {
    private val daySix = DaySix()

    private val input = InputReader().readInputFor("daySixInput")

    private val exampleInput = "1, 1\n" +
            "1, 6\n" +
            "8, 3\n" +
            "3, 4\n" +
            "5, 5\n" +
            "8, 9"

    @Test
    fun part1Example() {
        assertEquals(17, daySix.partOne(exampleInput))
    }

    @Test
    fun part1Solution() {
        val result = daySix.partOne(input)

        assertEquals(3238, result)
    }

    @Test
    fun part2Example() {
        assertEquals(16, daySix.partTwo(exampleInput, 32))
    }

    @Test
    fun part2Solution() {
        val result = daySix.partTwo(input, 10000)

        assertEquals(45046, result)
    }
}