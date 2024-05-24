open class Matrix<T>(array: Array<Item<T>>, private val row: Int) {
    companion object {
        fun int(array: Array<Int>, row: Int) = Matrix(array.map { IntItem(it) }.toTypedArray(), row)
        fun double(array: Array<Double>, row: Int) = Matrix(array.map { DoubleItem(it) }.toTypedArray(), row)
        fun float(array: Array<Float>, row: Int) = Matrix(array.map { FloatItem(it) }.toTypedArray(), row)
        fun string(array: Array<String>, row: Int) = Matrix(array.map { StringItem(it) }.toTypedArray(), row)
    }

    private val column = array.size / row
    private val matrix = createEmptyMatrix(row, column)

    init {
        var counter = 0
        for (i in 0..<row) {
            for (j in 0 ..<column) {
                matrix[i][j] = array[counter++]
            }
        }
    }

    operator fun get(x: Int, y: Int): T {
        return matrix[x][y]?.data!!
    }

    operator fun set(x: Int, y: Int, value: Item<T>) {
        matrix[x][y] = value
    }

    operator fun plus(increment: Matrix<T>): Matrix<T> {
        val result = createEmptyMatrix(row, column)
        for (i in 0..<row)
            for (j in 0..<column)
                result[i][j] = this.getItem(i, j) + increment.getItem(i, j)
        val res = result.flatten().toTypedArray() as Array<Item<T>>
        return Matrix(res, row)
    }

    operator fun minus(decrement: Matrix<T>): Matrix<T> {
        val result = createEmptyMatrix(row, column)
        for (i in 0..<row)
            for (j in 0..<column)
                result[i][j] = this.getItem(i, j) - decrement.getItem(i, j)
        val res = result.flatten().toTypedArray() as Array<Item<T>>
        return Matrix(res, row)
    }

    operator fun times(multiplicand: Matrix<T>): Matrix<T> {
        if (multiplicand.row != column) throw Exception("Invalid Multiplication: Rows and Columns don't match")
        val result = createEmptyMatrix(row, multiplicand.column)
        for (i in 0..<row) {
            for (j in 0..<multiplicand.column) {
                var sum: Item<T>? = null
                for (k in 0..<column) {
                    val product = this.getItem(i, k).times(multiplicand.getItem(k ,j))
                    sum = sum?.plus(product) ?: product
                }
                result[i][j] = sum
            }
        }
        val res = result.flatten().toTypedArray() as Array<Item<T>>
        return Matrix(res, row)
    }

    override fun toString(): String {
        val builder = StringBuilder()
        for (i in 0..<row) {
            builder.append("[")
            for (j in 0..<column) {
                builder.append(matrix[i][j]!!.data)
                if (j != column - 1)
                    builder.append(" ")
            }
            builder.append("]")
            if (i < row - 1) {
                builder.append("\n")
            }
        }
        return builder.toString()
    }

    fun transponse(): Matrix<T> {
        val result = createEmptyMatrix(column, row)
        for (i in 0 until row) {
            for (j in 0 until column) {
                result[j][i] = matrix[i][j]
            }
        }
        val res = result.flatten().toTypedArray() as Array<Item<T>>
        return Matrix(res, column)
    }

    private fun createEmptyMatrix(row: Int, column: Int) = Array(row) { Array<Item<T>?>(column) { null } }

    private fun getItem(x: Int, y: Int): Item<T> {
        return matrix[x][y]!!
    }
}