fun main() {
    val matrix1 = Matrix.int(arrayOf(1, 2, 3, 4), 2)
    val matrix2 = Matrix.int(arrayOf(5, 6, 7, 8), 2)

    println(matrix1 + matrix2)
    println()
    println(matrix1 - matrix2)
    println()
    println(matrix1 * matrix2)
    println()
    println(matrix1.transponse())
}