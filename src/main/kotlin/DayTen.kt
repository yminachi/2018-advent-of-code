class DayTen {
    fun partOne(input: String): Int {
        val lines = input.split("\n")
        var instructions = hashMapOf<Pair<Int, Int>, ArrayList<Pair<Int, Int>>>()

        lines.forEach {
            val line = it.replace(" ", "")
            val parts = line.split("position=<", ">velocity=<", ">", ",")
            val x = parts[1].toInt()
            val y = parts[2].toInt()
            val vx = parts[3].toInt()
            val vy = parts[4].toInt()

            if (instructions[Pair(x,y)] == null) {
                instructions[Pair(x,y)] = arrayListOf()
            }

            instructions[Pair(x,y)]!!.add(Pair(vx, vy))
        }

        for (i in 0..100000) {
            val coordinate = checkForALine(instructions)
            if (coordinate != null) {
                drawInstructions(instructions, coordinate)
                return i
            }

            instructions = applyVelocity(instructions)
        }

        return -1
    }

    private fun drawInstructions(instructions: HashMap<Pair<Int, Int>, ArrayList<Pair<Int, Int>>>, coordinate: Pair<Int, Int>) {
        for (y in -20..20) {
            for (x in -70..50) {
                if (instructions[Pair(coordinate.first + x, coordinate.second + y)] != null) {
                    print("#")
                } else {
                    print(".")
                }
            }
            print("\n")
        }

    }

    private fun checkForALine(instructions: HashMap<Pair<Int, Int>, ArrayList<Pair<Int, Int>>>): Pair<Int, Int>? {
        instructions.keys.forEach { coordinate ->
            val otherPointsInI = arrayListOf(Pair(coordinate.first + 1, coordinate.second + 1),
                                    Pair(coordinate.first + 1, coordinate.second + 2),
                                    Pair(coordinate.first + 1, coordinate.second + 3),
                                    Pair(coordinate.first + 1, coordinate.second + 4),
                                    Pair(coordinate.first + 1, coordinate.second + 5))
            var oneMissing = false
            otherPointsInI.forEach {
                if (instructions[it] == null) {
                    oneMissing = true
                }
            }

            if (!oneMissing) {
                return coordinate
            }
        }

        return null
    }

    private fun applyVelocity(instructions: HashMap<Pair<Int, Int>, ArrayList<Pair<Int, Int>>>): HashMap<Pair<Int, Int>, ArrayList<Pair<Int, Int>>> {
        val newInstructions = hashMapOf<Pair<Int, Int>, ArrayList<Pair<Int, Int>>>()

        instructions.forEach { coordinate ->
            coordinate.value.forEach { velocity ->
                val x = coordinate.key.first + velocity.first
                val y = coordinate.key.second + velocity.second

                if (newInstructions[Pair(x,y)] == null) {
                    newInstructions[Pair(x,y)] = arrayListOf()
                }

                newInstructions[Pair(x,y)]!!.add(velocity)
            }
        }

        return newInstructions
    }
}