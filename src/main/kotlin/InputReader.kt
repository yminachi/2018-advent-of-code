import java.io.File

class InputReader {
    fun readInputFor(filename: String): String {
        return File("/Users/yasi/projects/adventofcode/src/test/resources/$filename.txt").readText(Charsets.UTF_8)
    }
}