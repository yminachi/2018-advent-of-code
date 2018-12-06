import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import java.io.File

class DayFiveTests {
    private val dayFive = DayFive()

    @Test
    fun part1Example() {
        val input = "dabAcCaCBAcCcaDA"
        assertEquals(10, dayFive.partOne(input))
    }

    @Test
    fun part1Solution() {
        val result = dayFive.partOne(getInput())

        assertNotNull(result)

        print("🐔")
        print(result)
        print("🐔")
    }

    @Test
    fun part2Example() {
        val input = "dabAcCaCBAcCcaDA"
        assertEquals(4, dayFive.partTwo(input))
    }

    @Test
    fun part2Solution() {
        val result = dayFive.partTwo(getInput())

        assertNotNull(result)

        print("🐔")
        print(result)
        print("🐔")
    }

    private fun getInput(): String {
        return  File("/Users/yasi/projects/adventofcode/src/test/resources/dayFiveInput.txt").readText(Charsets.UTF_8)
    }
}