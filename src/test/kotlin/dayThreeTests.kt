import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DayThreeTests {
    private val dayThree = DayThree()
    
    private val input = InputReader().readInputFor("dayThreeInput")

    private val exampleInput = "#1 @ 1,3: 4x4\n" +
            "#2 @ 3,1: 4x4\n" +
            "#3 @ 5,5: 2x2"

    @Test
    fun part1Example() {
        assertEquals(4, dayThree.partOne(exampleInput))
    }

    @Test
    fun part1Solution() {
        val result = dayThree.partOne(input)

        assertEquals(121259, result)
    }

    @Test
    fun part2Example() {
        assertEquals(3, dayThree.partTwo(exampleInput))
    }


    @Test
    fun part2Solution() {
        val result = dayThree.partTwo(input)

        assertEquals(239, result)
    }
}