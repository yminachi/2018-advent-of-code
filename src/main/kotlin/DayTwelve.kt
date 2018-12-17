class DayTwelve {
    fun partOne(input: String): Int {
        return plants(input, 20)
    }

    fun partTwo(input: String): Long {
        //At generation 191, the difference between the sum of it and the previous generation is always 34
        val theMagicDifference = 34
        val theMagicGeneration = 191

        val partialSum = plants(input, theMagicGeneration)

        return (50000000000 - theMagicGeneration) * theMagicDifference + partialSum
    }

    private fun plants(input: String, generations: Int): Int {
        val lines = input.split("\n")
        val initialState = lines[0].split("initial state: ")[1]
        val spreadEntries = lines.subList(2, lines.count())

        var plants = hashMapOf<Int, Char>()
        val nextPlants = hashMapOf<Int, Char>()
        val spread = hashMapOf<String, Char>()

        initialState.toCharArray().forEachIndexed { index, c ->
            plants[index] = c
        }

        spreadEntries.forEach { entry ->
            val parts = entry.split(" => ")
            val match = parts[0]
            val newState = parts[1].toCharArray()[0]

            spread[match] = newState
        }

//        var lastSum = 0

        for (gen in 0 until generations) {
            val lowestPlant = plants.filter { it.value == '#' }.keys.min()!!
            val highestPlant = plants.filter { it.value == '#' }.keys.max()!!

            for (key in lowestPlant - 2..highestPlant + 2) {
                val matchString = getCharFromPlant(plants, key - 2) + getCharFromPlant(plants, key - 1) +
                        getCharFromPlant(plants, key) + getCharFromPlant(plants, key + 1) + getCharFromPlant(plants, key + 2)

                nextPlants[key] = spread[matchString] ?: '.'
            }

            plants = HashMap(nextPlants)


            var sum = 0
            plants.forEach { plant ->
                if (plant.value == '#') {
                    sum += plant.key
                }
            }


            //Throwaway code I used to find those magic convergent numbers
//            val diff = sum - lastSum
//            print("$diff\n")
//
//            lastSum = sum
        }

        var sum = 0
        plants.forEach { plant ->
            if (plant.value == '#') {
                sum += plant.key
            }
        }

        return sum
    }

    private fun getCharFromPlant(plants: HashMap<Int, Char>, key: Int): String {
        return plants[key]?.toString() ?: "."
    }
}