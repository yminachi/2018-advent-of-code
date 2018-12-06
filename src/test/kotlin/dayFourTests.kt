import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import java.io.File

class DayFourTests {
    private val dayFour = DayFour()

    @Test
    fun part1Example() {
        val input = "[1518-11-01 00:00] Guard #10 begins shift\n" +
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
        assertEquals(240, dayFour.partOne(input))
    }

    @Test
    fun part1Solution() {
        val result = dayFour.partOne(getInput())

        assertNotNull(result)

        print("🐔")
        print(result)
        print("🐔")
    }

    @Test
    fun part2Example() {
        val input = "[1518-11-01 00:00] Guard #10 begins shift\n" +
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
        assertEquals(4455, dayFour.partTwo(input))
    }

    @Test
    fun part2Solution() {
        val result = dayFour.partTwo(getInput())

        assertNotNull(result)

        print("🐔")
        print(result)
        print("🐔")
    }

    private fun getInput(): String {
        return  File("/Users/yasi/projects/adventofcode/src/test/resources/dayFourInput.txt").readText(Charsets.UTF_8)
    }
}