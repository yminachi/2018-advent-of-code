import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DayFiveTests {
    private val dayFive = DayFive()

    private val exampleInput = "dabAcCaCBAcCcaDA"
    private val input = InputReader().readInputFor("dayFiveInput")

    @Test
    fun part1Example() {
        assertEquals(10, dayFive.partOne(exampleInput))
    }

    @Test
    fun part1Solution() {
        val result = dayFive.partOne(input)

        assertEquals(10368, result)
    }

    @Test
    fun part2Example() {
        assertEquals(4, dayFive.partTwo(exampleInput))
    }

    @Test
    fun part2Solution() {
        val result = dayFive.partTwo(input)

        assertEquals(4122, result)
    }
}