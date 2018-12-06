import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DayFourTests {
    private val dayFour = DayFour()

    private val input = InputReader().readInputFor("dayFourInput")
    private val exampleInput = "[1518-11-01 00:00] Guard #10 begins shift\n" +
            "[1518-11-01 00:05] falls asleep\n" +
            "[1518-11-01 00:25] wakes up\n" +
            "[1518-11-01 00:30] falls asleep\n" +
            "[1518-11-04 00:02] Guard #99 begins shift\n" +
            "[1518-11-05 00:03] Guard #99 begins shift\n" +
            "[1518-11-03 00:29] wakes up\n" +
            "[1518-11-03 00:05] Guard #10 begins shift\n" +
            "[1518-11-04 00:36] falls asleep\n" +
            "[1518-11-01 00:55] wakes up\n" +
            "[1518-11-05 00:45] falls asleep\n" +
            "[1518-11-01 23:58] Guard #99 begins shift\n" +
            "[1518-11-02 00:40] falls asleep\n" +
            "[1518-11-02 00:50] wakes up\n" +
            "[1518-11-03 00:24] falls asleep\n" +
            "[1518-11-04 00:46] wakes up\n" +
            "[1518-11-05 00:55] wakes up"

    @Test
    fun part1Example() {
        assertEquals(240, dayFour.partOne(exampleInput))
    }

    @Test
    fun part1Solution() {
        val result = dayFour.partOne(input)

        assertEquals(12504, result)
    }

    @Test
    fun part2Example() {
        assertEquals(4455, dayFour.partTwo(exampleInput))
    }

    @Test
    fun part2Solution() {
        val result = dayFour.partTwo(input)

        assertEquals(139543, result)
    }
}