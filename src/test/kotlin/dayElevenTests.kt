import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DayElevenTests {
    private val dayEleven = DayEleven()

    @Test
    fun part1Example() {
        assertEquals(Pair(33,45), dayEleven.partOne(18))
        assertEquals(Pair(21,61), dayEleven.partOne(42))
    }

    @Test
    fun part1Solution() {
        val result = dayEleven.partOne(5177)

        assertEquals(Pair(235,22), result)
    }

    @Test
    fun part2Example() {
        assertEquals(Triple(90,269,16), dayEleven.partTwo(18))
        assertEquals(Triple(232,251,12), dayEleven.partTwo(42))
    }

    @Test
    fun part2Solution() {
        val result = dayEleven.partTwo(5177)

        assertEquals(Triple(231,135,8), result)
    }

}