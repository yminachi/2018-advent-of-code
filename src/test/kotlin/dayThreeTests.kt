import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import java.io.File

class DayThreeTests {
    private val dayThree = DayThree()

    @Test
    fun part1Example() {
        val input = "#1 @ 1,3: 4x4\n" +
                "#2 @ 3,1: 4x4\n" +
                "#3 @ 5,5: 2x2"
        assertEquals(4, dayThree.partOne(input))
    }

    @Test
    fun part1Solution() {
        val result = dayThree.partOne(getInput())

        assertNotNull(result)

        print("🐔")
        print(result)
        print("🐔")
    }

    @Test
    fun part2Example() {
        val input = "#1 @ 1,3: 4x4\n" +
                "#2 @ 3,1: 4x4\n" +
                "#3 @ 5,5: 2x2"
        assertEquals(3, dayThree.partTwo(input))
    }


    @Test
    fun part2Solution() {
        val result = dayThree.partTwo(getInput())

        assertNotNull(result)

        print("🐔")
        print(result)
        print("🐔")
    }

    private fun getInput(): String {
        return  File("/Users/yasi/projects/adventofcode/src/test/resources/dayThreeInput.txt").readText(Charsets.UTF_8)
    }
}