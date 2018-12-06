import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import java.io.File

class DaySixTests {
    private val daySix = DaySix()

    @Test
    fun part1Example() {
        val input = "1, 1\n" +
                "1, 6\n" +
                "8, 3\n" +
                "3, 4\n" +
                "5, 5\n" +
                "8, 9"
        assertEquals(17, daySix.partOne(input))
    }

    @Test
    fun part1Solution() {
        val result = daySix.partOne(getInput())

        assertNotNull(result)

        print("🐔")
        print(result)
        print("🐔")
    }

    @Test
    fun part2Example() {
        val input = "1, 1\n" +
                "1, 6\n" +
                "8, 3\n" +
                "3, 4\n" +
                "5, 5\n" +
                "8, 9"
        assertEquals(16, daySix.partTwo(input, 32))
    }

    @Test
    fun part2Solution() {
        val result = daySix.partTwo(getInput(), 10000)

        assertNotNull(result)

        print("🐔")
        print(result)
        print("🐔")
    }

    private fun getInput(): String {
        return  File("/Users/yasi/projects/adventofcode/src/test/resources/daySixInput.txt").readText(Charsets.UTF_8)
    }
}