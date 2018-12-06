import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DayFour {
    data class Record(val dateTime: LocalDateTime, val cmd: String)

    fun partOne(input: String): Int {
        val lines = input.split("\n")

        val totalMinAsleep = hashMapOf<Int, Int>()
        val minAsleep = hashMapOf<Int, Map<Int,Int>>()

        var currentGuard: Int? = null
        var asleepAtMinute: Int? = null


        val records = lines.map({ parseLine(it) }).sortedBy { it.dateTime }

        records.forEach {
            when {
                it.cmd.contains("begins shift") -> currentGuard = it.cmd.split(" ", "#")[2].toInt()
                it.cmd == "falls asleep" -> asleepAtMinute = it.dateTime.minute
                it.cmd == "wakes up" -> {
                    val minutesAsleep = it.dateTime.minute - asleepAtMinute!!

                    totalMinAsleep[currentGuard!!] = totalMinAsleep[currentGuard!!]?.plus(minutesAsleep) ?: minutesAsleep

                    val asleepMinutesBreakdown = minAsleep[currentGuard!!] as? HashMap ?: hashMapOf()

                    for (i in asleepAtMinute!! until it.dateTime.minute) {
                        asleepMinutesBreakdown[i] = minAsleep[currentGuard!!]?.get(i)?.plus(1) ?: 1
                    }

                    minAsleep[currentGuard!!] = asleepMinutesBreakdown

                    asleepAtMinute = null
                }
            }
        }

        val snoozyGuard = totalMinAsleep.maxBy({ it.value })?.key
        val snoozyMinute = minAsleep[snoozyGuard]?.maxBy({ it.value })?.key

        return snoozyGuard!! * snoozyMinute!!
    }

    fun partTwo(input: String): Int {
        val lines = input.split("\n")

        val minAsleep = hashMapOf<Pair<Int,Int>, Int>()

        var currentGuard: Int? = null
        var asleepAtMinute: Int? = null

        val records = lines.map({ parseLine(it) }).sortedBy { it.dateTime }

        records.forEach {
            when {
                it.cmd.contains("begins shift") -> currentGuard = it.cmd.split(" ", "#")[2].toInt()
                it.cmd == "falls asleep" -> asleepAtMinute = it.dateTime.minute
                it.cmd == "wakes up" -> {
                    for (i in asleepAtMinute!! until it.dateTime.minute) {
                        minAsleep[Pair(currentGuard!!, i)] = minAsleep[Pair(currentGuard!!, i)]?.plus(1) ?: 1
                    }

                    asleepAtMinute = null
                }
            }
        }

        val entry = minAsleep.maxBy({ it.value })?.key!!
        return entry.first * entry.second
    }

    private fun parseLine(input: String): Record {
        val parts = input.split("[", "] ")
        val timestamp = parts[1]
        val command = parts[2]

        return Record(LocalDateTime.parse(timestamp, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), command)
    }
}