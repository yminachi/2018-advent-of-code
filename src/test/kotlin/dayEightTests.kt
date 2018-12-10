import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DayEightTests {
    private val dayEight = DayEight()

    private val input = InputReader().readInputFor("dayEightInput")

    private val exampleInput = "2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2"

    @Test
    fun part1Example() {
        assertEquals(138, dayEight.partOne(exampleInput))
    }

    @Test
    fun part1Solution() {
        val result = dayEight.partOne(input)

        assertEquals(36027, result)
    }

    @Test
    fun part2Example() {
        assertEquals(66, dayEight.partTwo(exampleInput))
    }

    @Test
    fun part2Solution() {
        val result = dayEight.partTwo(input)

        assertEquals(23960, result)
    }
}