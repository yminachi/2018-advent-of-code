class DaySeven {
    data class Worker(var workingOn: Char?, var finishedAt: Int?)

    fun partOne(input: String, letterRangeStart: Char, letterRangeEnd: Char): String {
        val lines = input.split("\n")

        val letterDependencies = hashMapOf<Char, ArrayList<Char>>()

        var char = letterRangeStart
        while (char <= letterRangeEnd) {
            letterDependencies[char] = arrayListOf()
            ++char
        }

        lines.forEach { line ->
            val lineParts = line.split("Step ", " must be finished before step ", " can begin.")
            val firstLetter = lineParts[1].toCharArray()[0]
            val secondLetter = lineParts[2].toCharArray()[0]

            letterDependencies[secondLetter]?.add(firstLetter)
        }

        var result = ""

        while (letterDependencies.count() > 0) {
            val letter = letterDependencies.filter { it.value.count() == 0 }.keys.first()
            result += letter

            letterDependencies.remove(letter)
            letterDependencies.forEach { it.value.remove(letter) }
        }

        return  result
    }

    fun partTwo(input: String, letterRangeStart: Char, letterRangeEnd: Char, numberOfWorkers: Int, baseLetterTime: Int): Int {
        val lines = input.split("\n")

        val letterDependencies = hashMapOf<Char, ArrayList<Char>>()

        var char = letterRangeStart
        while (char <= letterRangeEnd) {
            letterDependencies[char] = arrayListOf()
            ++char
        }

        lines.forEach { line ->
            val lineParts = line.split("Step ", " must be finished before step ", " can begin.")
            val firstLetter = lineParts[1].toCharArray()[0]
            val secondLetter = lineParts[2].toCharArray()[0]

            letterDependencies[secondLetter]?.add(firstLetter)
        }

        var result = ""
        var currentTime = 0
        val workers = arrayListOf<Worker>()

        for (i in 0 until numberOfWorkers) {
            workers.add(Worker(null, null))
        }

        while (letterDependencies.count() > 0 || workers.filter { it.workingOn != null }.count() > 0) {
            workers.forEach { worker ->
                if (worker.finishedAt == currentTime) {
                    result += worker.workingOn
                    letterDependencies.forEach { it.value.remove(worker.workingOn) }

                    worker.finishedAt = null
                    worker.workingOn = null
                }
            }

            val nextLetter = letterDependencies.filter { it.value.count() == 0 }.keys.firstOrNull()
            val availableWorker = workers.firstOrNull { it.workingOn == null }
            if (nextLetter != null && availableWorker != null) {
                availableWorker.workingOn = nextLetter
                availableWorker.finishedAt = currentTime + baseLetterTime + (nextLetter.toInt() - 64)
                letterDependencies.remove(nextLetter)
            } else  {
                currentTime = workers.minBy { it.finishedAt ?: Int.MAX_VALUE }?.finishedAt ?: currentTime
            }
        }

        return currentTime
    }
}