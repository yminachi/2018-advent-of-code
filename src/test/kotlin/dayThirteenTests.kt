import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DayThirteenTests {
    private val dayThirteen = DayThirteen()

    private val exampleInput = "/->-\\        \n" +
            "|   |  /----\\\n" +
            "| /-+--+-\\  |\n" +
            "| | |  | v  |\n" +
            "\\-+-/  \\-+--/\n" +
            "  \\------/ "
    private val example2Input = "/>-<\\  \n" +
            "|   |  \n" +
            "| /<+-\\\n" +
            "| | | v\n" +
            "\\>+</ |\n" +
            "  |   ^\n" +
            "  \\<->/"
    private val input = InputReader().readInputFor("dayThirteenInput")

    @Test
    fun part1Example() {
        assertEquals(Pair(7,3), dayThirteen.partOne(exampleInput))
    }

    @Test
    fun part1Solution() {
        val result = dayThirteen.partOne(input)

        assertEquals(Pair(48, 20), result)
    }

    @Test
    fun part2Example() {
        assertEquals(Pair(6,4), dayThirteen.partTwo(example2Input))
    }

    @Test
    fun part2Solution() {
        val result = dayThirteen.partTwo(input)

        assertEquals(Pair(59, 64), result)
    }
}