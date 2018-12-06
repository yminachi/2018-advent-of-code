import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class DayOneTests {
    private val dayOne = DayOne()

    private val input = InputReader().readInputFor("dayOneInput")

    @Test
    fun part1Example() {
        assertEquals(0, dayOne.partOne("+1\n+1\n-2"))
    }

    @Test
    fun part1Solution() {
        val result = dayOne.partOne(input)

        assertEquals(486, result)
    }

    @Test
    fun part2Example() {
        assertEquals(10, dayOne.partTwo("+3\n+3\n+4\n-2\n-4", null, null))
    }

    @Test
    fun part2Solution() {
        val result = dayOne.partTwo(input, null, null)

        assertEquals(69285, result)
    }
}