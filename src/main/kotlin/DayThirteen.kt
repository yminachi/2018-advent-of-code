class DayThirteen {
    enum class Direction { Up, Down, Left, Right }
    enum class TrackTurn { ForwardTurn, BackTurn, Intersection }
    enum class IntersectionTurn { Left, Straight, Right }

    data class Cart(var location: Pair<Int, Int>, var facing: Direction, var intersectionCounter: Int)
    data class ParsedInput(val track: HashMap<Pair<Int, Int>, TrackTurn>, val carts: ArrayList<Cart>)

    fun partOne(input: String): Pair<Int, Int> {
        val (track, carts) = parseInput(input)

        while (true) {
            val orderedCarts = carts.sortedWith(compareBy({ it.location.second }, { it.location.first }))

            orderedCarts.forEach { cart ->
                val newLocation = nextLocation(cart)
                val newFacing = nextDirection(cart, track, newLocation)

                //check for crashes
                if (carts.filter { it.location == newLocation }.count() > 0) {
                    return newLocation
                }

                cart.location = newLocation
                cart.facing = newFacing
            }
        }
    }

    fun partTwo(input: String): Pair<Int, Int> {
        val (track, carts) = parseInput(input)

        while (true) {
            val orderedCarts = carts.sortedWith(compareBy({ it.location.second }, { it.location.first }))

            orderedCarts.forEach { cart ->
                val newLocation = nextLocation(cart)
                val newFacing = nextDirection(cart, track, newLocation)

                if (carts.filter { it.location == newLocation }.count() > 0) {
                    carts.removeAll { it.location == newLocation }
                    carts.remove(cart)
                }

                cart.location = newLocation
                cart.facing = newFacing
            }

            if (carts.count() == 1) {
                return carts.first().location
            } else if (carts.count() < 1) {
                //Something has gone wrong
                return Pair(-1, -1)
            }
        }
    }

    private fun nextDirection(cart: Cart, track: HashMap<Pair<Int, Int>, TrackTurn>, newLocation: Pair<Int, Int>): Direction {
        return when (cart.facing) {
            Direction.Up -> when (track[newLocation]) {
                TrackTurn.ForwardTurn -> Direction.Right
                TrackTurn.BackTurn -> Direction.Left
                TrackTurn.Intersection -> turnAtIntersection(cart)
                null -> cart.facing
            }
            Direction.Down -> when (track[newLocation]) {
                TrackTurn.ForwardTurn -> Direction.Left
                TrackTurn.BackTurn -> Direction.Right
                TrackTurn.Intersection -> turnAtIntersection(cart)
                null -> cart.facing
            }
            Direction.Right -> when (track[newLocation]) {
                TrackTurn.ForwardTurn -> Direction.Up
                TrackTurn.BackTurn -> Direction.Down
                TrackTurn.Intersection -> turnAtIntersection(cart)
                null -> cart.facing
            }
            Direction.Left -> when (track[newLocation]) {
                TrackTurn.ForwardTurn -> Direction.Down
                TrackTurn.BackTurn -> Direction.Up
                TrackTurn.Intersection -> turnAtIntersection(cart)
                null -> cart.facing
            }
        }
    }

    private fun nextLocation(cart: Cart): Pair<Int, Int> {
        return when (cart.facing) {
            Direction.Up -> Pair(cart.location.first, cart.location.second - 1)
            Direction.Down -> Pair(cart.location.first, cart.location.second + 1)
            Direction.Left -> Pair(cart.location.first - 1, cart.location.second)
            Direction.Right -> Pair(cart.location.first + 1, cart.location.second)
        }
    }

    private fun parseInput(input: String): ParsedInput {
        val lines = input.split("\n")
        val track = hashMapOf<Pair<Int, Int>, TrackTurn>()
        val carts = arrayListOf<Cart>()

        //Build the map and carts
        lines.forEachIndexed { y, line ->
            line.toCharArray().forEachIndexed { x, char ->
                when (char) {
                    '/' -> track[Pair(x,y)] = TrackTurn.ForwardTurn
                    '\\' -> track[Pair(x,y)] = TrackTurn.BackTurn
                    '+' -> track[Pair(x,y)] = TrackTurn.Intersection
                    '>' -> carts.add(Cart(Pair(x,y), Direction.Right, 0))
                    '<' -> carts.add(Cart(Pair(x,y), Direction.Left, 0))
                    'v' -> carts.add(Cart(Pair(x,y), Direction.Down, 0))
                    '^' -> carts.add(Cart(Pair(x,y), Direction.Up, 0))
                }
            }
        }

        return ParsedInput(track, carts)
    }

    private fun turnAtIntersection(cart: Cart): Direction {
        val turnOrder = arrayOf(IntersectionTurn.Left, IntersectionTurn.Straight, IntersectionTurn.Right)
        val directionClockwise = arrayOf(Direction.Up, Direction.Right, Direction.Down, Direction.Left)

        val turnDirection = turnOrder[cart.intersectionCounter % 3]
        cart.intersectionCounter++

        return when (turnDirection) {
            IntersectionTurn.Straight -> cart.facing
            IntersectionTurn.Right -> directionClockwise[ (directionClockwise.indexOf(cart.facing) + 1) % 4 ]
            IntersectionTurn.Left -> directionClockwise[ (directionClockwise.indexOf(cart.facing) + 3) % 4 ]
        }
    }
}