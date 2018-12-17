import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DayFourteenTests {
    private val dayFourteen = DayFourteen()

    private val input = 509671
    private val part2Input = "509671"

    @Test
    fun part1Example() {
        assertEquals("5158916779", dayFourteen.partOne(9))
        assertEquals("0124515891", dayFourteen.partOne(5))
        assertEquals("9251071085", dayFourteen.partOne(18))
        assertEquals("5941429882", dayFourteen.partOne(2018))
    }

    @Test
    fun part1Solution() {
        val result = dayFourteen.partOne(input)

        assertEquals("2810862211", result)
    }

    @Test
    fun part2Example() {
        assertEquals(9, dayFourteen.partTwo("51589"))
        assertEquals(5, dayFourteen.partTwo("01245"))
        assertEquals(18, dayFourteen.partTwo("92510"))
        assertEquals(2018, dayFourteen.partTwo("59414"))
    }

    @Test
    fun part2Solution() {
        val result = dayFourteen.partTwo(part2Input)

        assertEquals(20227889, result)
    }
}