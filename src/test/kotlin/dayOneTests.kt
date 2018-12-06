import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class DayOneTests {
    private val dayOne = DayOne()

    @Test
    fun part1Example() {
        assertEquals(0, dayOne.partOne("+1\n+1\n-2"))
    }

    @Test
    fun part1Solution() {
        val result = dayOne.partOne(getInput())

        assertEquals(486, result)
    }

    @Test
    fun part2Example() {
        assertEquals(10, dayOne.partTwo("+3\n+3\n+4\n-2\n-4", null, null))
    }

    @Test
    fun part2Solution() {
        val result = dayOne.partTwo(getInput(), null, null)

        assertEquals(69285, result)
    }

    private fun getInput(): String {
        return  File("/Users/yasi/projects/adventofcode/src/test/resources/dayOneInput.txt").readText(Charsets.UTF_8)
    }
}