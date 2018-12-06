import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import java.io.File

class DayOneTests {
    private val dayOne = DayOne()

    @Test
    fun whenGivenPositiveFrequenciesReturnsSum() {
        assertEquals(3, dayOne.findFrequency("+1\n+1\n+1"))
    }

    @Test
    fun whenGivenPositiveAndNegativeFrequenciesReturnsSum() {
        assertEquals(0, dayOne.findFrequency("+1\n+1\n-2"))
    }

    @Test
    fun solvesTheProblem() {
        val result = dayOne.findFrequency(getInput())

        assertNotNull(result)

        print("🐔")
        print(result)
        print("🐔")
    }

    @Test
    fun part2() {
        assertEquals(10, dayOne.findFirstDouble("+3\n+3\n+4\n-2\n-4", null, null))
    }

    @Test
    fun solvesPart2() {
        val result = dayOne.findFirstDouble(getInput(), null, null)

        assertNotNull(result)

        print("🐔")
        print(result)
        print("🐔")
    }

    private fun getInput(): String {
        return  File("/Users/yasi/projects/adventofcode/src/test/resources/dayOneInput.txt").readText(Charsets.UTF_8)
    }
}