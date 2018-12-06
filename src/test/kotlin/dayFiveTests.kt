import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import java.io.File

class DayFiveTests {
    private val dayFive = DayFive()

    private val exampleInput = "dabAcCaCBAcCcaDA"

    @Test
    fun part1Example() {
        assertEquals(10, dayFive.partOne(exampleInput))
    }

    @Test
    fun part1Solution() {
        val result = dayFive.partOne(getInput())

        assertEquals(10368, result)
    }

    @Test
    fun part2Example() {
        assertEquals(4, dayFive.partTwo(exampleInput))
    }

    @Test
    fun part2Solution() {
        val result = dayFive.partTwo(getInput())

        assertEquals(4122, result)
    }

    private fun getInput(): String {
        return  File("/Users/yasi/projects/adventofcode/src/test/resources/dayFiveInput.txt").readText(Charsets.UTF_8)
    }
}