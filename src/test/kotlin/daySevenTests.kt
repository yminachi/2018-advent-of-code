import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DaySevenTests {
    private val daySeven = DaySeven()

    private val input = InputReader().readInputFor("daySevenInput")

    private val exampleInput = "Step C must be finished before step A can begin.\n" +
            "Step C must be finished before step F can begin.\n" +
            "Step A must be finished before step B can begin.\n" +
            "Step A must be finished before step D can begin.\n" +
            "Step B must be finished before step E can begin.\n" +
            "Step D must be finished before step E can begin.\n" +
            "Step F must be finished before step E can begin."

    @Test
    fun part1Example() {
        assertEquals("CABDFE", daySeven.partOne(exampleInput, 'A', 'F'))
    }

    @Test
    fun part1Solution() {
        val result = daySeven.partOne(input, 'A', 'Z')

        assertEquals("ABDCJLFMNVQWHIRKTEUXOZSYPG", result)
    }

    @Test
    fun part2Example() {
        assertEquals(15, daySeven.partTwo(exampleInput, 'A', 'F', 2, 0))
    }

    @Test
    fun part2Solution() {
        val result = daySeven.partTwo(input, 'A', 'Z', 5, 60)

        assertEquals(896, result)
    }
}