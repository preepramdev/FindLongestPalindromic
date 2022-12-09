package domain

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class FindLongestStringListUseCaseTest {

    private lateinit var useCase: FindLongestStringListUseCase

    @BeforeEach
    fun setup() {
        useCase = FindLongestStringListUseCaseImpl()
    }

    @Test
    fun `test get empty list when given input is empty list`() {

        // Given
        val mockStringList = emptyList<String>()

        // When
        val result = useCase.execute(mockStringList)

        // Then
        assert(result.isEmpty())
    }

    @Test
    fun `test get list which size is 1 when there is only one longest string`() {

        // Given
        val mockStringList = listOf("a", "ab", "abc")

        // When
        val result = useCase.execute(mockStringList)

        // Then
        assert(result.isNotEmpty())
        assert(result.size == 1)
        assert(result.contains("abc"))
    }

    @Test
    fun `test get list which size is 2 when there are two longest string`() {

        // Given
        val mockStringList = listOf("a", "ab", "abc", "bcd")

        // When
        val result = useCase.execute(mockStringList)

        // Then
        assert(result.isNotEmpty())
        assert(result.size == 2)
        assert(result.contains("abc"))
        assert(result.contains("bcd"))
    }
}