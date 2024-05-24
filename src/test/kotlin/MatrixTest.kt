import org.junit.jupiter.api.Test

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows

class MatrixTest {

    @Test
    fun `Test if get method return with the expected value`() {
        // Given
        val matrix = Matrix.int(arrayOf(5, 6, 7, 8), 2)
        val expected = 7

        // When
        val result = matrix[1, 0]

        // Then
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `Test if set method works`() {
        // Given
        val matrix = Matrix.int(arrayOf(5, 6, 7, 8), 2)
        val expected = 1000

        // When
        matrix[0, 0] = IntItem(expected)

        // Then
        assertThat(matrix[0, 0]).isEqualTo(expected)
    }

    @Test
    fun `Test if plus operator works`() {
        // Given
        val matrix1 = Matrix.string(arrayOf("x", "a", "b", "c"), 2)
        val matrix2 = Matrix.string(arrayOf("y", "d", "e", "f"), 2)
        val expected = "xy"

        // When
        val result = (matrix1 + matrix2)[0, 0]

        // Then
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `Test if minus operator works`() {
        // Given
        val matrix1 = Matrix.int(arrayOf(1, 2, 3, 4), 2)
        val matrix2 = Matrix.int(arrayOf(5, 6, 7, 8), 2)
        val expected = -4

        // When
        val result = (matrix1 - matrix2)[1, 1]

        // Then
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `Test if times operator works`() {
        // Given
        val matrix1 = Matrix.double(arrayOf(1.5, 2.6, 3.7, 4.8), 2)
        val matrix2 = Matrix.double(arrayOf(5.1, 6.2, 7.3, 8.4), 2)
        val expected = 26.63

        // When
        val result = (matrix1 * matrix2)[0, 0]

        // Then
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `Test if times operator throws exception when Matrix sizes do not match`() {
        // Given
        val matrix1 = Matrix.double(arrayOf(1.5, 2.6, 3.7, 4.8), 2)
        val matrix2 = Matrix.double(arrayOf(5.1, 6.2, 7.3, 8.4, 9.5, 10.6), 3)
        val expected = "Invalid Multiplication: Rows and Columns don't match"

        // When
        val exception = assertThrows<Exception> { matrix1 * matrix2 }

        // Then
        assertThat(exception.message).isEqualTo(expected)
    }

    @Test
    fun `Test if toString method works`() {
        // Given
        val matrix = Matrix.float(arrayOf(1.5f, 2.6f, 3.7f, 4.8f), 2)
        val expected = "[1.5 2.6]\n" +
                        "[3.7 4.8]"

        // When
        val result = matrix.toString()

        // Then
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `Test if transponse method return with the correct matrix`() {
        // Given
        val matrix = Matrix.float(arrayOf(1.5f, 2.6f, 3.7f, 4.8f, 5.9f, 6.0f), 3)
        val expected = 6f


        // When
        val result = matrix.transponse()[1, 2]

        // Then
        assertThat(result).isEqualTo(expected)
    }
}