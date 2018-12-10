import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DayNineTests {
    private val dayNine = DayNine()

    private val input = "462 players; last marble is worth 71938 points"
    private val input2 = "462 players; last marble is worth 7193800 points"

    @Test
    fun part1Example() {
        assertEquals(32, dayNine.partOne("9 players; last marble is worth 25 points"))
    }

    @Test
    fun part1MoreExamples() {
        assertEquals(8317, dayNine.partOne("10 players; last marble is worth 1618 points"))
        assertEquals(146373, dayNine.partOne("13 players; last marble is worth 7999 points"))
        assertEquals(2764, dayNine.partOne("17 players; last marble is worth 1104 points"))
        assertEquals(54718, dayNine.partOne("21 players; last marble is worth 6111 points"))
        assertEquals(37305, dayNine.partOne("30 players; last marble is worth 5807 points"))
    }

    @Test
    fun part1Solution() {
        val result = dayNine.partOne(input)

        assertEquals(398371, result)
    }

    @Test
    fun part2Solution() {
        val result = dayNine.partOne(input2)

        assertEquals(3212830280, result)
    }
}